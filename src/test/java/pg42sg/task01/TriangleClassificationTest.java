package pg42sg.task01;

import org.junit.jupiter.api.Test;
import pg42sg.task01.TriangleClassification.Classification; //imports the Classification class, so that all methods within it can be used.

import static org.junit.jupiter.api.Assertions.*;
import static pg42sg.task01.TriangleClassification.Classification.*; //imports the constants from the enum "Classification".
import static pg42sg.task01.TriangleClassification.classify; //imports the method classify from the class, so that in can
                                                            // be used without having to write the entire class.method

public class TriangleClassificationTest {

    @Test
    public void testNegativeValues(){
         Classification res = classify(0, 0, 0);
         assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testAEqualsBAndBEqualsC(){
        Classification res = classify(2, 2, 2);
        assertEquals(EQUILATERAL, res);
    }
}

