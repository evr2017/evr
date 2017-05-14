package evr.com.evr.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import evr.com.evr.R;
import evr.com.evr.models.VRPhoto;

/**
 * Created by sf.jerome.w.catalon on 14/05/2017.
 */

public class VRPhotoPagerAdapter extends PagerAdapter {

    private ArrayList<VRPhoto> vrPhotos;

    private CardBoardViewClickListener cardBoardViewClickListener;

    public interface CardBoardViewClickListener {
        void onCardBoardViewClicked(int position);
    }

    public VRPhotoPagerAdapter(ArrayList<VRPhoto> vrPhotos, CardBoardViewClickListener cardBoardViewClickListener) {
        this.vrPhotos = vrPhotos;
        this.cardBoardViewClickListener = cardBoardViewClickListener;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        Context context = container.getContext();

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.discover_detail_photo_item, container, false);

        ImageView vrPhoto = (ImageView) itemView.findViewById(R.id.discover_detail_grid_item);
        Glide.with(context).load(vrPhotos.get(position).getFullImageUrl()).into(vrPhoto);

        if (cardBoardViewClickListener != null) {
            ImageView cardBoardView = (ImageView) itemView.findViewById(R.id.cardboard_view_icon);
            cardBoardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cardBoardViewClickListener.onCardBoardViewClicked(position);
                }
            });
        }

        container.addView(itemView);

        return itemView;
    }

    @Override
    public int getCount() {
        return vrPhotos.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
