package travel_recommendation.dto;

import java.time.LocalDateTime;

public class LikeDto {
    private String user;
    private String destination;
    private LocalDateTime time;

    public LikeDto(String user, String destination, LocalDateTime time) {
        this.user = user;
        this.destination = destination;
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
