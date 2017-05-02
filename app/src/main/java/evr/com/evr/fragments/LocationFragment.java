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
import android.widget.TextView;

import evr.com.evr.R;
import evr.com.evr.activities.VrModeActivity;
import evr.com.evr.adapters.DiscoverGridViewAdapter;
import evr.com.evr.utils.Stubs;

/**
 * Created by karenmatias on 30/04/2017.
 */

public class LocationFragment extends Fragment {

    public LocationFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment newInstance() {
        Fragment fragment = new LocationFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_location, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.textView1);
        textView.setText(getClass().getSimpleName());
        return rootView;
    }

}
