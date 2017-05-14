package evr.com.evr.activities;

import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import evr.com.evr.R;
import evr.com.evr.fragments.AboutUsFragment;
import evr.com.evr.fragments.DiscoverFragment;
import evr.com.evr.fragments.HomeFragment;
import evr.com.evr.fragments.LocationFragment;
import evr.com.evr.utils.Constants;
import android.support.annotation.NonNull;

/**
 * Created by daryl.t.rollon on 5/2/2017.
 */

public class MenuActivity extends AppCompatActivity{

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_main_navigation);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {

                            case R.id.action_item1:
                                selectedFragment = HomeFragment.newInstance();
                                break;
                            case R.id.action_item2:
                                selectedFragment = AboutUsFragment.newInstance();
                                break;
                            case R.id.action_item3:
                                selectedFragment = LocationFragment.newInstance();
                                break;
                            case R.id.action_item4:
                                selectedFragment = DiscoverFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

//        Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }


}
