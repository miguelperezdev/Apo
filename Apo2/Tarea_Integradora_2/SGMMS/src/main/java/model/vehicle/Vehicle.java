package model.vehicle;

import structure.Graph;
import structure.Node;
import structure.PathFinder;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;
import model.incident.Incident;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Vehicle {
    protected double x, y;
    protected double speed;
    protected Direction direction;
    protected Map<Direction, List<Image>> animations = new HashMap<>();
    protected int currentFrame = 0;
    protected boolean available = true;
    protected boolean active = true;

    protected Incident incident;
    protected PriorityLevel priority;
    protected Graph graph;

    private List<Node> route;
    private int routeIndex;

    public Vehicle(double x, double y, double speed, PriorityLevel priority) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = Direction.DOWN;
        this.priority = priority;
    }

    protected abstract void loadSprites();

    public boolean isAvailable() {
        return available;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getX() { return x; }
    public double getY() { return y; }


    public Rectangle2D getBounds() {
        return new Rectangle2D(x + 4, y + 4, 24, 24);
    }

    public void assignIncident(Incident inc, Graph graph) {
        this.incident = inc;
        this.available = false;
        this.graph = graph;
        Node start = graph.getClosestNode(x, y);
        Node dest = inc.getLocation().getAssociatedNode();
        this.route = PathFinder.findShortestPath(graph, start, dest);
        this.routeIndex = 0;
        this.active = true;
    }

    public Incident getAssignedIncident() {
        return incident;
    }

    public void clearAssignedIncident() {
        this.incident = null;
    }

    public void clearRoute() {
        this.route = null;
        this.routeIndex = 0;
    }

    public boolean hasReachedDestination() {
        return route != null && routeIndex >= route.size();
    }

    public void setRoute(List<Node> route) {
        this.route = route;
        this.routeIndex = 0;
    }

    public void updateAnimation() {
        currentFrame++;
    }

    public Image getSpriteFrame() {
        List<Image> frames = animations.get(direction);
        if (frames == null || frames.isEmpty()) return null;
        return frames.get(currentFrame % frames.size());
    }

    public void moveStep() {
        if (!active) return;

        if (route != null && routeIndex < route.size()) {
            Node next = route.get(routeIndex);
            double dx = next.getX() - x;
            double dy = next.getY() - y;
            double dist = Math.hypot(dx, dy);

            if (Math.abs(dx) > Math.abs(dy)) {
                direction = dx > 0 ? Direction.RIGHT : Direction.LEFT;
            } else {
                direction = dy > 0 ? Direction.DOWN : Direction.UP;
            }

            if (dist <= speed) {
                x = next.getX();
                y = next.getY();
                routeIndex++;
            } else {
                x += (dx / dist) * speed;
                y += (dy / dist) * speed;
            }
        } else if (incident != null) {
            incident.resolve();
            clearAssignedIncident();
            clearRoute();
            available = true;
        }
    }
}
