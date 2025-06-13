package structure;

public class Edge {
    private Node source;
    private Node destination;
    private boolean isDirected;

    public Edge(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
        this.isDirected = isDirected;

    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public boolean isDirected() {
        return isDirected;
    }
}
