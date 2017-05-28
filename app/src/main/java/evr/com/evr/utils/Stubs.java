package evr.com.evr.utils;

import android.content.Context;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import evr.com.evr.R;
import evr.com.evr.enums.DiscoverItemPreview;
import evr.com.evr.models.DiscoverItem;
import evr.com.evr.models.DiscoverSection;
import evr.com.evr.models.DiscoverVideo;
import evr.com.evr.models.FeaturedVideo;
import evr.com.evr.models.HomeSection;
import evr.com.evr.models.Offer;
import evr.com.evr.models.Restaurant;

/**
 * Created by karenmatias on 30/04/2017.
 */

public class Stubs {

    public static List<DiscoverSection> getDiscoverSections() {
        List<DiscoverSection> discoverSections = new ArrayList<>();

        discoverSections.add(new DiscoverSection("Food and Dining", R.drawable.menu_1));
        discoverSections.add(new DiscoverSection("Active and Outdoor", R.drawable.menu_2));
        discoverSections.add(new DiscoverSection("Events", R.drawable.menu_3));
        discoverSections.add(new DiscoverSection("Accommodation", R.drawable.menu_4));
        discoverSections.add(new DiscoverSection("Museum", R.drawable.menu_5));
        discoverSections.add(new DiscoverSection("Parks", R.drawable.menu_6));

        return discoverSections;
    }

    public static List<HomeSection> getHomeSections() {
        List<HomeSection> homeSections = new ArrayList<>();

        homeSections.add(new HomeSection("Offer 1", R.drawable.planet_earth));
        homeSections.add(new HomeSection("Offer 2", R.drawable.jupiter));
        homeSections.add(new HomeSection("Offer 3", R.drawable.solar_system));
        homeSections.add(new HomeSection("Offer 4", R.drawable.startup));

        return homeSections;
    }

    public static List<Offer> getOffers() {
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer(R.drawable.prev_offer1, R.drawable.offer1));
        offers.add(new Offer(R.drawable.prev_offer2, R.drawable.offer2));
        offers.add(new Offer(R.drawable.prev_offer3, R.drawable.offer3));
        offers.add(new Offer(R.drawable.prev_offer4, R.drawable.offer4));

        return offers;
    }


    public static List<DiscoverItem> getListForDiscoverSection(Context context, String section) {
        List<DiscoverItem> items = new ArrayList<>();
        switch (section) {
            case "Food and Dining":
                //TODO: Improve Food and Dining items implementation
                break;
            case "Active and Outdoor":
                items = getAccommodationList(context, "stubresponses/active_and_outdoors.json", "outdoors");
                break;
            case "Events":
                items = getAccommodationList(context, "stubresponses/events.json", "events");
                break;
            case "Accommodation":
                items = getAccommodationList(context, "stubresponses/accommodations.json", "accommodations");
                break;
            case "Museum":
                items = getAccommodationList(context, "stubresponses/museum.json", "museum");
                break;
            case "Parks":
                break;
        }
        return items;
    }

    public static List<DiscoverItem> getAccommodationList(Context context, String path, String key) {

        List<DiscoverItem> discoverItems = new ArrayList<>();
        String responseStr = Stubs.loadJSONFromAsset(context, path);
        JSONObject response;
        try {
            response = new JSONObject(responseStr);
            JSONArray array = response.getJSONArray(key);
            if (array != null) {
                for (int i = 0; i < array.length(); i++) {
                    JSONObject accommodationJSON = array.getJSONObject(i);
                    String preview = accommodationJSON.optString("preview");

                    if (TextUtils.isEmpty(preview)) {
                        continue;
                    }

                    if (preview.equalsIgnoreCase("image")) {
                        DiscoverItem img = new DiscoverItem(accommodationJSON, DiscoverItemPreview.IMAGE);
                        discoverItems.add(img);
                    } else {
                        DiscoverVideo vid = new DiscoverVideo(accommodationJSON, DiscoverItemPreview.VIDEO);
                        discoverItems.add(vid);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return discoverItems;
    }

    public static List<Restaurant> getRestaurantList(Context context) {

        List<Restaurant> restaurants = new ArrayList<>();
        String responseStr = Stubs.loadJSONFromAsset(context, "stubresponses/restaurants.json");
        JSONObject response;
        try {
            response = new JSONObject(responseStr);
            JSONArray array = response.getJSONArray("restaurants");
            if (array != null) {
                for (int i = 0; i < array.length(); i++) {
                    JSONObject restaurantJSON = array.getJSONObject(i);
                    Restaurant restaurant = new Restaurant(restaurantJSON);
                    restaurants.add(restaurant);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return restaurants;
    }

    public static List<FeaturedVideo> getFeaturedVideos() {
        List<FeaturedVideo> featuredVideos = new ArrayList<>();
        featuredVideos.add(new FeaturedVideo("MdcrZFpNjTA", "https://www.youtube.com/watch?v=MdcrZFpNjTA"));
        featuredVideos.add(new FeaturedVideo("1LZnpWjpXzw", "https://www.youtube.com/watch?v=1LZnpWjpXzw"));
        featuredVideos.add(new FeaturedVideo("Wc4kOe_ZfBk", "https://www.youtube.com/watch?v=Wc4kOe_ZfBk"));
        featuredVideos.add(new FeaturedVideo("-xNN-bJQ4vI", "https://www.youtube.com/watch?v=-xNN-bJQ4vI"));
        featuredVideos.add(new FeaturedVideo("6Vze-ARrG5o", "https://www.youtube.com/watch?v=6Vze-ARrG5o"));

        return featuredVideos;
    }

    public static String loadJSONFromAsset(Context context, String path) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

