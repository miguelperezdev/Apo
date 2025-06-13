package model;

public class Passenger {
    private String id;
    private String name;
    private String assignedRoute;
    private String contact;

    public Passenger(String id, String name, String assignedRoute, String contact){
        this.id= id;
        this.name = name;
        this.assignedRoute = assignedRoute;
        this.contact= contact;
    }

    public String getNamePassenger() {
        return name;
    }

    public void setNamePassenger(String name) {
        this.name = name;
    }

    public String getIdPassenger() {
        return id;
    }

    public void setIdPassenger(String id) {
        this.id = id;
    }

    public String getAssignedRoute() {
        return assignedRoute;
    }

    public void setAssignedRoute(String assignedRoute) {
        this.assignedRoute = assignedRoute;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    @Override
    public String toString(){
        return "Passenger: " + id + "| Name: " + name + " | assigned route: " + assignedRoute+ " | Contact: " + contact;
    }

}

