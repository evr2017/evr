package evr.com.evr.fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import evr.com.evr.R;
import evr.com.evr.activities.DiscoverDetailActivity;
import evr.com.evr.adapters.DiscoverContentRecyclerAdapter;
import evr.com.evr.interfaces.DiscoverClickListener;
import evr.com.evr.models.DiscoverItem;
import evr.com.evr.utils.Constants;
import evr.com.evr.utils.Stubs;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class DiscoverContentFragment extends Fragment implements View.OnClickListener {

    private List<DiscoverItem> discoverItems;

    @BindView(R.id.discover_recycler)
    protected RecyclerView discoverRecycler;

    @BindView(R.id.from_date)
    protected TextView fromDate;

    @BindView(R.id.to_date)
    protected TextView toDate;

    @BindView(R.id.filter_button)
    protected Button filterButton;


    private Calendar toCalendar = Calendar.getInstance();
    private Calendar fromCalendar = Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    private DiscoverContentRecyclerAdapter adapter;

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
            fromDate.setText(sdf.format(fromCalendar.getTime()));
            toCalendar.setTimeInMillis(getFarthestAvailableDate());
            toDate.setText(sdf.format(toCalendar.getTime()));
            updateRoomList(discoverItems);

            fromDate.setOnClickListener(this);
            toDate.setOnClickListener(this);
            filterButton.setOnClickListener(this);

        }
    }

    private Long getFarthestAvailableDate() {
        Long toDate = 0L;
        for (int i = 0; i < discoverItems.size(); i++) {
            Long until = discoverItems.get(i).getAvailableUntil();
            toDate = toDate < until ? until : toDate;
        }
        return toDate;
    }

    private void updateRoomList(List<DiscoverItem> discoverItems) {
        if (adapter == null) {
            adapter = new DiscoverContentRecyclerAdapter(discoverItems, new DiscoverClickListener() {
                @Override
                public void onDiscoverItemClicked(DiscoverItem discoverItem) {
                    Intent intent = new Intent(getActivity(), DiscoverDetailActivity.class);
                    intent.putExtra(Constants.DISCOVER_ITEM, discoverItem);
                    startActivity(intent);
                }
            });
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            discoverRecycler.setLayoutManager(llm);
            discoverRecycler.setAdapter(adapter);
        } else {
            adapter.updateList(discoverItems);
        }
    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == fromDate.getId() || v.getId() == toDate.getId()) {
            final Calendar calendar = v.getId() == fromDate.getId() ? fromCalendar : toCalendar;
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    ((TextView) v).setText(sdf.format(calendar.getTime()));
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            datePickerDialog.show();
        } else if (v.getId() == filterButton.getId()) {
            List<DiscoverItem> copy = new ArrayList<>();
            for (int i = 0; i < discoverItems.size(); i++) {
                DiscoverItem discoverItem = discoverItems.get(i);
                if (discoverItem.getAvailableUntil() >= toCalendar.getTimeInMillis()) {
                    copy.add(discoverItem);
                }
            }
            updateRoomList(copy);
        }
    }
    
    @OnClick(R.id.vr_view_button)
    protected void viewInVR() {
        Uri uri = Uri.parse("https://evrviewer.firebaseapp.com");
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
        intentBuilder.enableUrlBarHiding();
        CustomTabsIntent customTabsIntent = intentBuilder.build();
        customTabsIntent.launchUrl(getContext(), uri);
    }
}
