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

    private final KieContainer kieContainer;

    @Autowired
    public DestinationService(KieContainer kieContainer) {
        log.info("Initialising a new session.");
        this.kieContainer = kieContainer;

    }

    public List<Destination> getDestinationList(TransportationType transportationType, double budget,
                                                DestinationType destinationType, Weather weather, String continent) {
        KieSession kieSession = kieContainer.newKieSession();
        Repository repository = new Repository();

        User user = repository.getUser();
        user.setBudget(budget);
        user.setTransportationType(transportationType);
        user.setDestinationType(destinationType);
        user.setWeather(weather);
        user.setContinent(continent);

        List<Destination> destinations = repository.getDestinations();
        kieSession.insert(user);
        for (Destination d : destinations)
            kieSession.insert(d);
        kieSession.getAgenda().getAgendaGroup("add-transportation-types").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("grade-destinations").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("grade-destinations-budget").setFocus();
        kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("grade-destinations-complex").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();

        destinations.sort(Comparator.comparing(Destination::getScore).reversed());

        return destinations;
    }
}
