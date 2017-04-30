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

/**
 * Created by karenmatias on 30/04/2017.
 */

public class DiscoverGridViewAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater inflater;
    List<DiscoverSection> sections;

    public DiscoverGridViewAdapter(Context c, List<DiscoverSection> sections) {
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

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_gridview_item, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.gridview_item_imageView);
        TextView textView = (TextView) convertView.findViewById(R.id.gridview_item_textView);

        DiscoverSection section = (DiscoverSection) getItem(position);
        imageView.setImageResource(section.getImageId());
        textView.setText(section.getTitle());

        return convertView;
    }
}