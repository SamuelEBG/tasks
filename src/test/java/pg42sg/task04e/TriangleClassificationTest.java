package pg42sg.task04e;

import org.junit.jupiter.api.Test;
import pg42sg.task04e.TriangleClassification.Classification;

import static org.junit.jupiter.api.Assertions.*;
import static pg42sg.task04e.TriangleClassification.Classification.*;
import static pg42sg.task04e.TriangleClassification.classify;


public class TriangleClassificationTest {
    int max = Integer.MAX_VALUE;

    @Test
    public void aNegativeTest() {
        Classification neg = classify(-1, 0, 0);
        assertEquals(NOT_A_TRIANGLE, neg);
    }

    @Test
    public void bNegativeTest(){
        Classification neg = classify(0, -1, 0);
        assertEquals(NOT_A_TRIANGLE, neg);
    }

    @Test
    public void cNegativeTest(){
        Classification neg = classify(0, 0, -1);
        assertEquals(NOT_A_TRIANGLE, neg);
    }

    @Test
    public void aZeroTest(){
        Classification zero = classify(0, 2, 3);
        assertEquals(NOT_A_TRIANGLE, zero);
    }

    @Test
    public void bZeroTest(){
        Classification zero = classify(3, 0, 3);
        assertEquals(NOT_A_TRIANGLE, zero);
    }

    @Test
    public void cZeroTest(){
        Classification zero = classify(5, 5, 0);
        assertEquals(NOT_A_TRIANGLE, zero);
    }

    @Test
    public void allNegativesTest(){
        Classification negatives = classify(-1,-1,-1);
        assertEquals(NOT_A_TRIANGLE, negatives);
    }

    @Test
    public void allZerosTest(){
        Classification zeros = classify(0,0,0);
        assertEquals(NOT_A_TRIANGLE, zeros);
    }

    @Test
    public void allOnesTest(){
        Classification allOnes = classify(1, 1, 1);
        assertEquals(EQUILATERAL, allOnes);
    }

    @Test
    public void allMaxTest(){
        Classification allMax = classify(max,max,max);
        assertEquals(EQUILATERAL, allMax);
    }

    @Test
    public void aEqualsB(){
        Classification aEqualsB = classify(2,2, 1);
        assertEquals(ISOSCELES, aEqualsB);
    }

    @Test
    public void aEqualsC(){
        Classification aEqualsC = classify(2,1, 2);
        assertEquals(ISOSCELES, aEqualsC);
    }

    @Test
    public void bEqualsC(){
        Classification bEqualsC = classify(1,2, 2);
        assertEquals(ISOSCELES, bEqualsC);
    }

    @Test
    public void aTooLarge(){
        Classification a = classify(5,2,2);
        assertEquals(NOT_A_TRIANGLE, a);
    }

    @Test
    public void bTooLarge(){
        Classification b = classify(2,5,2);
        assertEquals(NOT_A_TRIANGLE, b);
    }

    @Test
    public void cTooLarge(){
        Classification c = classify(2,2,5);
        assertEquals(NOT_A_TRIANGLE, c);
    }

    @Test
    public void aMax(){
        Classification aMax = classify(max-1, max, max);
        assertEquals(ISOSCELES, aMax);
    }

    @Test
    public void bMax(){
        Classification bMax = classify(max, max-1, max);
        assertEquals(ISOSCELES, bMax);
    }

    @Test
    public void cMax(){
        Classification cMax = classify(max, max, max-1);
        assertEquals(ISOSCELES, cMax);
    }

    @Test
    public void scalene(){
        Classification sca = classify(2,3,4);
        assertEquals(SCALENE, sca);
    }

    @Test
    public void maxScalene(){
        Classification maxSca = classify(max, max-1, max-2);
        assertEquals(SCALENE, maxSca);
    }

    @Test
    public void wanTooTri(){
        Classification wanTooTri = classify(1,2,3);
        assertEquals(NOT_A_TRIANGLE, wanTooTri);
    }
}