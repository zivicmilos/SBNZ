package travel_recommendation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String lastname;
    private LocalDate dateOfBirth;
    private Status status;
    private Location location;
    private List<TransportationType> transportationTypes;
    private double budget;

    public User() {
    }

    public User(String name, String lastname, LocalDate dateOfBirth, Status status, Location location) {
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.location = location;
        this.transportationTypes = new ArrayList<TransportationType>();
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

    public List<TransportationType> getTransportationTypes() {
        return transportationTypes;
    }

    public void setTransportationTypes(List<TransportationType> transportationTypes) {
        this.transportationTypes = transportationTypes;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int years() {
        return LocalDate.now().getYear() - this.dateOfBirth.getYear();
    }
}
