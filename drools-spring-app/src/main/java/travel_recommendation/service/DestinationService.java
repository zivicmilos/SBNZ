package travel_recommendation.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_recommendation.dto.LikeDto;
import travel_recommendation.model.*;
import travel_recommendation.repository.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
            /*for (Like l : d.getLikes()) {
                kieSession.insert(l);
            }*/
        }

        kieSession.getAgenda().getAgendaGroup("add-transportation-types").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("grade-destinations").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("grade-destinations-budget").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("grade-destinations-combined-rules").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("transportation_related_rules").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("user_activity_rules").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("update_user_rank").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("discount_by_user_rank").setFocus();
        kieSession.fireAllRules();
        /*kieSession.getAgenda().getAgendaGroup("check_likes").setFocus();
        kieSession.fireAllRules();*/
        kieSession.dispose();

        destinations.sort(Comparator.comparing(Destination::getScore).reversed());

        return destinations;
    }

    public String like(LikeDto like) {
        List<String> list = new ArrayList<>();
        KieSession kieSession = kieContainer.newKieSession();

        Destination d = repository.getDestinationByName(like.getDestination());
        d.addLike(new Like(repository.getUserByUsername(like.getUser()), d, like.getTime()));

        for (Destination des : repository.getDestinations()) {
            for (Like l : d.getLikes()) {
                kieSession.insert(l);
            }
        }
        kieSession.setGlobal( "myGlobalList", list );

        kieSession.getAgenda().getAgendaGroup("check_likes").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();

        if (!list.isEmpty() && list.get(0).equals("Too many likes within the hour")) {
            d.getLikes().remove(d.getLikes().size() - 1);
            return list.get(0);
        }
        return "Ok";
    }
}
