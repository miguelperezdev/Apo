package model.incident;

public class IncidentTreeNode {
    private final Incident incident;
    private IncidentTreeNode left;
    private IncidentTreeNode right;

    public IncidentTreeNode(Incident incident) {
        this.incident = incident;
        this.left = null;
        this.right = null;
    }

    // Getters y Setters
    public Incident getIncident() {
        return incident;
    }

    public IncidentTreeNode getLeft() {
        return left;
    }

    public void setLeft(IncidentTreeNode left) {
        this.left = left;
    }

    public IncidentTreeNode getRight() {
        return right;
    }

    public void setRight(IncidentTreeNode right) {
        this.right = right;
    }

    public void setIncident(Incident incident) {
    }
}