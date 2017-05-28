package evr.com.evr.models;

import org.json.JSONObject;

import evr.com.evr.enums.DiscoverItemPreview;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class DiscoverVideo extends DiscoverItem {

    private String videoId;

    public DiscoverVideo(JSONObject accommodationJSON, DiscoverItemPreview image) {
        super(accommodationJSON, image);
        setVideoId(accommodationJSON.optString("videoId"));
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
