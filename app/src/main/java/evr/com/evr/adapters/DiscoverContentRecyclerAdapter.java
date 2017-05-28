package evr.com.evr.adapters;

import android.content.Intent;
import android.net.Uri;
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
import evr.com.evr.enums.DiscoverItemPreview;
import evr.com.evr.models.DiscoverItem;
import evr.com.evr.models.DiscoverVideo;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class DiscoverContentRecyclerAdapter extends RecyclerView.Adapter<DiscoverContentRecyclerAdapter.DiscoverViewHolder> {

    private List<DiscoverItem> accomodations;

    public DiscoverContentRecyclerAdapter(List<DiscoverItem> discoverItems) {
        this.accomodations = discoverItems;
    }

    @Override
    public DiscoverViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.discover_item_image_row, parent, false);
        return new DiscoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DiscoverViewHolder holder, final int position) {

        final DiscoverItem discoverItem = accomodations.get(position);
        holder.headerRowLabel.setText(discoverItem.getName());
        if (accomodations.get(position).getPreview() == DiscoverItemPreview.VIDEO) {

            String previewUrl = "http://img.youtube.com/vi/"+ ((DiscoverVideo) discoverItem).getVideoId()+"/0.jpg";
            Glide.with(holder.itemView.getContext())
                    .load(previewUrl)
                    .centerCrop()
                    .into(holder.previewImage);

            holder.video_play_icon.setVisibility(View.VISIBLE);
            holder.video_play_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( discoverItem.getUrl()));
                    intent.putExtra("force_fullscreen",true);
                    holder.itemView.getContext().startActivity(intent);
                }
            });
        } else {
            Glide.with(holder.itemView.getContext())
                    .load(discoverItem.getUrl())
                    .into(holder.previewImage);
            holder.video_play_icon.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return accomodations.size();
    }

    public class DiscoverViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.header_row_label)
        protected TextView headerRowLabel;

        @BindView(R.id.go_icon)
        protected ImageView goIcon;

        @BindView(R.id.content_image)
        protected ImageView previewImage;

        @BindView(R.id.video_play_icon)
        protected ImageView video_play_icon;

        public DiscoverViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}