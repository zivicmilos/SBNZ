package travel_recommendation.model;

import java.time.LocalDate;

public class User {
    private String name;
    private String lastname;
    private LocalDate dateOfBirth;
    private Status status;
    private Location location;
    private TransportationType transportationType;
    private DestinationType destinationType;
    private Weather weather;
    private String continent;
    private double budget;

    public User() {
    }

    public User(String name, String lastname, LocalDate dateOfBirth, Status status, Location location) {
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.location = location;
        this.destinationType = DestinationType.NA;
        this.transportationType = TransportationType.NA;
        this.weather = Weather.NA;
        this.continent = "";
        this.budget = 0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public TransportationType getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(TransportationType transportationType) {
        this.transportationType = transportationType;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getAge() {
        return LocalDate.now().getYear() - this.dateOfBirth.getYear();
    }

    public DestinationType getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(DestinationType destinationType) {
        this.destinationType = destinationType;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Weather getUserWeather() {
        int month = LocalDate.now().getMonth().getValue();
        if (this.location.getContinent().equals("Europe") || this.location.getContinent().equals("Asia") || this.location.getContinent().equals("North America")) {
            if (month <= 2 || month == 12) return Weather.COLD;
            else if (month >= 6 && month <= 8) return Weather.WARM;
            else return Weather.NEUTRAL;
        }
        else if (this.location.getContinent().equals("Australia") || this.location.getContinent().equals("South America")) {
            if (month <= 2 || month == 12) return Weather.WARM;
            else if (month >= 6 && month <= 8) return Weather.COLD;
            else return Weather.NEUTRAL;
        }
        else return Weather.WARM;
    }
}
