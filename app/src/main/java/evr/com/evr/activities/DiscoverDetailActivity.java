package evr.com.evr.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import evr.com.evr.R;
import evr.com.evr.adapters.RoomFeaturesRecyclerAdapter;
import evr.com.evr.models.DiscoverItem;
import evr.com.evr.models.VRPhoto;
import evr.com.evr.utils.Constants;

public class DiscoverDetailActivity extends BaseActivity {

    @BindView(R.id.content_image)
    protected ImageView previewImage;

    @BindView(R.id.title)
    protected TextView title;

    @BindView(R.id.room_features_recycler_view)
    protected RecyclerView roomFeaturesRecycler;

    @BindView(R.id.room_rating)
    protected RatingBar ratingBar;

    @BindView(R.id.room_price_label)
    protected TextView roomPrice;

    @BindView(R.id.cardboard_view_icon)
    protected ImageView cardViewIcon;

    @BindView(R.id.btn_back)
    protected ImageView backButton;

    private ArrayList<VRPhoto> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover_detail_activity_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_back)
    protected void onBackButtonPressed() {
        onBackPressed();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        final DiscoverItem discoverItem = getIntent().getExtras().getParcelable(Constants.DISCOVER_ITEM);
        if (discoverItem != null) {
            title.setText(discoverItem.getName());
            ratingBar.setRating(Float.valueOf(discoverItem.getRating()));
            roomPrice.setText(String.format("Price: %s", discoverItem.getPrice()));
            Glide.with(this).load(discoverItem.getUrl()).into(previewImage);
            String[] features = discoverItem.getDetails().split("\\|");
            RoomFeaturesRecyclerAdapter adapter = new RoomFeaturesRecyclerAdapter(features);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            roomFeaturesRecycler.setLayoutManager(llm);
            roomFeaturesRecycler.setAdapter(adapter);
            cardViewIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(discoverItem.getVrViewURL());
                    CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
                    intentBuilder.enableUrlBarHiding();
                    CustomTabsIntent customTabsIntent = intentBuilder.build();
                    customTabsIntent.launchUrl(DiscoverDetailActivity.this, uri);
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
