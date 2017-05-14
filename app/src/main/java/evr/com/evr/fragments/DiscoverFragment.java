package evr.com.evr.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import evr.com.evr.R;
import evr.com.evr.activities.DiscoverDetailActivity;
import evr.com.evr.activities.DiscoverSectionActivity;
import evr.com.evr.activities.VrModeActivity;
import evr.com.evr.activities.VrWebViewActivity;
import evr.com.evr.adapters.DiscoverGridViewAdapter;
import evr.com.evr.models.DiscoverSection;
import evr.com.evr.utils.Constants;
import evr.com.evr.utils.Stubs;

/**
 * Created by karenmatias on 30/04/2017.
 */

public class DiscoverFragment extends Fragment {

    public DiscoverFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment newInstance() {
        Fragment fragment = new DiscoverFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discover, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridView gridview = (GridView) getView().findViewById(R.id.gridview);
        Button vrButton = (Button) getView().findViewById(R.id.vrButton);
        gridview.setAdapter(new DiscoverGridViewAdapter(getActivity(), Stubs.getDiscoverSections()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Intent discoverSectionIntent = new Intent(getActivity(), DiscoverSectionActivity.class);
                Intent discoverSectionIntent = new Intent(getActivity(), DiscoverDetailActivity.class);
                DiscoverSection section = (DiscoverSection) parent.getAdapter().getItem(position);
                discoverSectionIntent.putExtra(Constants.EXTRA_SECTION_NAME, section.getTitle());
                startActivity(discoverSectionIntent);
            }
        });


        vrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent vrModeIntent = new Intent(getActivity(), VrWebViewActivity.class);
                Intent vrModeIntent = new Intent(getActivity(), VrModeActivity.class);
                //Intent vrModeIntent = new Intent(getActivity(), DiscoverDetailActivity.class);
                startActivity(vrModeIntent);
            }
        });


    }
}
