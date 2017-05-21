package evr.com.evr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import evr.com.evr.R;
import evr.com.evr.models.DiscoverSection;
import evr.com.evr.models.HomeSection;

/**
 * Created by karenmatias on 30/04/2017.
 */

public class HomeGridViewAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater inflater;
    List<HomeSection> sections;

    public HomeGridViewAdapter(Context c, List<HomeSection> sections) {
        mContext = c;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.sections = sections;
    }

    public int getCount() {
        return sections.size();
    }

    public Object getItem(int position) {
        return sections.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_gridview_item_home, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.grid_image);
        TextView textView = (TextView) convertView.findViewById(R.id.grid_text);

        HomeSection section = (HomeSection) getItem(position);
        imageView.setImageResource(section.getImageId());
        textView.setText(section.getTitle());

        return convertView;
    }
}