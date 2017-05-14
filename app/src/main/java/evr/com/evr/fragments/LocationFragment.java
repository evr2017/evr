package evr.com.evr.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import evr.com.evr.R;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_location, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.textView1);
        textView.setText(getClass().getSimpleName());
        return rootView;
    }

}
