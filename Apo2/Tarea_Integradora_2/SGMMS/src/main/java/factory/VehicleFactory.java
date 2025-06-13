package factory;

import model.vehicle.*;

public class VehicleFactory {

    public static Vehicle create(String type, double x, double y, double speed) {
        return switch (type.toLowerCase()) {
            case "ambulance" -> new Ambulance(x, y, speed);
            case "patrol" -> new Patrol(x, y, speed);
            case "firetruck" -> new FireTruck(x, y, speed);
            case "gwagonblack", "gwagonwhite", "jeepgreen", "jeepred",
                 "sedanblue", "sedanbrown", "sportblue", "sportmagenta", "taxi" -> new Priority(type, x, y, speed);

            default -> throw new IllegalArgumentException("Tipo de vehículo no reconocido: " + type);
        };
    }
}
