package travel_recommendation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_recommendation.model.Destination;
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
}
