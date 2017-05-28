package evr.com.evr.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import evr.com.evr.R;
import evr.com.evr.adapters.DiscoverContentRecyclerAdapter;
import evr.com.evr.models.DiscoverItem;
import evr.com.evr.utils.Constants;
import evr.com.evr.utils.Stubs;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class DiscoverContentFragment extends Fragment {

    private List<DiscoverItem> discoverItems;

    @BindView(R.id.discover_recycler)
    protected RecyclerView discoverRecycler;

    public static DiscoverContentFragment newInstance(String section) {
        DiscoverContentFragment discoverContentFragment = new DiscoverContentFragment();
        Bundle args = new Bundle();
        args.putString(Constants.EXTRA_SECTION_NAME, section);
        discoverContentFragment.setArguments(args);
        return discoverContentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_section_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            String section = getArguments().getString(Constants.EXTRA_SECTION_NAME, Constants.EMPTY_STRING);
            discoverItems = Stubs.getListForDiscoverSection(getActivity(), section);
            DiscoverContentRecyclerAdapter adapter = new DiscoverContentRecyclerAdapter(discoverItems);
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            discoverRecycler.setLayoutManager(llm);
            discoverRecycler.setAdapter(adapter);
        }


    }
}
