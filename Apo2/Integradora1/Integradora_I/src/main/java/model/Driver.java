package model;

public class Driver {
    private String id;
    private String name;
    private String assignedVehicle;
    private StateDriver status;

    public Driver(String id, String name, String assignedVehicle, StateDriver status){
        this.id = id;
        this.name = name;
        this.assignedVehicle = assignedVehicle;
        this.status = status;

    }

    public String getIdDriver() {
        return id;
    }

    public void setIdDriver(String id) {
        this.id = id;
    }

    public String getNameDriver() {
        return name;
    }

    public void setNameDriver(String name) {
        this.name = name;
    }

    public String getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(String assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    public StateDriver getStatus() {
        return status;
    }

    public void setStatus(StateDriver status) {
        this.status = status;
    }
    @Override
    public String toString(){
        return "Driver: " + id + "| Name: " + name + " | assigned vehicle: " + assignedVehicle + " | status: " + status;
    }
}
