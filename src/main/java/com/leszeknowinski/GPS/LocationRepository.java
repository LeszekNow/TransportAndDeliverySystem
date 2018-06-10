package com.leszeknowinski.GPS;

import java.util.*;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class LocationRepository {

    public Set<Location> locations = new HashSet<>();


    public void addLocation(Location location){
        locations.add(location);
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setNodes(Set<Location> locations) {
        this.locations = locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }
}
