package evr.com.evr.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import evr.com.evr.R;
import evr.com.evr.fragments.AboutUsFragment;
import evr.com.evr.fragments.DiscoverFragment;
import evr.com.evr.fragments.HomeFragment;
import evr.com.evr.fragments.LocationFragment;

/**
 * Created by daryl.t.rollon on 5/2/2017.
 */

public class MenuActivity extends BaseActivity {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {

                            case R.id.action_item1:
                                //Prevents fragment from being recreated if it's the current active.
                                if (!(currentFragment instanceof HomeFragment)) {
                                    selectedFragment = HomeFragment.newInstance();
                                }
                                break;
                            case R.id.action_item2:
                                if (!(currentFragment instanceof AboutUsFragment)) {
                                    selectedFragment = AboutUsFragment.newInstance();
                                }
                                break;
                            case R.id.action_item3:
                                if (!(currentFragment instanceof LocationFragment)) {
                                    selectedFragment = LocationFragment.newInstance();
                                }
                                break;
                            case R.id.action_item4:
                                if (!(currentFragment instanceof DiscoverFragment)) {
                                    selectedFragment = DiscoverFragment.newInstance();
                                }
                                break;
                        }

                        if (selectedFragment != null) {
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_layout, selectedFragment);
                            transaction.commit();
                        }

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
