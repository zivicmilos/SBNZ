package travel_recommendation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDate;

public class Travel {
    @JsonBackReference
    private User user;
    private Destination destination;
    private LocalDate travelDate;
    private TransportationType transportationType;
    private int grade;
    private int cost;

    public Travel(User user, Destination destination, LocalDate travelDate, TransportationType transportationType, int grade, int cost) {
        this.user = user;
        this.destination = destination;
        this.travelDate = travelDate;
        this.transportationType = transportationType;
        this.grade = grade;
        this.cost = cost;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public TransportationType getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(TransportationType transportationType) {
        this.transportationType = transportationType;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
