package travel_recommendation.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_recommendation.model.Destination;
import travel_recommendation.model.TransportationType;
import travel_recommendation.model.User;
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

    public List<Destination> getDestinationList(TransportationType transportationType, double budget) {
        KieSession kieSession = kieContainer.newKieSession();
        Repository repository = new Repository();
        User user = repository.getUser();
        user.setBudget(budget);
        List<TransportationType> userTransportationTypes = user.getTransportationTypes();
        userTransportationTypes.add(transportationType);
        user.setTransportationTypes(userTransportationTypes);
        List<Destination> destinations = repository.getDestinations();
        kieSession.insert(user);
        for (Destination d : destinations)
            kieSession.insert(d);
        kieSession.fireAllRules();
        kieSession.dispose();

        destinations.sort(Comparator.comparing(Destination::getScore).reversed());

        return destinations;
    }
}
