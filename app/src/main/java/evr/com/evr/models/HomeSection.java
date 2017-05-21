package evr.com.evr.models;

/*

 */

public class HomeSection {

    private String title;
    private int imageId;

    public HomeSection(String title, int imageId){
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
