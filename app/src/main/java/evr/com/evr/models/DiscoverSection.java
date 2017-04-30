package evr.com.evr.models;

/**
 * Created by karenmatias on 30/04/2017.
 */

public class DiscoverSection {

    private String title;
    private int imageId;

    public DiscoverSection(String title, int imageId){
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
