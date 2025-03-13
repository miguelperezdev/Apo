import model.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    Triangle triangle1;

    private void setUp1(){
        triangle1 = new Triangle(5.0,5.0,5.0);
    }

    @Test
    public void testWhatType(){
        // LLamada al escenario
        setUp1();

        String result = triangle1.whatType();

        // Afirmación del resultado
        Assertions.assertEquals("EQUILATERAL",result);
    }

}
