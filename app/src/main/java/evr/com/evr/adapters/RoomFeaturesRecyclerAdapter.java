package evr.com.evr.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import evr.com.evr.R;

/**
 * Created by sf.jerome.w.catalon on 16/07/2017.
 */

public class RoomFeaturesRecyclerAdapter extends RecyclerView.Adapter<RoomFeaturesRecyclerAdapter.FeatureViewHolder> {

    private String[] features;

    public RoomFeaturesRecyclerAdapter(String[] features) {
        this.features = features;
    }

    @Override
    public FeatureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_feature_item_layout, parent, false);
        return new FeatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeatureViewHolder holder, int position) {
        holder.roomFeature.setText(features[position]);
    }

    @Override
    public int getItemCount() {
        return features.length;
    }

    public class FeatureViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.room_feature_item)
        protected TextView roomFeature;

        public FeatureViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
