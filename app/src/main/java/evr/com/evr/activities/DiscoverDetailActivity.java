package evr.com.evr.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import evr.com.evr.R;
import evr.com.evr.adapters.VRPhotoPagerAdapter;
import evr.com.evr.models.VRPhoto;
import evr.com.evr.utils.Constants;

public class DiscoverDetailActivity extends AppCompatActivity {

    @BindView(R.id.vr_photos_viewpager)
    protected ViewPager vrPhotosViewPager;

    @BindView(R.id.title)
    protected TextView title;

    @BindView(R.id.btn_back)
    protected ImageView backButton;

    @BindView(R.id.cardboard_view_icon)
    protected ImageView cardBoardVewIcon;

    private ArrayList<VRPhoto> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover_detail_activity_layout);
        ButterKnife.bind(this);

        String sectionName = getIntent().getExtras().getString(Constants.EXTRA_SECTION_NAME);
        title.setText(sectionName);

    }

    @OnClick(R.id.btn_back)
    protected void onBackButtonPressed() {
        onBackPressed();
    }

    @OnClick(R.id.cardboard_view_icon)
    protected void showCardBoardViewOfImage() {
        Intent intent = new Intent(this, VRNavigationActivity.class);
        intent.putExtra(Constants.VR_PHOTOS, photos);
        intent.putExtra(Constants.POSITION, vrPhotosViewPager.getCurrentItem());
        startActivity(intent);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        generateDummyVRPhotos();

        initializeViewPager();

    }

    private void initializeViewPager() {

        VRPhotoPagerAdapter adapter = new VRPhotoPagerAdapter(photos);
        vrPhotosViewPager.setAdapter(adapter);
        vrPhotosViewPager.setClipToPadding(false);

        //For offset view
        int paddingInPx = getPxFromDp(20);
        vrPhotosViewPager.setPadding(paddingInPx, 0, paddingInPx, 0);
        int marginInPx = getPxFromDp(5);
        vrPhotosViewPager.setPageMargin(marginInPx);
    }

    private int getPxFromDp(int dps) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dps, getResources().getDisplayMetrics()));
    }

    private void generateDummyVRPhotos() {
        photos = new ArrayList<>();

        String[] paths = new String[]{
                "file:///android_asset/andes.jpg",
                "file:///android_asset/vrview-mono-stereo.jpg"
        };

        for (int i = 0; i < paths.length; i++) {
            VRPhoto photo = new VRPhoto();
            photo.setFullImageUrl(paths[i]);
            photos.add(photo);
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
