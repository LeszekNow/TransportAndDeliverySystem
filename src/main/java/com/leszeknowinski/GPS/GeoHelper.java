package com.leszeknowinski.GPS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class GeoHelper {

    // double el1, double el2 elevation above sea level
    public double getDistanceInKM(double lat1, double lat2, double lon1, double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        // elevation double height = el1 - el2;

        distance = Math.pow(distance, 2); // + Math.pow(height, 2);

        return (Math.sqrt(distance)) / 1000;
    }

    public String calculateTimeFromDistance(double distance) {
        //avg speed in km/h
        int avgSpeed = 70;
        double base = distance / avgSpeed;
        int hours = (int) base;
        double modulo = base - hours;
        double f = modulo * 60;
        int minutes = (int) f;
        return hours + " hours and " + minutes + " minutes.";
    }


    public double getLongitude(String cityName) {
        return getDoubleFromDB("SELECT longitude FROM tlocation WHERE city = '" + cityName + "';", "longitude");
    }

    public double getLongitude(int id) {
        return getDoubleFromDB("SELECT longitude FROM tlocation WHERE id = " + id + ";", "longitude");
    }

    public double getLatitude(String cityName) {
        return getDoubleFromDB("SELECT latitude FROM tlocation WHERE city = '" + cityName + "';", "latitude");
    }

    public double getLatitude(int id) {
        return getDoubleFromDB("SELECT latitude FROM tlocation WHERE id = " + id + ";", "latitude");
    }

    public double getDoubleFromDB(String sqlAccess, String label) {
        ResultSet resultSet = null;
        Statement statement = null;
        double d = 0;
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlAccess);
            while (resultSet.next()) {
                d = resultSet.getDouble(label);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    public void insertLocation(Location location) {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO tlocation (city, longitude, latitude)" +
                    "VALUES (?, ?, ?);");
            preparedStatement.setString(1, location.getCity());
            preparedStatement.setDouble(2, location.getLongitude());
            preparedStatement.setDouble(3, location.getLatitude());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getIdOfAllLocations() {
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT id FROM tlocation;");
            while (resultSet.next()) {
                int locationId = resultSet.getInt("id");
                list.add(locationId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Location> getAllLocations() {
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Location> list = new ArrayList<Location>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tlocation;");
            while (resultSet.next()) {
                Location location = new Location();
                location.setId(resultSet.getInt("id"));
                location.setCity(resultSet.getString("city"));
                location.setLongitude(resultSet.getDouble("longitude"));
                location.setLatitude(resultSet.getDouble("latitude"));
                list.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Location> getAllLocations(String sqlQuery) {
        ResultSet resultSet = null;
        Statement statement = null;
        List<Location> list = new ArrayList<>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Location location = new Location();
                location.setId(resultSet.getInt("id"));
                location.setCity(resultSet.getString("city"));
                location.setLongitude(resultSet.getDouble("longitude"));
                location.setLatitude(resultSet.getDouble("latitude"));
                list.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String setDirection(double startLat, double endLat, double startLon, double endLon) {
        String direction = "";
        double factor = 2.0;
        if (startLat == endLat) {
            if (startLon > endLon) {
                direction = "W";
            } else {
                direction = "E";
            }
        } else if (startLon == endLon) {
            if (startLat > endLat) {
                direction = "S";
            } else {
                direction = "N";
            }
        } else if (startLat > endLat && startLon > endLon) {
            direction = "SW";
        } else if (startLat > endLat && startLon < endLon) {
            direction = "SE";
        } else if (startLat < endLat && startLon > endLon) {
            direction = "NW";
        } else if (startLat < endLat && startLon < endLon) {
            direction = "NE";
        }
        return direction;

    }

    public Location getLocation(String city) {
        ResultSet resultSet = null;
        Statement statement = null;
        Location location = new Location();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tlocation WHERE city = '" + city + "';");
            while (resultSet.next()) {
                location.setId(resultSet.getInt("id"));
                location.setCity(resultSet.getString("city"));
                location.setLongitude(resultSet.getDouble("longitude"));
                location.setLatitude(resultSet.getDouble("latitude"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }

    public Location getLocation(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Location location = new Location();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tlocation WHERE id = " + id + ";");
            while (resultSet.next()) {
                location.setId(resultSet.getInt("id"));
                location.setCity(resultSet.getString("city"));
                location.setLongitude(resultSet.getDouble("longitude"));
                location.setLatitude(resultSet.getDouble("latitude"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }

    public Location setClosestLocation(List<Location> list, Location start, Location end) {
        double distance;
        Location startLocation = start;
        List<Location>locations = list;
        Location closestLocation = locations.get(0);
        double minDistance = getDistanceInKM(startLocation.getLatitude(), closestLocation.getLatitude(), startLocation.getLongitude(), closestLocation.getLongitude());
            for (int i = 1; i < list.size(); i++) {
                distance = getDistanceInKM(startLocation.getLatitude(), locations.get(i).getLatitude(), startLocation.getLongitude(), locations.get(i).getLongitude());
                if (distance < minDistance) {
                    minDistance = distance;
                    closestLocation = locations.get(i);
                }
            }
        return closestLocation;
    }

    public Set<Location> calculateShortestPathFromSource(Set<Location>set, Location start) {
        start.setDistance(0.0);
        Set<Location> settledLocations = new HashSet<>();
        Set<Location> unsettledLocations = new HashSet<>();

        unsettledLocations.add(start);

        while (unsettledLocations.size() != 0) {
            Location currentLocation = getLowestDistanceNode(unsettledLocations);
            unsettledLocations.remove(currentLocation);
            for (Map.Entry< Location, Double> adjacencyPair:
                    currentLocation.getAdjacentNodes().entrySet()) {
                Location adjacentLocation = adjacencyPair.getKey();
                Double edgeWeight = getDistanceInKM(start.getLatitude(), currentLocation.getLatitude(), start.getLongitude(), currentLocation.getLongitude());
                if (!settledLocations.contains(adjacentLocation)) {
                    calculateMinimumDistance(adjacentLocation, edgeWeight, currentLocation);
                    unsettledLocations.add(adjacentLocation);
                }
            }
            settledLocations.add(currentLocation);
        }
        return settledLocations;
    }

    private Location getLowestDistanceNode(Set < Location > unsettledLocations) {
        Location lowestDistanceLocation = null;
        Double lowestDistance = Double.MAX_VALUE;
        for (Location location: unsettledLocations) {
            double locationDistance = location.getDistance();
            if (locationDistance < lowestDistance) {
                lowestDistance = locationDistance;
                lowestDistanceLocation = location;
            }
        }
        return lowestDistanceLocation;
    }

    private void calculateMinimumDistance(Location evaluationLocation,
                                                 Double edgeWeigh, Location start) {
        Double startDistance = start.getDistance();
        if (startDistance + edgeWeigh < evaluationLocation.getDistance()) {
            evaluationLocation.setDistance(startDistance + edgeWeigh);
            LinkedList<Location> shortestRoute = new LinkedList<>(start.getShortestRoute());
            shortestRoute.add(start);
            evaluationLocation.setShortestRoute(shortestRoute);
        }
    }


}

