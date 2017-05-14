package evr.com.evr.activities;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.util.List;

import evr.com.evr.R;
import evr.com.evr.models.VRPhoto;
import evr.com.evr.utils.Constants;

/**
 * Created by sf.jerome.w.catalon on 14/05/2017.
 */

public class VRNavigationActivity extends AppCompatActivity {


    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private VrPanoramaView panoWidgetView;

    private List<VRPhoto> vrPhotos;
    private VRPhoto currentVRPhoto;
    private int currentPosition;

    /**
     * Configuration information for the panorama.
     **/
    private VrPanoramaView.Options panoOptions = new VrPanoramaView.Options();

    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vr_mode);
        mContentView = findViewById(R.id.fullscreen_content);
        panoWidgetView = (VrPanoramaView) findViewById(R.id.pano_view);
        panoWidgetView.setEventListener(new VREventListener());
        panoOptions.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;

        vrPhotos = getIntent().getParcelableArrayListExtra(Constants.VR_PHOTOS);
        currentPosition = getIntent().getIntExtra(Constants.POSITION, -1);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        updatePhotoInVRViewer();

        delayedHide();
    }

    private void updatePhotoInVRViewer() {

        if (vrPhotos != null && currentPosition != -1 && currentPosition < (vrPhotos.size())) {
            currentVRPhoto = vrPhotos.get(currentPosition);
        } else {
            finish();
        }

        if (currentVRPhoto != null) {
            Glide.with(this)
                    .load(currentVRPhoto.getFullImageUrl())
                    .asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    panoWidgetView.loadImageFromBitmap(resource, panoOptions);
                }
            });
        }
    }

    private void delayedHide() {
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @Override
    protected void onPause() {
        panoWidgetView.pauseRendering();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        panoWidgetView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        // Destroy the widget and free memory.
        panoWidgetView.shutdown();
        super.onDestroy();
    }

    private class VREventListener extends VrPanoramaEventListener {

        @Override
        public void onClick() {
            super.onClick();
            ++currentPosition;
            updatePhotoInVRViewer();
        }

        @Override
        public void onLoadError(String errorMessage) {
            Toast.makeText(VRNavigationActivity.this, "Error loading pano: " + errorMessage, Toast.LENGTH_LONG).show();
            Log.e(getClass().getSimpleName(), "Error loading pano: " + errorMessage);
        }
    }
}
