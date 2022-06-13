package travel_recommendation.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_recommendation.model.*;
import travel_recommendation.repository.Repository;

import java.util.Comparator;
import java.util.List;

@Service
public class DestinationService {

    private static Logger log = LoggerFactory.getLogger(DestinationService.class);
    private final Repository repository;
    private final KieContainer kieContainer;

    @Autowired
    public DestinationService(KieContainer kieContainer, Repository repository) {
        log.info("Initialising a new session.");
        this.kieContainer = kieContainer;
        this.repository = repository;
    }

    public List<Destination> getDestinationList(String username, TransportationType transportationType, double budget,
                                                DestinationType destinationType, Weather weather, String continent) {
        KieSession kieSession = kieContainer.newKieSession();

        List<User> users = repository.getUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setBudget(budget);
                user.setTransportationType(transportationType);
                user.setDestinationType(destinationType);
                user.setWeather(weather);
                user.setContinent(continent);
            }
            kieSession.insert(user);
        }

        List<Destination> destinations = repository.getDestinations();
        for (Destination d : destinations) {
            d.setUsername(username);
            kieSession.insert(d);
        }

        kieSession.getAgenda().getAgendaGroup("add-transportation-types").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("grade-destinations").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("grade-destinations-budget").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("grade-destinations-complex").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("transportation_related_rules").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("user_activity_rules").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("update_user_rank").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("discount_by_user_rank").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();

        destinations.sort(Comparator.comparing(Destination::getScore).reversed());

        return destinations;
    }
}
