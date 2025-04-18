package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PassengerTest {
    private Controller controller;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void testAddPassengerCorrectly() {
        controller.addPassenger("132532", "Jose", "Ruta2", "3154322674");
        String result = controller.showPassengers();
        Assertions.assertTrue(result.contains("132532"));
        Assertions.assertTrue(result.contains("Jose"));
        Assertions.assertTrue(result.contains("Ruta2"));
        Assertions.assertTrue(result.contains("3154322674"));
    }

    @Test
    public void testAddPassengerIncorrectly() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.addPassenger("", "Jose", "Ruta2", "3154322674");
        });
        Assertions.assertTrue(exception.getMessage().contains("Error: ID is required"));
    }

}
