package evr.com.evr.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import evr.com.evr.R;
import evr.com.evr.activities.OfferDetailActivity;
import evr.com.evr.models.Offer;

/**
 * Created by karenmatias on 22/05/2017.
 */

public class OffersGridAdapter extends RecyclerView.Adapter<OffersGridAdapter.SimpleViewHolder>{

    private Context context;
    private List<Offer> elements;

    public OffersGridAdapter(Context context, List<Offer> offers){
        this.context = context;
        this.elements = offers;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;

        public SimpleViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.gridview_item_imageView);
        }
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.layout_horizontal_grid_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        holder.imageView.setImageResource(elements.get(position).getPreviewImageId());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent offerIntent = new Intent(context, OfferDetailActivity.class);
                offerIntent.putExtra("offer_image", elements.get(position).getImageId());
                context.startActivity(offerIntent);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.elements.size();
    }
}