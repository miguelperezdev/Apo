package structure;

import model.route.ActiveRoute;

import java.util.ArrayList;
import java.util.List;

public class ActiveRouteBST {
    private static class Node {
        ActiveRoute route;
        Node left, right;

        Node(ActiveRoute route) {
            this.route = route;
        }
    }

    private Node root;
    private int size;

    public void insert(ActiveRoute route) {
        root = insert(root, route);
        size++;
    }

    private Node insert(Node node, ActiveRoute route) {
        if (node == null) return new Node(route);

        int cmp = route.compareTo(node.route);
        if (cmp < 0) {
            node.left = insert(node.left, route);
        } else {
            node.right = insert(node.right, route);
        }
        return node;
    }

    public List<ActiveRoute> getAllRoutesSorted() {
        List<ActiveRoute> routes = new ArrayList<>();
        inOrder(root, routes);
        return routes;
    }

    private void inOrder(Node node, List<ActiveRoute> routes) {
        if (node != null) {
            inOrder(node.left, routes);
            routes.add(node.route);
            inOrder(node.right, routes);
        }
    }

    public boolean remove(ActiveRoute route) {
        int oldSize = size;
        root = remove(root, route);
        return size < oldSize;
    }

    private Node remove(Node node, ActiveRoute route) {
        if (node == null) return null;

        int cmp = route.compareTo(node.route);
        if (cmp < 0) {
            node.left = remove(node.left, route);
        } else if (cmp > 0) {
            node.right = remove(node.right, route);
        } else {
            size--;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node min = findMin(node.right);
            node.route = min.route;
            node.right = remove(node.right, min.route);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public int size() {
        return size;
    }
}