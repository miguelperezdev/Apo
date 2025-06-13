package model.incident;

import model.vehicle.Priority;
import model.vehicle.PriorityLevel;

import java.time.LocalDateTime;
import java.util.UUID;

public class Incident {
    private final String id;
    private IncidentType type;
    private Location location;
    private final LocalDateTime creationDate;
    private LocalDateTime resolutionDate;
    private String description;
    private StateOfIncident state;
    private PriorityLevel priority;
    private String assignedVehicleId;
    private boolean isResolved;


    /**
     * Constructor para crear un nuevo incidente
     * @param type Tipo de incidente
     * @param location Ubicación del incidente
     * @param description Descripción detallada
     * @param priority Prioridad del incidente
     */
    public Incident(IncidentType type, Location location, String description, PriorityLevel priority) {
        this.id = generateId();
        this.type = type;
        this.location = location;
        this.creationDate = LocalDateTime.now();
        this.description = description;
        this.state = StateOfIncident.PENDING;
        this.priority = priority;
        this.isResolved = false;
    }

    private String generateId() {
        return "INC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    /**
     * Asigna un vehículo al incidente y cambia su estado
     * @param vehicleId ID del vehículo asignado
     */
    public void assignVehicle(String vehicleId) {
        this.assignedVehicleId = vehicleId;
        this.state = StateOfIncident.ASSIGNED;
    }

    /**
     * Marca el incidente como resuelto
     */
    public void resolve() {
        this.state = StateOfIncident.RESOLVED;
        this.resolutionDate = LocalDateTime.now();
        this.assignedVehicleId = null;
    }

    public long getElapsedMinutes() {
        return java.time.Duration.between(creationDate, LocalDateTime.now()).toMinutes();
    }

    public String getId() {
        return id;
    }

    public IncidentType getType() {
        return type;
    }

    public void setType(IncidentType type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getResolutionDate() {
        return resolutionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StateOfIncident getState() {
        return state;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public void setPriority(PriorityLevel priority) {
        this.priority = priority;
    }

    public String getAssignedVehicleId() {
        return assignedVehicleId;
    }

    public double distanceTo(Location other) {
        double dx = this.location.getX() - other.getX();
        double dy = this.location.getY() - other.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
    public boolean isResolved() {
        return isResolved;
    }


    @Override
    public String toString() {
        return String.format(
                "[%s] %s | Prioridad: %s | Estado: %s | Ubicación: %s",
                id,
                formatType(type),
                priority,
                state,
                location != null ? location.getExactAddress() : "Sin ubicación"
        );
    }

    private String formatType(IncidentType type) {
        return switch (type) {
            case ROBBERY -> "Robo";
            case FIRE -> "Incendio";
            case ACCIDENT -> "Accidente";
        };
    }


    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }

    public void setResolutionDate(LocalDateTime resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public void setState(StateOfIncident state) {
        this.state = state;
    }

    public void setAssignedVehicleId(String assignedVehicleId) {
        this.assignedVehicleId = assignedVehicleId;
    }


    public void setTimeReported(LocalDateTime minus) {
    }

    public void setTimeResolved(LocalDateTime now) {
    }

    public void setId(String s) {
    }
}
