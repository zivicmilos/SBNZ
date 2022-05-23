package travel_recommendation.repository;

import java.time.LocalDate;
import travel_recommendation.model.*;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private User user;
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
        }}, new Location("Corfu", "Greece", "Europe", new Coordinates(39.621590, 19.915163)),
                new ArrayList<>(){{ add(TransportationType.PLANE); }}));

        this.destinations.add(new Destination(Weather.NEUTRAL, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.PARTY);
        }}, new Location("Paris", "France", "Europe", new Coordinates(48.864716, 2.349014)),
                new ArrayList<>()));

        this.destinations.add(new Destination(Weather.COLD, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.HISTORIC);
        }}, new Location("Saint Petersburg", "Russia", "Europe", new Coordinates(59.901221, 30.374976)),
        new ArrayList<>()));

        this.destinations.add(new Destination(Weather.WARM, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.OFFSHORE); add(DestinationType.PARTY);
        }}, new Location("Dubai", "United Arab Emirates", "Asia", new Coordinates(25.202184, 55.287507)),
                new ArrayList<>()));

        this.destinations.add(new Destination(Weather.NEUTRAL, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.ENERGETIC); add(DestinationType.PARTY);
        }}, new Location("New York", "USA", "North America", new Coordinates(40.707560, -73.933030)), new ArrayList<>() {{

        }}));

        this.destinations.add(new Destination(Weather.WARM, new ArrayList<DestinationType>() {{
            add(DestinationType.RURAL); add(DestinationType.EXOTIC);
        }}, new Location("Bernal", "Mexico", "North America", new Coordinates(20.734589, -99.935713)), new ArrayList<>() {{

        }}));

        this.destinations.add(new Destination(Weather.WARM, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.ENERGETIC); add(DestinationType.PARTY);
        }}, new Location("Buenos Aires", "Argentine", "South America", new Coordinates(-34.665473, -58.422258)), new ArrayList<>() {{

        }}));

        this.destinations.add(new Destination(Weather.COLD, new ArrayList<DestinationType>() {{
            add(DestinationType.EXOTIC); add(DestinationType.RURAL);
        }}, new Location("Yakutsk", "Russia", "Asia", new Coordinates(62.039358, 129.596713)), new ArrayList<>() {{

        }}));

        this.destinations.add(new Destination(Weather.WARM, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.ENERGETIC); add(DestinationType.PARTY); add(DestinationType.HISTORIC);
        }}, new Location("Sydney", "Australia", "Australia", new Coordinates(-33.829896, 151.121902)), new ArrayList<>() {{

        }}));

        this.destinations.add(new Destination(Weather.NEUTRAL, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.PARTY);
        }}, new Location("Wellington", "New Zeland", "Australia", new Coordinates(-41.305072, 174.770091)), new ArrayList<>() {{
            add(TransportationType.PLANE);
        }}));

        this.destinations.add(new Destination(Weather.WARM, new ArrayList<DestinationType>() {{
            add(DestinationType.WILD); add(DestinationType.EXOTIC); add(DestinationType.ENERGETIC);
        }}, new Location("Antananarivo", "Madagascar", "Africa", new Coordinates(-18.857922, 47.515956)), new ArrayList<>() {{
            add(TransportationType.PLANE);
        }}));

        this.destinations.add(new Destination(Weather.NEUTRAL, new ArrayList<DestinationType>() {{
            add(DestinationType.URBAN); add(DestinationType.HISTORIC); add(DestinationType.PARTY);
        }}, new Location("Washington", "USA", "North America", new Coordinates(38.895547, -77.009903)), new ArrayList<>() {{

        }}));

        this.destinations.add(new Destination(Weather.WARM, new ArrayList<DestinationType>() {{
            add(DestinationType.EXOTIC); add(DestinationType.WILD);
        }}, new Location("Nouakchott", "Mauritania", "Africa", new Coordinates(18.078985, -15.978416)), new ArrayList<>() {{

        }}));
    }
}
