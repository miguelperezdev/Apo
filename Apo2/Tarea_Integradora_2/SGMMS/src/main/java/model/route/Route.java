package model.route;

public class Route {
    private String id;
    private double distance;
    private int estimatedTime;
    private String start;
    private String end;

    public Route(String id, double distance, int estimatedTime, String start, String end) {
        this.id = id;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.start = start;
        this.end = end;

    }

    public String getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

}