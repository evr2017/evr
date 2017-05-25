package evr.com.evr.utils;

import java.util.ArrayList;
import java.util.List;

import evr.com.evr.R;
import evr.com.evr.models.DiscoverSection;
import evr.com.evr.models.FeaturedVideo;
import evr.com.evr.models.HomeSection;
import evr.com.evr.models.Offer;

/**
 * Created by karenmatias on 30/04/2017.
 */

public class Stubs {

    public static List<DiscoverSection> getDiscoverSections(){
        List<DiscoverSection> discoverSections = new ArrayList<>();

        discoverSections.add(new DiscoverSection("Food and Dining", R.drawable.menu_1));
        discoverSections.add(new DiscoverSection("Active and Outdoor", R.drawable.menu_2));
        discoverSections.add(new DiscoverSection("Events", R.drawable.menu_3));
        discoverSections.add(new DiscoverSection("Accommodation", R.drawable.menu_4));
        discoverSections.add(new DiscoverSection("Museum", R.drawable.menu_5));
        discoverSections.add(new DiscoverSection("Parks", R.drawable.menu_6));

        return discoverSections;
    }

    public static List<HomeSection> getHomeSections(){
        List<HomeSection> homeSections = new ArrayList<>();

        homeSections.add(new HomeSection("Offer 1", R.drawable.planet_earth));
        homeSections.add(new HomeSection("Offer 2", R.drawable.jupiter));
        homeSections.add(new HomeSection("Offer 3", R.drawable.solar_system));
        homeSections.add(new HomeSection("Offer 4", R.drawable.startup));

        return homeSections;
    }

    public static List<Offer> getOffers(){
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer(R.drawable.prev_offer1, R.drawable.offer1));
        offers.add(new Offer(R.drawable.prev_offer2, R.drawable.offer2));
        offers.add(new Offer(R.drawable.prev_offer3, R.drawable.offer3));
        offers.add(new Offer(R.drawable.prev_offer4, R.drawable.offer4));

        return offers;
    }

    public static List<FeaturedVideo> getFeaturedVideos(){
        List<FeaturedVideo> featuredVideos = new ArrayList<>();
        featuredVideos.add(new FeaturedVideo("MdcrZFpNjTA", "https://www.youtube.com/watch?v=MdcrZFpNjTA"));
        featuredVideos.add(new FeaturedVideo("1LZnpWjpXzw", "https://www.youtube.com/watch?v=1LZnpWjpXzw"));
        featuredVideos.add(new FeaturedVideo("Wc4kOe_ZfBk", "https://www.youtube.com/watch?v=Wc4kOe_ZfBk"));
        featuredVideos.add(new FeaturedVideo("-xNN-bJQ4vI", "https://www.youtube.com/watch?v=-xNN-bJQ4vI"));
        featuredVideos.add(new FeaturedVideo("6Vze-ARrG5o", "https://www.youtube.com/watch?v=6Vze-ARrG5o"));

        return featuredVideos;
    }


}

