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
import evr.com.evr.adapters.FoodAndDiningRecyclerAdapter;
import evr.com.evr.models.Restaurant;
import evr.com.evr.utils.Stubs;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class FoodAndDiningFragment extends Fragment {

    @BindView(R.id.discover_recycler)
    protected RecyclerView foodAndDiningRecycler;

    private List<Restaurant> restaurantList;

    public static FoodAndDiningFragment newInstance() {
        return new FoodAndDiningFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_section_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        restaurantList = Stubs.getRestaurantList(getActivity());
        FoodAndDiningRecyclerAdapter adapter = new FoodAndDiningRecyclerAdapter(restaurantList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        foodAndDiningRecycler.setLayoutManager(llm);
        foodAndDiningRecycler.setAdapter(adapter);
    }


}
