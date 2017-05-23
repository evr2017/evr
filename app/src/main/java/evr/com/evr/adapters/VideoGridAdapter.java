package evr.com.evr.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import evr.com.evr.R;
import evr.com.evr.models.FeaturedVideo;

/**
 * Created by karenmatias on 23/05/2017.
 */

public class VideoGridAdapter extends RecyclerView.Adapter<VideoGridAdapter.SimpleViewHolder>{

    private Context context;
    private List<FeaturedVideo> featuredVideos;

    public VideoGridAdapter(Context context, List<FeaturedVideo> videos){
        this.context = context;
        this.featuredVideos = videos;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView, playIcon;

        public SimpleViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.gridview_item_imageView);
            playIcon = (ImageView) view.findViewById(R.id.video_play_icon);
            playIcon.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public VideoGridAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.layout_horizontal_grid_item, parent, false);
        return new VideoGridAdapter.SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoGridAdapter.SimpleViewHolder holder, final int position) {
        Picasso.with(context).load("http://img.youtube.com/vi/"+ featuredVideos.get(position).getVideoId()+"/0.jpg").resize(600, 200).centerCrop().into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(featuredVideos.get(position).getVideoUrl()));
                intent.putExtra("force_fullscreen",true);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.featuredVideos.size();
    }
}
