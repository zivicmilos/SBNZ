package travel_recommendation.repository;

import java.time.LocalDate;
import travel_recommendation.model.*;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static User user;
    private List<Destination> destinations;

    public Repository() {
        this.initRepository();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    private void initRepository() {
        this.user = new User("Petar", "Petrovic", LocalDate.of(1996, 5, 5), Status.STUDENT,
                new Location("Novi Sad", "Serbia", "Europe", new Coordinates(45.267136, 19.833549)));

        this.destinations = new ArrayList<Destination>();

        this.destinations.add(new Destination(Weather.WARM, new ArrayList<DestinationType>() {{
            add(DestinationType.OFFSHORE); add(DestinationType.ENERGETIC); add(DestinationType.PARTY);
        }}, new Location("Corfu", "Greece", "Europe", new Coordinates(39.621590, 19.915163)), new ArrayList<>() {{
            add(TransportationType.CAR); add(TransportationType.BUS);
        }}));

        this.destinations.add(new Destination(Weather.NEUTRAL, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.PARTY);
        }}, new Location("Paris", "France", "Europe", new Coordinates(48.864716, 2.349014)), new ArrayList<>() {{
            add(TransportationType.CAR); add(TransportationType.BUS); add(TransportationType.PLANE); add(TransportationType.TRAIN);
        }}));

        this.destinations.add(new Destination(Weather.COLD, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.HISTORIC);
        }}, new Location("Saint Petersburg", "Russia", "Europe", new Coordinates(59.901221, 30.374976)), new ArrayList<>() {{
            add(TransportationType.CAR); add(TransportationType.BUS); add(TransportationType.PLANE); add(TransportationType.TRAIN);
        }}));
    }
}
