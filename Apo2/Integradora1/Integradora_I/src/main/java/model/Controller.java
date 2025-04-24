package model;

import Exceptions.EmptyListException;
import Exceptions.InvalidIdException;
import Exceptions.InvalidNameException;
import Exceptions.InvalidRouteException;
import Structure.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Controller {
    private LinkedList<Route> routeList;
    private LinkedList<Incident> incidentList;
    private LinkedList<Driver> driverList;
    private LinkedList<Passenger> passengerList;
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ISO_LOCAL_DATE_TIME;


    public Controller() {
        this.routeList = new LinkedList<>();
        this.incidentList = new LinkedList<>();
        this.driverList = new LinkedList<>();
        this.passengerList = new LinkedList<>();
        loadInitialData();
    }

    private void loadInitialData() {
        JSONObject jsonData = JSON_Handler.loadData();

        // Load Routes
        if (jsonData.has("routes")) {
            JSONArray routes = jsonData.getJSONArray("routes");
            for (int i = 0; i < routes.length(); i++) {
                JSONObject routeJson = routes.getJSONObject(i);
                routeList.add(new Route(
                        routeJson.getString("id"),
                        routeJson.getDouble("distance"),
                        routeJson.getInt("estimatedTime"),
                        routeJson.getString("start"),
                        routeJson.getString("end")
                ));
            }
        }

        // Load Drivers
        if (jsonData.has("drivers")) {
            JSONArray drivers = jsonData.getJSONArray("drivers");
            for (int i = 0; i < drivers.length(); i++) {
                JSONObject driverJson = drivers.getJSONObject(i);
                driverList.add(new Driver(
                        driverJson.getString("id"),
                        driverJson.getString("name"),
                        driverJson.getString("assignedVehicle"),
                        StateDriver.valueOf(driverJson.getString("status"))
                ));
            }
        }

        // Load Passengers
        if (jsonData.has("passengers")) {
            JSONArray passengers = jsonData.getJSONArray("passengers");
            for (int i = 0; i < passengers.length(); i++) {
                JSONObject passengerJson = passengers.getJSONObject(i);
                passengerList.add(new Passenger(
                        passengerJson.getString("id"),
                        passengerJson.getString("name"),
                        passengerJson.getString("assignedRoute"),
                        passengerJson.getString("contact")
                ));
            }
        }


        if (jsonData.has("incidents")) {
            JSONArray incidents = jsonData.getJSONArray("incidents");
            for (int i = 0; i < incidents.length(); i++) {
                JSONObject incidentJson = incidents.getJSONObject(i);
                incidentList.add(new Incident(
                        incidentJson.getString("id"),
                        incidentJson.getString("type"),
                        incidentJson.getString("location"),
                        LocalDateTime.parse(incidentJson.getString("dateTime"), DATE_FORMATTER),
                        incidentJson.getString("description"),
                        StateOfIncident.valueOf(incidentJson.getString("status"))
                ));
            }
        }
    }


    public String addRoute(String id, double distance, int estimatedTime, String start, String end) throws InvalidRouteException {
        try {
            if (id == null || id.isEmpty()) {
                throw new InvalidRouteException("the ID cannot be empty");
            }
            if (distance <= 0) {
                throw new InvalidRouteException("The distance must be greater than zero");
            }
            if (estimatedTime <= 0) {
                throw new InvalidRouteException("The estimated time must be greater than zero");
            }

            Route route = new Route(id, distance, estimatedTime, start, end);
            routeList.add(route);
            JSON_Handler.addRouteToJson(route);
            return "Route registered successfully";
        } catch (IllegalArgumentException exception) {
            return "Error adding route: " + exception.getMessage();
        }

    }

    public String showRoutes() throws EmptyListException {
        try {
            if (routeList.isEmpty()) {
                throw new EmptyListException("There aren´t registered routes");
            }
            return routeList.showAll();
        } catch (EmptyListException exception) {
            return exception.getMessage();
        }
    }

    public String sortRoutesByDistance() throws EmptyListException {
        try {
            if (routeList.isEmpty()) {
                throw new EmptyListException("Cannot sort an empty list of routes");
            }
            routeList.sort(Comparator.comparingDouble(Route::getDistance));
            return "Routes sorted by distance was successfully";
        } catch (EmptyListException exception) {
            return exception.getMessage();
        }
    }

    public String sortRoutesByTime() throws EmptyListException {
        try {
            if (routeList.isEmpty()) {
                throw new EmptyListException("Cannot sort an empty list of routes");
            }
            routeList.sort(Comparator.comparingInt(Route::getEstimatedTime));
            return "Routes sorted by time was successfully";
        } catch (EmptyListException exception) {
            return exception.getMessage();
        }
    }

    public String addIncident(String id, String type, String location, LocalDateTime dateTime, String description, StateOfIncident status) {
        try {
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("The incident ID cannot be empty");
            }
            if (dateTime.isAfter(LocalDateTime.now())) {
                throw new IllegalArgumentException("The date of the incident cannot be future");
            }

            Incident incident = new Incident(id, type, location, dateTime, description, status);
            incidentList.add(incident);
            JSON_Handler.addIncidentToJson(incident);
            return "Incident registered successfully";
        } catch (IllegalArgumentException exception) {
            return "Error adding incident: " + exception.getMessage();
        }
    }

    public String showIncidents() {
        try {
            if (incidentList.isEmpty()) {
                throw new EmptyListException("No incidents reported");
            }
            return incidentList.showAll();
        } catch (EmptyListException exception) {
            return exception.getMessage();
        }
    }

    public String sortIncidentsByDate() {
        try {
            if (incidentList.isEmpty()) {
                throw new EmptyListException("An empty list of incidents cannot be sorted.");
            }
            incidentList.sort(Comparator.comparing(Incident::getDateTime));
            return "Incident sorted by date was successfully";
        } catch (EmptyListException exception) {
            return exception.getMessage();
        }
    }

    public String addPassenger(String id, String name, String assignedRoute, String contact) {
        try {
            if (id == null || id.isEmpty()) {
                throw new InvalidIdException("The passenger ID cannot be empty.");
            }
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("The passenger name cannot be empty.");
            }

            Passenger passenger = new Passenger(id, name, assignedRoute, contact);
            passengerList.add(passenger);
            JSON_Handler.addPassengerToJson(passenger);
            return "Passenger registered successfully";
        } catch (IllegalArgumentException exception) {
            return "Error adding passenger: " + exception.getMessage();
        }
    }

    public String showPassengers() {
        try {
            if (passengerList.isEmpty()) {
                throw new EmptyListException("There are no registered passengers");
            }
            return passengerList.showAll();
        } catch (EmptyListException exception) {
            return exception.getMessage();
        }
    }

    public String addDriver(String id, String name, String assignedVehicle, StateDriver status) {
        try {
            if (id == null || id.isEmpty()) {
                throw new InvalidIdException("The driver ID cannot be empty");
            }
            if (assignedVehicle == null || assignedVehicle.isEmpty()) {
                throw new IllegalArgumentException("The assigned vehicle cannot be empty");
            }

            Driver driver = new Driver(id, name, assignedVehicle, status);
            driverList.add(driver);
            JSON_Handler.addDriverToJson(driver);
            return "Driver registered successfully";
        } catch (IllegalArgumentException exception) {
           return "Error adding driver: " + exception.getMessage();
        }

    }

    public String showDriver() {
        try {
            if (driverList.isEmpty()) {
                throw new EmptyListException("There are no registered drivers");
            }
            return driverList.showAll();
        } catch (EmptyListException e) {
            return e.getMessage();
        }
    }


    public StateOfIncident getStateOfIncident(String state){
        return StateOfIncident.valueOf(state.toUpperCase());
    }
    public StateDriver getStateDriver(String state){
        return StateDriver.valueOf(state.toUpperCase());
    }

    public String getBestRouteByTime() throws EmptyListException {
        Route bestRoute = routeList.findTheBestRouteForTime(Comparator.comparingInt(Route::getEstimatedTime));

        if (bestRoute == null) {
            return "There aren´t routes";
        }

        return bestRoute.getId();
    }



    public Incident searchIncidentById(String id)throws InvalidIdException, EmptyListException{
        if(incidentList == null || incidentList.isEmpty()){
            throw new EmptyListException("The id cannot be empty");
        }
        Incident incident = incidentList.searchById(id);
        if(incident == null){
            throw new InvalidIdException("The incident ID does not exist");
        }
        return incident;

    }
    public Driver searchDriverByName(String name) throws InvalidNameException, EmptyListException{
        if(name == null || name.isEmpty()){
            throw new EmptyListException("The driver name cannot be empty");
        }
        Driver driver = driverList.searchByName(name);

        if(driver == null){
            throw new InvalidNameException("The driver name does not exist");
        }
        return driver;
    }

}