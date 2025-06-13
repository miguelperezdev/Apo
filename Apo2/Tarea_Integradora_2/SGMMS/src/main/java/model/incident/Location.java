package model.incident;

import structure.Node;

public class Location {
    private String town;
    private String exactAddress;
    private double x;
    private double y;
    private Node associatedNode;

    /**
     * Constructor para ubicaciones con coordenadas y nodo asociado.
     */
    public Location(String town, String exactAddress, double x, double y, Node associatedNode) {
        this.town = town;
        this.exactAddress = exactAddress;
        this.x = x;
        this.y = y;
        this.associatedNode = associatedNode;
    }

    // Getters y setters
    public String getTown() {
        return town;
    }

    public String getExactAddress() {
        return exactAddress;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Node getAssociatedNode() {
        return associatedNode;
    }

    public void setAssociatedNode(Node associatedNode) {
        this.associatedNode = associatedNode;
    }

    @Override
    public String toString() {
        return String.format("%s, %s (x=%.2f, y=%.2f)", exactAddress, town, x, y);
    }
}
