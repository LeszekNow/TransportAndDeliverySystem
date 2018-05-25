package com.leszeknowinski.comparators;

import com.leszeknowinski.GPS.Location;

import java.util.Comparator;

public class LongitudeComparator implements Comparator<Location> {
    public int compare(Location location1, Location location2) {
        if(location1.getLongitude() < location2.getLongitude()){
            return 1;
        }
        if(location1.getLongitude() > location2.getLongitude()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
