package evr.com.evr.utils;

import java.util.ArrayList;
import java.util.List;

import evr.com.evr.R;
import evr.com.evr.models.DiscoverSection;
import evr.com.evr.models.HomeSection;

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
}

