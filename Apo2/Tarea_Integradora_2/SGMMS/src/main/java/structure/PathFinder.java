package structure;
import java.util.*;

public class PathFinder {
    public static List<Node> findShortestPath(Graph graph, Node startNode, Node endNode){
        if(startNode == null || endNode == null){
            throw new IllegalArgumentException("The start node or end node is null");
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> previousNode = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.equals(endNode)){
                return reconstructPath(previousNode, endNode);
            }
            for(Node neighbor : graph.getNeighbors(current)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    previousNode.put(neighbor, current);
                    queue.add(neighbor);

                }
            }

        }
    return Collections.emptyList();
    }
    private static List<Node> reconstructPath(Map<Node, Node> previousNode, Node endNode){
        List<Node> path = new ArrayList<>();
        Node current = endNode;
        while(current != null){
            path.add(0, current);
            current = previousNode.get(current);
        }
        return path;

    }

}
