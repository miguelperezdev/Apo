package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class IncidentTest {
    private Controller controller;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void testAddIncidentCorrectly() {
        controller.addIncident("652413", "Theft", "Cañasgordas", LocalDateTime.of(2025, 8, 2, 14, 33), "Incident on 32nd Street due to theft of a red car", StateOfIncident.PENDING);
        String result = controller.showIncidents();
        Assertions.assertTrue(result.contains("652413"));
        Assertions.assertTrue(result.contains("Theft"));
        Assertions.assertTrue(result.contains("Cañasgordas"));
        Assertions.assertTrue(result.contains("2025/08/02, 14:33"));
        Assertions.assertTrue(result.contains("Incident on 32nd Street due to theft"));
        Assertions.assertTrue(result.contains("PENDING"));
    }

    @Test
    public void testAddIncidentIncorrectly() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.addIncident("652413", "Theft", "Versalles", LocalDateTime.parse("DOSAGOSTO2025"), "Incident on Versailles Street due to theft of a red car", StateOfIncident.PENDING);
        });
        Assertions.assertTrue(exception.getMessage().contains("Error: Date format is incorrect"));
    }

    @Test
    public void testOrderIncidentByTimeCorrectly() {
        controller.addIncident("542615", "fire", "Carrera 19", LocalDateTime.of(2025, 4, 4, 14, 33), "A motorcycle fire at the 19 gas station", StateOfIncident.RESOLVED);
        controller.addIncident("126548", "accident", "La primera", LocalDateTime.of(2025, 11, 6, 2, 15), "Two car accident on the first", StateOfIncident.PENDING);

        controller.sortIncidentsByDate();
        String result = controller.showIncidents();

        Assertions.assertTrue(result.startsWith("542516"));
    }

    @Test
    public void testOrderIncidentByDateCorrectly() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.addIncident("875434", "Theft", "Versalles", LocalDateTime.parse("SA/10/XXXX"), "Incident on Versailles Street due to theft of a red car", StateOfIncident.PENDING);
        });
        Assertions.assertTrue(exception.getMessage().contains("Error: Invalid date format"));
    }

    @Test
    public void testSearchIncidentCorrectly() {
        controller.addIncident("652413", "theft", "Versalles", LocalDateTime.of(2025, 8, 2, 14, 33), "Incident on Versailles Street due to theft of a red car", StateOfIncident.PENDING);

        String result = controller.showIncidents();
        Assertions.assertTrue(result.contains("652413"));
    }

    @Test
    public void testSearchIncidentIncorrectly() {
        String result = controller.showIncidents();
        Assertions.assertFalse(result.contains("999999"));
    }
}
