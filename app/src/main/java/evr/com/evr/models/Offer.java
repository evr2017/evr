package evr.com.evr.models;

/**
 * Created by karenmatias on 22/05/2017.
 */

public class Offer {
    private int previewImageId;
    private int imageId;

    public Offer(int previewImageId, int imageId){
        this.imageId = imageId;
        this.previewImageId = previewImageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getPreviewImageId() {
        return previewImageId;
    }

    public void setPreviewImageId(int previewImageId) {
        this.previewImageId = previewImageId;
    }
}
