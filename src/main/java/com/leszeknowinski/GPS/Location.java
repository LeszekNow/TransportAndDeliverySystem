package com.leszeknowinski.GPS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Location {
    private int id;
    private String city;
    private double longitude;
    private double latitude;

    private List<Location> shortestRoute = new LinkedList<>();
    Map<Location, Double> adjacentNodes = new HashMap<>();
    private double distance = Double.MAX_VALUE;



    public Location(String city, double longitude, double latitude) {
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(int id, String city, double longitude, double latitude) {
        this.id = id;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public List<Location> getShortestRoute() {
        return shortestRoute;
    }

    public void setShortestRoute(List<Location> shortestRoute) {
        this.shortestRoute = shortestRoute;
    }

    public Map<Location, Double> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Location, Double> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Location(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location: id - " + id + ", city - " + city + ", longitude - " + longitude + ", latitude - " + latitude;
    }
}
