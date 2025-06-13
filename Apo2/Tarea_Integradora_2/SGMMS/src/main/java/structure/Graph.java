package structure;

import java.util.*;

public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;
    private Map<Node, List<Edge>> adjacencyList;
    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        adjacencyList = new HashMap<>();
    }
    public void addNode(Node node){
        if(!nodes.contains(node)){
            nodes.add(node);
            adjacencyList.put(node, new ArrayList<>());
        }

    }
    public void addEdge(Edge edge) {
        Node source = edge.getSource();
        Node destination = edge.getDestination();
        addNode(source);
        addNode(destination);
        edges.add(edge);
        adjacencyList.get(source).add(edge);
    }
    public List<Node> getNodes() {
        return new ArrayList<>(nodes);
    }
    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }
    public List<Edge> getEdgesFrom(Node source){
        return new ArrayList<>(adjacencyList.getOrDefault(source, new ArrayList<>()));
    }

    public List<Node> getNeighbors(Node node){
        List<Node> neighbors = new ArrayList<>();
        for(Edge edge : getEdgesFrom(node)){
            neighbors.add(edge.getDestination());
        }
        return neighbors;
    }

    public double calculateDistance(Node a, Node b){
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }

    public Node getClosestNode(double x, double y) {
        return getNodes().stream()
                .filter(Node::isWalkable)
                .min(Comparator.comparingDouble(n -> {
                    double dx = n.getX() - x;
                    double dy = n.getY() - y;
                    return dx * dx + dy * dy;
                }))
                .orElse(null);
    }
}
