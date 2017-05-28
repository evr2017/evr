package evr.com.evr.models;

import org.json.JSONObject;

import evr.com.evr.enums.DiscoverItemPreview;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class DiscoverItem {

    private DiscoverItemPreview preview;
    private String name;
    private String url;

    public DiscoverItem() {
    }

    public DiscoverItem(JSONObject response, DiscoverItemPreview preview) {
        this.preview = preview;
        setName(response.optString("name"));
        setUrl(response.optString("url"));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiscoverItemPreview getPreview() {
        return preview;
    }

    public void setPreview(DiscoverItemPreview preview) {
        this.preview = preview;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
