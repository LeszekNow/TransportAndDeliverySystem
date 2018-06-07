package com.leszeknowinski.GPS;

import java.util.*;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class LocationRepository {

    private Set<Location> nodes = new HashSet<>();

    private List<Location> shortestRoute = new LinkedList<>();

    Map<Location, Double>adjacentNodes = new HashMap<>();

    public void addDestination(Location destinationPoint, double distance){
        adjacentNodes.put(destinationPoint, distance);
    }

    public void addLocation(Location location){
        nodes.add(location);
    }

    public void addMidPoint(Location location){
        shortestRoute.add(location);
    }

    public Set<Location> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Location> nodes) {
        this.nodes = nodes;
    }

    public List<Location> getShortestRoute() {
        return shortestRoute;
    }

    public void setShortestRoute(List<Location> shortestRoute) {
        this.shortestRoute = shortestRoute;
    }
}
