package pg42sg.task01;
import org.pg4200.ex01.ArrayUtils; //import interface from ex01 that has 3 methods
// that every class that implements from it that need to be used, as int min
// int max, double mean

import java.util.Arrays;

public class ArrayUtilsImp implements ArrayUtils{

    // methods for int max and means are implemented from
    // parent class. checks if array is empty
    // streams through array gets the lowest value as int, returns that int.
    @Override
    public int min(int[] array) throws IllegalArgumentException {
        checkArray(array);
        return Arrays.stream(array).min().getAsInt();
    }

    @Override
    public int max(int[] array) throws IllegalArgumentException {
        checkArray(array);
        return Arrays.stream(array).max().getAsInt();
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        checkArray(array);
        return Arrays.stream(array).average().getAsDouble();
    }

    private void checkArray(int[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Invalid empty array as input");
        }
    }
}
