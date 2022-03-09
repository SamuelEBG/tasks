package pg42sg.task04e;

import org.junit.jupiter.api.Test;
import pg42sg.task04e.TriangleClassification.Classification;

import static org.junit.jupiter.api.Assertions.*;
import static pg42sg.task04e.TriangleClassification.Classification.NOT_A_TRIANGLE;
import static pg42sg.task04e.TriangleClassification.classify;


public class TriangleClassificationTest {

    @Test
    public void aNegativeTest(){

        Classification neg = classify(-1, 0, 0);

        assertEquals(NOT_A_TRIANGLE, neg);
    }

}