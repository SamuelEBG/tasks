package pg42sg.task04c;

import org.junit.jupiter.api.Test;
import org.pg4200.les03.sort.SortTestTemplate;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MixedSortTest extends SortTestTemplate {

    @Override
    protected MixedSort getInstance() {
        return new MixedSort();
    }

    @Test
    public void tryToFail(){

        Random random = new Random();

        Integer[] array = new Integer[2487];

        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(8787);
        }

        sorter.sort(array);
        for(int j = 0; j < array.length-1;j++){
            assertTrue(array[j] <= array[j+1], Arrays.toString(array));
        }
    }
}