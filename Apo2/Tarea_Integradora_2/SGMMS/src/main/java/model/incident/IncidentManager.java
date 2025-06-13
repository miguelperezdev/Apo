package model.incident;

import structure.IncidentBST;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class IncidentManager {
    private final PriorityQueue<Incident> incidentQueue; // Para generación de incidentes
    private final IncidentBST incidentTree; // Para gestión priorizada
    private final List<Incident> resolvedIncidents; // Histórico

    public IncidentManager() {
        // PriorityQueue con comparador personalizado
        this.incidentQueue = new PriorityQueue<>((a, b) -> {
            int priorityCompare = a.getPriority().compareTo(b.getPriority());
            if (priorityCompare != 0) return priorityCompare;
            return a.getCreationDate().compareTo(b.getCreationDate());
        });

        this.incidentTree = new IncidentBST();
        this.resolvedIncidents = new ArrayList<>();
    }

    /**
     * Añade un incidente desde el spawner (manteniendo compatibilidad)
     */
    public void addIncidentFromSpawner(Incident incident) {
        incidentQueue.add(incident);
        transferFromQueueToTree(); // Sincronización opcional
    }

    /**
     * Transfiere incidentes de la cola al árbol (puede llamarse periódicamente)
     */
    public void transferFromQueueToTree() {
        while (!incidentQueue.isEmpty()) {
            incidentTree.insert(incidentQueue.poll());
        }
    }

    /**
     * Obtiene el incidente más urgente (del árbol)
     */
    public Incident getMostUrgentIncident() {
        return incidentTree.peekMostUrgent();
    }

    /**
     * Asigna un vehículo al incidente más urgente
     */
    public boolean assignVehicleToMostUrgent(String vehicleId) {
        Incident incident = incidentTree.pollMostUrgent();
        if (incident != null) {
            incident.assignVehicle(vehicleId);
            return true;
        }
        return false;
    }

    /**
     * Marca un incidente como resuelto
     */
    public void resolveIncident(Incident incident) {
        if (incidentTree.remove(incident)) {
            incident.resolve();
            resolvedIncidents.add(incident);
        }
    }

    /**
     * Obtiene todos los incidentes activos ordenados por prioridad
     */
    public List<Incident> getActiveIncidents() {
        return incidentTree.getAllIncidentsInOrder();
    }

    /**
     * Obtiene el histórico de incidentes resueltos
     */
    public List<Incident> getResolvedIncidents() {
        return new ArrayList<>(resolvedIncidents);
    }

    public int getActiveIncidentCount() {
        return incidentTree.size();
    }

    public int getResolvedIncidentCount() {
        return resolvedIncidents.size();
    }
}