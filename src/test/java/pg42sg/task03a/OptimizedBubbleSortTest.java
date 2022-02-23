package pg42sg.task03a;

import org.junit.jupiter.api.Test;
import pg42sg.task03b.GameUser;
import pg42sg.task03b.GameUserComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class OptimizedBubbleSortTest {

    // Create an object of the class OptimizedBubbleSort to be able
    // to use the .sort method.
    private final OptimizedBubbleSort sorter = new OptimizedBubbleSort();

    // Class that implements Comparator with type String, override the compare
    // method to return either 1, 0 or -n.
    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    @Test
    public void testIfNull(){

        int comparisons = sorter.sort(null, new StringComparator(), false);

        assertEquals(0, comparisons);
    }

    @Test
    public void sortOneLetter(){
        String[] array = {"a"};

        int comparisons = sorter.sort(array, new StringComparator(), false);

        assertEquals(0, comparisons);
        assertEquals("a", array[0]);
    }

    @Test
    public void alreadySorted(){
        String [] array = {"a", "b", "c", "d"};

        int comparisons = sorter.sort(array, new StringComparator(), false);

        assertEquals(3, comparisons);
        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
    }

    @Test
    public void sortInverted(){
        String [] array = {"d", "c", "b", "a"};

        int comparisons = sorter.sort(array, new StringComparator(), false);

        assertEquals(12, comparisons);
        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
    }

    @Test
    public void sortingAlot(){
        String[] array = {"n", "q", "r", "l", "e", "t", "m", "h", "i", "j", "k", "d", "g", "a", "o", "p", "b", "c", "s", "f"};

        int slow = sorter.sort(array, new StringComparator(), false);

        String[] array2 = {"n", "q", "r", "l", "e", "t", "m", "h", "i", "j", "k", "d", "g", "a", "o", "p", "b", "c", "s", "f"};

        int fast = sorter.sort(array2, new StringComparator(), true);

        assertTrue(fast < slow);
        assertTrue(fast < slow/2);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
        assertEquals("e", array[4]);
        assertEquals("f", array[5]);
        assertEquals("g", array[6]);
        assertEquals("h", array[7]);
        assertEquals("i", array[8]);
        assertEquals("j", array[9]);
        assertEquals("k", array[10]);
        assertEquals("l", array[11]);
        assertEquals("m", array[12]);
        assertEquals("n", array[13]);
        assertEquals("o", array[14]);
        assertEquals("p", array[15]);
        assertEquals("q", array[16]);
        assertEquals("r", array[17]);
        assertEquals("s", array[18]);
        assertEquals("t", array[19]);
    }
    @Test
    public void testGameUser(){
        GameUser a = new GameUser("2", 11);
        GameUser b = new GameUser("3", 42);
        GameUser c = new GameUser("4", 3);
        GameUser d = new GameUser("5", 23);
        GameUser e = new GameUser("6", 129);
        GameUser f = new GameUser("8", 129);
        GameUser g = new GameUser("15", 63);

        GameUser[] array = {b, c, a, d, e, g, f};

        sorter.sort(array, new GameUserComparator(), false);

        assertEquals(3, array[0].getPoints());
        assertEquals(11, array[1].getPoints());
        assertEquals(23, array[2].getPoints());
        assertEquals(42, array[3].getPoints());
        assertEquals(63, array[4].getPoints());
        assertEquals(129, array[5].getPoints());
        assertEquals("8", array[6].getUserId());
    }
}