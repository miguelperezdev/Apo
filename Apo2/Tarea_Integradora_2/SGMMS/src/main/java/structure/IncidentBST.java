package structure;

import model.incident.Incident;

import java.util.ArrayList;
import java.util.List;

public class IncidentBST {
    private IncidentTreeNode root;
    private int size;

    // Clase Nodo interna
    private static class IncidentTreeNode {
        Incident incident;
        IncidentTreeNode left;
        IncidentTreeNode right;

        IncidentTreeNode(Incident incident) {
            this.incident = incident;
            this.left = null;
            this.right = null;
        }
    }

    public IncidentBST() {
        this.root = null;
        this.size = 0;
    }

    public void insert(Incident incident) {
        root = insertRec(root, incident);
        size++;
    }

    private IncidentTreeNode insertRec(IncidentTreeNode node, Incident incident) {
        if (node == null) {
            return new IncidentTreeNode(incident);
        }

        int cmp = compareIncidents(incident, node.incident);
        if (cmp < 0) {
            node.left = insertRec(node.left, incident);
        } else {
            node.right = insertRec(node.right, incident);
        }
        return node;
    }

    public Incident peekMostUrgent() {
        if (root == null) return null;
        IncidentTreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.incident;
    }

    public Incident pollMostUrgent() {
        if (root == null) return null;

        IncidentTreeNode parent = null;
        IncidentTreeNode current = root;

        while (current.left != null) {
            parent = current;
            current = current.left;
        }

        if (parent == null) {
            root = current.right;
        } else {
            parent.left = current.right;
        }

        size--;
        return current.incident;
    }

    public boolean remove(Incident incident) {
        int initialSize = size;
        root = removeRec(root, incident);
        return size < initialSize;
    }

    private IncidentTreeNode removeRec(IncidentTreeNode node, Incident incident) {
        if (node == null) return null;

        int cmp = compareIncidents(incident, node.incident);
        if (cmp < 0) {
            node.left = removeRec(node.left, incident);
        } else if (cmp > 0) {
            node.right = removeRec(node.right, incident);
        } else {
            size--;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            node.incident = findMin(node.right).incident;
            node.right = removeRec(node.right, node.incident);
        }
        return node;
    }

    private IncidentTreeNode findMin(IncidentTreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public List<Incident> getAllIncidentsInOrder() {
        List<Incident> incidents = new ArrayList<>();
        inOrderTraversal(root, incidents);
        return incidents;
    }

    private void inOrderTraversal(IncidentTreeNode node, List<Incident> incidents) {
        if (node != null) {
            inOrderTraversal(node.left, incidents);
            incidents.add(node.incident);
            inOrderTraversal(node.right, incidents);
        }
    }

    private int compareIncidents(Incident a, Incident b) {
        int priorityCompare = a.getPriority().compareTo(b.getPriority());
        if (priorityCompare != 0) return priorityCompare;
        return a.getCreationDate().compareTo(b.getCreationDate());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}