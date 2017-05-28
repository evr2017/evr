package evr.com.evr.models;

import org.json.JSONObject;

import evr.com.evr.utils.Constants;

/**
 * Created by sf.jerome.w.catalon on 28/05/2017.
 */

public class Restaurant {

    private String restaurantName;
    private String description;
    private String operatingHours;
    private String address;
    private String thumbnail;
    private String contactNumber;

    public Restaurant() {}

    public Restaurant(JSONObject response) {
        setRestaurantName(response.optString("restaurantName", Constants.EMPTY_STRING));
        setDescription(description = response.optString("description", Constants.EMPTY_STRING));
        setOperatingHours(operatingHours = response.optString("operatingHours", Constants.EMPTY_STRING));
        setAddress(address = response.optString("address", Constants.EMPTY_STRING));
        setThumbnail(thumbnail = response.optString("thumbnail", Constants.EMPTY_STRING));
        setContactNumber(contactNumber = response.optString("contactNumber", Constants.EMPTY_STRING));
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
