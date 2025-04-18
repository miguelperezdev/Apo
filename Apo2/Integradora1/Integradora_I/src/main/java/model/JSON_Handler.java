package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSON_Handler {
    private static final String FILE_PATH = "/data.json";

    public static JSONObject loadData() {
        try (InputStream is = JSON_Handler.class.getResourceAsStream("/data.json")) {
            if (is == null) {
                System.err.println("Archivo data.json no encontrado en resources.");
                return new JSONObject();
            }
            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            return new JSONObject(content);
        } catch (IOException e) {
            System.err.println("Error al cargar el JSON: " + e.getMessage());
            return new JSONObject();
        }
    }

    public static void saveData(JSONObject data) {
        try {

            Files.createDirectories(Paths.get("resources"));
            Files.write(Paths.get(FILE_PATH), data.toString(4).getBytes());
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }

    public static void addRouteToJson(Route route) {
        JSONObject data = loadData();
        JSONArray routes = data.has("routes") ? data.getJSONArray("routes") : new JSONArray();

        JSONObject routeJson = new JSONObject();
        routeJson.put("id", route.getId());
        routeJson.put("distance", route.getDistance());
        routeJson.put("estimatedTime", route.getEstimatedTime());
        routeJson.put("start", route.getStart());
        routeJson.put("end", route.getEnd());

        routes.put(routeJson);
        data.put("routes", routes);
        saveData(data);
    }

    public static void addPassengerToJson(Passenger passenger) {
        JSONObject data = loadData();
        JSONArray passengers = data.has("passengers") ? data.getJSONArray("passengers") : new JSONArray();

        JSONObject passengerJson = new JSONObject();
        passengerJson.put("id", passenger.getIdPassenger());
        passengerJson.put("name", passenger.getNamePassenger());
        passengerJson.put("assignedRoute", passenger.getAssignedRoute());
        passengerJson.put("contact", passenger.getContact());

        passengers.put(passengerJson);
        data.put("passengers", passengers);
        saveData(data);
    }

    public static void addDriverToJson(Driver driver) {
        JSONObject data = loadData();
        JSONArray drivers = data.has("drivers") ? data.getJSONArray("drivers") : new JSONArray();

        JSONObject driverJson = new JSONObject();
        driverJson.put("id", driver.getIdDriver());
        driverJson.put("name", driver.getNameDriver());
        driverJson.put("assignedVehicle", driver.getAssignedVehicle());
        driverJson.put("status", driver.getStatus().toString());

        drivers.put(driverJson);
        data.put("drivers", drivers);
        saveData(data);
    }

    public static void addIncidentToJson(Incident incident) {
        JSONObject data = loadData();
        JSONArray incidents = data.has("incidents") ? data.getJSONArray("incidents") : new JSONArray();

        JSONObject incidentJson = new JSONObject();
        incidentJson.put("id", incident.getIdIncident());
        incidentJson.put("type", incident.getType());
        incidentJson.put("location", incident.getLocation());
        incidentJson.put("dateTime", incident.getDateTime().toString());
        incidentJson.put("description", incident.getDescription());
        incidentJson.put("status", incident.getStatus().toString());

        incidents.put(incidentJson);
        data.put("incidents", incidents);
        saveData(data);
    }
}
