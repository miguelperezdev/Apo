package model.route;

import java.time.LocalDateTime;

public class ActiveRoute extends Route implements Comparable<ActiveRoute> {
    private LocalDateTime startTime;
    private LocalDateTime estimatedArrival;
    private RouteStatus status;
    private String assignedVehicleId;
    private String incidentId; // Relación con incidente

    public ActiveRoute(Route baseRoute, String assignedVehicleId, String incidentId,
                       LocalDateTime startTime, int additionalTime) {
        super(baseRoute.getId(), baseRoute.getDistance(),
                baseRoute.getEstimatedTime() + additionalTime,
                baseRoute.getStart(), baseRoute.getEnd());
        this.startTime = startTime;
        this.estimatedArrival = startTime.plusMinutes(getEstimatedTime());
        this.status = RouteStatus.ACTIVE;
        this.assignedVehicleId = assignedVehicleId;
        this.incidentId = incidentId;
    }

    @Override
    public int compareTo(ActiveRoute other) {
        return this.startTime.compareTo(other.startTime);
    }

    // Getters y setters adicionales
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEstimatedArrival() {
        return estimatedArrival;
    }

    public RouteStatus getStatus() {
        return status;
    }

    public void setStatus(RouteStatus status) {
        this.status = status;
    }

    public String getAssignedVehicleId() {
        return assignedVehicleId;
    }

    public String getIncidentId() {
        return incidentId;
    }
}