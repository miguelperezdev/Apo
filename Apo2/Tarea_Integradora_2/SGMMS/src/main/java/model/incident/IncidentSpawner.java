package model.incident;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.vehicle.PriorityLevel;
import structure.Node;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class IncidentSpawner {
    private final Random rand = new Random();
    private final List<Node> houseNodes;
    private final PriorityQueue<Incident> incidentQueue;

    public IncidentSpawner(List<Node> houseNodes, PriorityQueue<Incident> queue) {
        this.houseNodes = houseNodes;
        this.incidentQueue = queue;
    }

    public void start() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> spawn()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void spawn() {
        Node houseNode = houseNodes.get(rand.nextInt(houseNodes.size()));
        Location loc = new Location(
                "Palmira",
                houseNode.getId(),
                houseNode.getX(),
                houseNode.getY(),
                houseNode
        );

        IncidentType[] types = { IncidentType.ROBBERY, IncidentType.FIRE, IncidentType.ACCIDENT, };
        IncidentType type = types[rand.nextInt(types.length)];

        String description = type + " en " + houseNode.getId();

        PriorityLevel level = switch (type) {
            case FIRE, ACCIDENT -> PriorityLevel.HIGH;
            case ROBBERY -> PriorityLevel.MEDIUM;
        };

        Incident inc = new Incident(type, loc, description, level);
        incidentQueue.add(inc);
    }
}
