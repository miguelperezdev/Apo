package model;

import Exceptions.EmptyListException;
import Exceptions.InvalidRouteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RouteTest {
    private Controller controller;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void testAddRouteCorrectly() throws InvalidRouteException, EmptyListException {
        controller.addRoute("823152", 33.0, 120, "Punto 12", "Punto 17");
        String result = controller.showRoutes();
        Assertions.assertTrue(result.contains("823152"));
        Assertions.assertTrue(result.contains("33.0"));
        Assertions.assertTrue(result.contains("120"));
        Assertions.assertTrue(result.contains("Punto 12"));
        Assertions.assertTrue(result.contains("Punto 17"));
    }

    @Test
    public void testAddRouteIncorrectly() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.addRoute("823152", 33.0, 0, "Punto 12", "Punto 17");
        });
        Assertions.assertTrue(exception.getMessage().contains("Error: Estimated time cannot be empty"));
    }

    @Test
    public void testOrderOfRoutesByDistanceCorrectly() throws InvalidRouteException, EmptyListException {
        controller.addRoute("823152", 33.0, 120, "Punto 12", "Punto 17");
        controller.addRoute("254118", 20.0, 60, "Punto 10", "Punto 13");
        controller.addRoute("325741", 41.0, 100, "Punto 3", "Punto 9");

        controller.sortRoutesByDistance();
        String result = controller.showRoutes();

        Assertions.assertTrue(result.startsWith("254118"));
    }

    @Test
    public void testOrderOfRoutesByDistanceIncorrectly() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.addRoute("254118", -20.0, 60, "Punto 3", "Punto 9");
        });
        Assertions.assertTrue(exception.getMessage().contains("Error: Distance cannot be negative"));
    }

    @Test
    public void testOrderOfRoutesByTimeCorrectly() throws InvalidRouteException, EmptyListException {
        controller.addRoute("517986", 25.0, 30, "Punto 7", "Punto 12");
        controller.addRoute("289434", 15.0, 60, "Punto 5", "Punto 10");
        controller.addRoute("157429", 22.0, 90, "Punto 9", "Punto 11");

        controller.sortRoutesByTime();
        String result = controller.showRoutes();

        Assertions.assertTrue(result.startsWith("517986"));
    }

    @Test
    public void testOrderOfRoutesByTimeIncorrectly() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.addRoute("517986", 20.0, 30, "Punto 3", "Punto 9");
        });
        Assertions.assertTrue(exception.getMessage().contains("Error: Invalid time format"));
    }

    @Test
    public void testBestRouteCorrectly() throws InvalidRouteException, EmptyListException {
        controller.addRoute("476253", 12.0, 100, "Punto 2", "Punto 5");
        controller.addRoute("862096", 45.0, 120, "Punto 4", "Punto 10");
        controller.addRoute("989083", 10.0, 40, "Punto 7", "Punto 8");

        controller.sortRoutesByTime();
        String result = controller.showRoutes();

        Assertions.assertTrue(result.startsWith("989083"));
    }

    @Test
    public void testBestRouteIncorrectly() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           controller.showRoutes();
        });
        Assertions.assertTrue(exception.getMessage().contains("Error: No valid routes available"));
    }

}
