package evr.com.evr.utils;

import java.util.ArrayList;
import java.util.List;

import evr.com.evr.R;
import evr.com.evr.models.DiscoverSection;

/**
 * Created by karenmatias on 30/04/2017.
 */

public class Stubs {

    public static List<DiscoverSection> getDiscoverSections(){
        List<DiscoverSection> discoverSections = new ArrayList<>();

        discoverSections.add(new DiscoverSection("Rooms", R.drawable.sample_image));
        discoverSections.add(new DiscoverSection("Restaurant", R.drawable.sample_image));
        discoverSections.add(new DiscoverSection("Entertainment", R.drawable.sample_image));

        return discoverSections;
    }
}

