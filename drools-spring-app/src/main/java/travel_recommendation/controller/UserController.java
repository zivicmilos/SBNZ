package travel_recommendation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import travel_recommendation.model.*;
import travel_recommendation.service.DestinationService;
import travel_recommendation.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private static Logger log = LoggerFactory.getLogger(DestinationController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
