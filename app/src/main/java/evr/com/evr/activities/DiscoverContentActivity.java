package evr.com.evr.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import evr.com.evr.R;
import evr.com.evr.fragments.DiscoverContentFragment;
import evr.com.evr.fragments.FoodAndDiningFragment;
import evr.com.evr.utils.Constants;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class DiscoverContentActivity extends BaseActivity {

    @BindView(R.id.title)
    protected TextView title;

    private String sectionName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover_content_layout);
        ButterKnife.bind(this);

        sectionName = getIntent().getExtras().getString(Constants.EXTRA_SECTION_NAME);
        title.setText(sectionName);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.discover_content_container, getFragmentByTitle());
        ft.commit();
    }

    private Fragment getFragmentByTitle() {

        Fragment content = null;

        switch (sectionName) {
            case "Food and Dining":
                //TODO: Improve implementation of food and dining to be reusable like the cases below.
                content = FoodAndDiningFragment.newInstance();
                break;
            case "Active and Outdoor":
            case "Accommodation":
            case "Events":
            case "Museum":
            case "Parks":
                content = DiscoverContentFragment.newInstance(sectionName);
                break;
        }
        return content;
    }

    @OnClick(R.id.btn_back)
    protected void onBackButtonPressed() {
        onBackPressed();
    }
}
