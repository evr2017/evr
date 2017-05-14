package evr.com.evr.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sf.jerome.w.catalon on 14/05/2017.
 */

public class VRPhoto implements Parcelable {

    //Can be used for specific navigation. Placeholder for now
    private String id;

    /**
     * Image url of 360 photo, to be used for VR viewing.
     */
    private String fullImageUrl;

    /**
     * Image url of 360 photo preview, to be used for gallery viewing.
     */
    private String previewImageUrl;

    /**
     * Title/label of picture
     */
    private String title;

    /**
     * Tag of the photo to determine what section(s) the photo should appear
     */
    private String tag;

    public VRPhoto() {
    }

    protected VRPhoto(Parcel in) {
        id = in.readString();
        fullImageUrl = in.readString();
        previewImageUrl = in.readString();
        title = in.readString();
        tag = in.readString();
    }

    public static final Creator<VRPhoto> CREATOR = new Creator<VRPhoto>() {
        @Override
        public VRPhoto createFromParcel(Parcel in) {
            return new VRPhoto(in);
        }

        @Override
        public VRPhoto[] newArray(int size) {
            return new VRPhoto[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullImageUrl() {
        return fullImageUrl;
    }

    public void setFullImageUrl(String fullImageUrl) {
        this.fullImageUrl = fullImageUrl;
    }

    public String getPreviewImageUrl() {
        return previewImageUrl;
    }

    public void setPreviewImageUrl(String previewImageUrl) {
        this.previewImageUrl = previewImageUrl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(fullImageUrl);
        parcel.writeString(previewImageUrl);
        parcel.writeString(title);
        parcel.writeString(tag);
    }
}
