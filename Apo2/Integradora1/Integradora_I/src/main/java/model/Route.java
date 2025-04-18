package model;

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

    public void setId(String id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
    return "Route: " + id + "| distance: " + distance + " | estimated time: " + estimatedTime + " | start point: " + start + " | end point: " + end;
    }

}

