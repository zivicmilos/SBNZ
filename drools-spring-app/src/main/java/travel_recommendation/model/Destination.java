package travel_recommendation.model;

import java.util.List;

public class Destination {
    private Weather weather;
    private List<DestinationType> destinationTypes;
    private Location location;

    private List<TransportationType> transportationTypes;
    private double score;

    public Destination() {
    }

    public Destination(Weather weather, List<DestinationType> destinationTypes, Location location, List<TransportationType> transportationTypes) {
        this.weather = weather;
        this.destinationTypes = destinationTypes;
        this.location = location;
        this.transportationTypes = transportationTypes;
        this.score = 0;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public List<DestinationType> getDestinationTypes() {
        return destinationTypes;
    }

    public void setDestinationTypes(List<DestinationType> destinationTypes) {
        this.destinationTypes = destinationTypes;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<TransportationType> getTransportationTypes() {
        return transportationTypes;
    }

    public void setTransportationTypes(List<TransportationType> transportationTypes) {
        this.transportationTypes = transportationTypes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
