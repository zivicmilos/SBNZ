package travel_recommendation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Like {
    @JsonIgnoreProperties({"name", "lastname", "password", "email", "dateOfBirth", "status", "location", "userRank",
            "travels", "transportationType", "destinationType", "weather", "continent", "budget", "age", "userWeather"})
    private User user;
    private LocalDateTime time;

    public Like(User user, LocalDateTime time) {
        this.user = user;
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isLikedToday() {
        return this.time.toLocalDate().equals(LocalDate.now());
    }


}
