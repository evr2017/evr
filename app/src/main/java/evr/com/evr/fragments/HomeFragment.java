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

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }

    public static Fragment newInstance() {
        Fragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.textView1);
        textView.setText(getClass().getSimpleName());
        return rootView;
    }
}

