package travel_recommendation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_recommendation.model.Destination;
import travel_recommendation.model.Travel;
import travel_recommendation.model.User;
import travel_recommendation.repository.Repository;

import java.util.List;

@Service
public class UserService {
    private final Repository repository;

    @Autowired
    public UserService(Repository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.getUsers();
    }

    public User login(User user) {
        List<User> users = repository.getUsers();
        return users.stream().filter(u->u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())).findFirst().orElse(null);
    }

    public List<Travel> getTravelsByUsername(String username) {
        return repository.getUserByUsername(username).getTravels();
    }

    public void cancelTravel(Travel travel) {
        List<Travel> travels = repository.getUserByUsername(travel.getDestination().getUsername()).getTravels();
        travels.removeIf(t -> t.getDestination().getLocation().getCity().equals(travel.getDestination().getLocation().getCity()) && t.getTravelDate().equals(travel.getTravelDate()));
    }
}
