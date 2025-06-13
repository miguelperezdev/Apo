package model.incident;

public class IncidentRow {
    private final String id;
    private final String type;
    private final String priority;
    private final long timeResolved;
    private final int score;
    private final String assignedVehicle;

    public IncidentRow(String id, String type, String priority,
                       long timeResolved, int score, String assignedVehicle) {
        this.id = id;
        this.type = type;
        this.priority = priority;
        this.timeResolved = timeResolved;
        this.score = score;
        this.assignedVehicle = assignedVehicle != null ? assignedVehicle : "N/A";
    }

    // Getters
    public String getId() { return id; }
    public String getType() { return type; }
    public String getPriority() { return priority; }
    public long getTimeResolved() { return timeResolved; }
    public int getScore() { return score; }
    public String getAssignedVehicle() { return assignedVehicle; }
}