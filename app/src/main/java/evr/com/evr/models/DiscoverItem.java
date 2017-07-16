package evr.com.evr.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import evr.com.evr.enums.DiscoverItemPreview;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class DiscoverItem implements Parcelable {

    private DiscoverItemPreview preview;
    private String name;
    private String url;
    private String details;
    private String rating;
    private String price;
    private String vrViewURL;
    private Long availableFrom;
    private Long availableUntil;

    public DiscoverItem() {
    }

    public DiscoverItem(JSONObject response, DiscoverItemPreview preview) {
        this.preview = preview;
        setName(response.optString("name"));
        setUrl(response.optString("url"));
        setDetails(response.optString("details"));
        setRating(response.optString("rating"));
        setPrice(response.optString("price"));
        setVrViewURL(response.optString("vrViewURL"));
        setAvailableFrom(response.optLong("availableFrom", 0L));
        setAvailableUntil(response.optLong("availableUntil", 0L));
    }

    protected DiscoverItem(Parcel in) {
        name = in.readString();
        url = in.readString();
        details = in.readString();
        rating = in.readString();
        price = in.readString();
        vrViewURL = in.readString();
        availableFrom = in.readLong();
        availableUntil = in.readLong();
    }

    public static final Creator<DiscoverItem> CREATOR = new Creator<DiscoverItem>() {
        @Override
        public DiscoverItem createFromParcel(Parcel in) {
            return new DiscoverItem(in);
        }

        @Override
        public DiscoverItem[] newArray(int size) {
            return new DiscoverItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiscoverItemPreview getPreview() {
        return preview;
    }

    private void setPreview(DiscoverItemPreview preview) {
        this.preview = preview;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetails() {
        return details;
    }

    private void setDetails(String details) {
        this.details = details;
    }

    public String getRating() {
        return rating;
    }

    private void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    private void setPrice(String price) {
        this.price = price;
    }

    public String getVrViewURL() {
        return vrViewURL;
    }

    private void setVrViewURL(String vrViewURL) {
        this.vrViewURL = vrViewURL;
    }

    public Long getAvailableFrom() {
        return availableFrom;
    }

    private void setAvailableFrom(Long availableFrom) {
        this.availableFrom = availableFrom;
    }

    public long getAvailableUntil() {
        return availableUntil;
    }

    private void setAvailableUntil(long availableUntil) {
        this.availableUntil = availableUntil;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(details);
        dest.writeString(rating);
        dest.writeString(price);
        dest.writeString(vrViewURL);
        dest.writeLong(availableFrom);
        dest.writeLong(availableUntil);
    }
}
