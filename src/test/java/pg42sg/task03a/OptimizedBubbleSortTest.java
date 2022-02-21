package pg42sg.task03a;

import org.junit.jupiter.api.Test;
import org.pg4200.les03.sort.BubbleSortTest;
import org.pg4200.les03.sort.MySort;
import org.pg4200.les03.sort.SortTestTemplate;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class OptimizedBubbleSortTest {

    private OptimizedBubbleSort sorter = new OptimizedBubbleSort();

    private class StringComparator implements Comparator<String> {

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
}