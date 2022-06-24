package tests;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import travel_recommendation.model.LoginFailure;
import travel_recommendation.model.User;

public class CepTests {
    private KieContainer kContainer;
    public CepTests() {
        KieServices ks = KieServices.Factory.get();
        kContainer = ks
                .newKieContainer(ks.newReleaseId("travel_recommendation", "drools-spring-kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(10_000);
    }

    @Test
    public void testLoginFailing() {
        KieSession kieSession = kContainer.newKieSession();
        kieSession.insert(new LoginFailure(new User()));
        kieSession.insert(new LoginFailure(new User()));
        kieSession.insert(new LoginFailure(new User()));
        kieSession.insert(new LoginFailure(new User()));
        kieSession.insert(new LoginFailure(new User()));

        kieSession.getAgenda().getAgendaGroup("check_likes").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
