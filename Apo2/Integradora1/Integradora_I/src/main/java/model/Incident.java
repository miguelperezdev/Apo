package model;
import java.time.LocalDateTime;

public class Incident {
    private String id;
    private String type;
    private String location;
    private LocalDateTime dateTime;
    private String description;
    private StateOfIncident status;

    public Incident(String id, String type, String location, LocalDateTime dateTime, String description, StateOfIncident status){
        this.id = id;
        this.type = type;
        this.location = location;
        this.dateTime = dateTime;
        this.description= description;
        this.status= status;
    }

    public String getIdIncident() {
        return id;
    }

    public void setIdIncident(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StateOfIncident getStatus() {
        return status;
    }

    public void setStatus(StateOfIncident status) {
        this.status = status;
    }
    @Override
    public String toString(){
        return "Incident: " + id + " | type: " + type + " | location: " + location + " | dateTime: " + dateTime + " | description: " + description + " | status: " + status;
    }
}
