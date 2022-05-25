package pg42sg.task03a;

import java.util.Comparator;

public class OptimizedBubbleSort {
    /* a
     */
    public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized) {
            // if array is empty it will return a 0.
        if(array == null){
            return 0;
        }
            // counter of how many times the array has been iterated through.
        int timesIterated = 0;
        boolean swapped = true; // Use a boolean to activate the while-loop.
            // While the boolean is set to true we will iterate through the array.
        while(swapped){
                // If we don't enter the comparator if-statement, this false will exit the loop.
            swapped = false;
            if(!optimized){ // If user has decided to not use the optimized version, we go into this regular version.
                for(int i = 0; i < array.length - 1; i++){
                    int j = i + 1; // Index 1 int greater than the for-loop.
                        // Update iteration every time we go through 1 index of the array.
                    timesIterated++;
                    // Compare the current index to the index greater than it.
                    // Change the position of the Objects and return to the beginning of the while-loop.
                    if(comparator.compare(array[i], array[j]) > 0){
                        T tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;

                        swapped = true;
                    }
                }
            } else{ // Optimized version that does not go through the entire array again.
                    // But instead goes through it -1 to greater for everytime the loop has run.
                for(int i = 0; i < array.length - timesIterated; i++){
                    int j = i + 1;

                    timesIterated++;
                        if(comparator.compare(array[i], array[j]) > 0){
                            T tmp = array[i];
                            array[i] = array[j];
                            array[j] = tmp;

                            swapped = true;
                        }
                }
            }
        }

        return timesIterated;
    }

}
