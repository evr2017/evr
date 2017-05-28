package evr.com.evr.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import evr.com.evr.R;
import evr.com.evr.models.Restaurant;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class FoodAndDiningRecyclerAdapter extends RecyclerView.Adapter<FoodAndDiningRecyclerAdapter.RestaurantsViewHolder> {

    private List<Restaurant> restaurantList;

    public FoodAndDiningRecyclerAdapter(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public RestaurantsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.discover_item_image_row, parent, false);
        return new RestaurantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantsViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.restaurantName.setText(restaurant.getRestaurantName());
        Glide.with(holder.itemView.getContext())
                .load(restaurant.getThumbnail())
                .into(holder.restaurantImage);
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class RestaurantsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.header_row_label)
        protected TextView restaurantName;

        @BindView(R.id.go_icon)
        protected ImageView goIcon;

        @BindView(R.id.content_image)
        protected ImageView restaurantImage;

        public RestaurantsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
