package evr.com.evr.models;

/**
 * Created by karenmatias on 23/05/2017.
 */

public class FeaturedVideo {
    private String videoId;
    private String videoUrl;


    public FeaturedVideo(String videoId, String videoUrl){
        this.videoId = videoId;
        this.videoUrl = videoUrl;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
