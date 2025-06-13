package model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DriverTest {
    private Controller controller;
    private model.StateDriver StateDriver;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void testAddDriverCorrectly() {
        controller.addDriver ("246731", "Andres", "car",  model.StateDriver.AVAILABLE);
        String result = controller.showDriver();
        Assertions.assertTrue(result.contains("246731"));
        Assertions.assertTrue(result.contains("Andres"));
        Assertions.assertTrue(result.contains("car"));
        Assertions.assertTrue(result.contains("AVAILABLE"));
    }

    @Test
    public void testAddDriverIncorrectly() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.addDriver("246731", "", "car", model.StateDriver.AVAILABLE);
        });

        Assertions.assertEquals("Error: Driver name cannot be empty", exception.getMessage());
    }


    @Test
    public void searchExistingDriver() {
        Driver driver = new Driver ("246731", "Andres", "car",  model.StateDriver.AVAILABLE);
        Assertions.assertEquals("Andres", driver.getNameDriver());
    }

    @Test
    public void searchNonExistingDriver() {
        String searchedName = "Jorge";
        Assertions.assertNotEquals("Andres", searchedName);
    }
}