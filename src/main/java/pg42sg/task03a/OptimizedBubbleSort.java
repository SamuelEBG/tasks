package pg42sg.task03a;

import org.pg4200.les03.sort.BubbleSort;
import org.pg4200.les03.sort.MySort;

import java.util.Comparator;

public class OptimizedBubbleSort {

    public <T extends Comparable<T>> int sort(T[] array, Comparator<T> comparator, boolean optimized) {

        if(array == null){
            return 0;
        }

        boolean swapped = true;

        int timesIterated = 0;

        while(swapped){

            swapped = false;
            if(!optimized){
                for(int i = 0; i < array.length - 1; i++){
                    int j = i + 1;

                    if(array[i].compareTo(array[j]) > 0){
                        T tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;

                        swapped = true;
                    }
                }
            } else{
                for(int i = 0; i < array.length -1; i++){
                    for(int j = i; j < array.length; j++){

                        if(array[i].compareTo(array[j]) > 0){
                            T tmp = array[i];
                            array[i] = array[j];
                            array[j] = tmp;

                            swapped = true;
                        }
                    }
                }
            }
        }
        return timesIterated;
    }


}
