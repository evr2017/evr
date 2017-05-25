package evr.com.evr.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import evr.com.evr.R;
import evr.com.evr.adapters.OffersGridAdapter;
import evr.com.evr.adapters.VideoGridAdapter;
import evr.com.evr.utils.Stubs;

/**
 * Created by karenmatias on 30/04/2017.
 */

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    public HomeFragment() {
    }

    private SliderLayout mDemoSlider;
    private HorizontalGridView offersGridView, videoGridView;

    public static Fragment newInstance() {
        Fragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mDemoSlider = (SliderLayout) rootView.findViewById(R.id.slider);

        offersGridView = (HorizontalGridView) rootView.findViewById(R.id.gridView_offers);
        videoGridView = (HorizontalGridView) rootView.findViewById(R.id.gridView_videos);

        OffersGridAdapter offersGridAdapter = new OffersGridAdapter(getActivity(), Stubs.getOffers());
        VideoGridAdapter videoGridAdapter = new VideoGridAdapter(getActivity(), Stubs.getFeaturedVideos());
        offersGridView.setAdapter(offersGridAdapter);
        videoGridView.setAdapter(videoGridAdapter);


        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Watch Coldplay Live", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Ironman360 experience available", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("Visit Available Rooms", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Watch Coldplay Live",R.drawable.car_coldplay);
        file_maps.put("Ironman360 experience available",R.drawable.car_ironman);
        file_maps.put("Visit Available Rooms",R.drawable.car_room);

        for(String name : file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(HomeFragment.this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(HomeFragment.this);
        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

