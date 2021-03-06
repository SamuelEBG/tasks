package pg42sg.task03a;

import java.util.Arrays;
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

        /*
            LastSwap is for the optimized bubble sort to point out where the last
             swap occurred in an iteration. If we have for example acbde, the last time the
             sort will have swapped is after it has swapped
             c -> b, so when array[1], which is 'c' was swapped for array[2] which is 'b'.
             That swap occurred during iteration i, which would be 1 in this particular swap,
             since we have another counter that accounts for [2] which would be j.
             further instructions in the optimized section.
         */
        int lastSwap = array.length-1;

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

                /*
                     limit is set to lastSwap, when the for-loop has run its course it will update its
                     limit through this int, if the for-loop stopped earlier than array.length-1,
                     then there is no point in iterating through those indexes, because the comparator
                     has already done that and determined that those indexes are sorted.
                 */
                int limit = lastSwap;
                // The limit is determined when the for-loop starts, updating the lastSwap
                // variable does not update the limit variable until it calls it again.
                for(int i = 0; i < limit; i++){
                    int j = i + 1;

                    timesIterated++;
                    if(comparator.compare(array[i], array[j]) > 0){
                        T tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;

                        swapped = true;
                        // Whenever the algorithm makes a swap, it updates the limit in the for-loop,
                        // so that next time the for-loop starts over, it will run until it gets to this
                        // index.
                        lastSwap = i;
                    }
                }
            }
        }
        return timesIterated;
    }
}
