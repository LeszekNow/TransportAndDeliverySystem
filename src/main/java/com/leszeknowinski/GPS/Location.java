package com.leszeknowinski.GPS;

public class Location {
    public int id;
    public String city;
    public double longitude;
    public double latitude;

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
