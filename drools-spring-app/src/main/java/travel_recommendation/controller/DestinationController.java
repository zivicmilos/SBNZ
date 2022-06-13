package travel_recommendation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import travel_recommendation.dto.LikeDto;
import travel_recommendation.model.*;
import travel_recommendation.service.DestinationService;

import java.util.List;

@RestController
public class DestinationController {
    private static Logger log = LoggerFactory.getLogger(DestinationController.class);

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @RequestMapping(value = "/destination", method = RequestMethod.GET, produces = "application/json")
    public List<Destination> getParameters(@RequestParam(required = true) String username,
                                           @RequestParam(required = true) TransportationType transportationType,
                                           @RequestParam(required = true) double budget,
                                           @RequestParam(required = true) DestinationType destinationType,
                                           @RequestParam(required = true) Weather weather,
                                           @RequestParam(required = true) String continent) {

        return destinationService.getDestinationList(username, transportationType, budget, destinationType, weather, continent);
    }

    @RequestMapping(value = "/like", method = RequestMethod.POST, consumes = "application/json")
    public void like(@RequestBody LikeDto like) {
        destinationService.like(like);
    }

}
