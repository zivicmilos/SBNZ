package travel_recommendation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import travel_recommendation.model.Destination;
import travel_recommendation.model.DestinationType;
import travel_recommendation.model.TransportationType;
import travel_recommendation.model.Weather;
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

}
