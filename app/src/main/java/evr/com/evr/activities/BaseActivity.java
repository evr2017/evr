package evr.com.evr.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import evr.com.evr.R;

/**
 * Created by sf.jerome.w.catalon on 15/05/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_right_anim, R.anim.slide_out_left_anim);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left_anim, R.anim.slide_out_right_anim);
    }
}
