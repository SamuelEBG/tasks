package pg42sg.task03c;

import org.pg4200.ex03.SortChecker;


public class SortCheckerImp implements SortChecker {

    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {

        // Check if both of the arrays are null.
        if (original == null && sorted == null){
            return true;
        }else if(original == null || sorted == null){ // Check if one of the arrays are null.
            return false;
        }else if(original.length == 0 && sorted.length == 0){ // Check if both arrays are empty.
            return true;
        }
        if(original.length != sorted.length){
            return false;
        }
        for (T t : original) { // Check for null elements in both arrrays, first original then sorted.
            if (t == null) {
                return false;
            }
        }
        for(T s : sorted){
            if (s == null){
                return false;
            }
        }
            // Check if the sorted array is sorted, if not, it cannot be a sorted copy of the
            // Original array.
        for(int i = 0; i < sorted.length-1;i++){
            if(sorted[i].compareTo(sorted[i+1]) > 0){
                return false;
            }
        }

        /* Check if both arrays have the same value of indexes.
            By first going through one of the arrays, start with creating a temporary
            T variable of the first index, after that iterating through the length
            of either sorted or original, both should be equally long.
            For each index we go through the entire array and check how many times
            that specific T value is present, if for example both arrays have 3 indexes
            if the Integer 6, both counters will get 3 counts.
            but if one of the arrays has a lesser or greater amount of that T value,
            the counters will != and the method will return false.
            So after checking for each index, if the foor loop that goes through both arrays
            return with one of the arrays having not counted the T value, the array
            will exit right away. Both arrays have to count each index the same amount of time
            for the sorted array to be a copy of the original array.

         */

        for (T t : original) {

            int countOriginal = 0;
            int countSorted = 0;

            for (int k = 0; k < original.length; k++) { // Iterate through both arrays and check if they
                if (original[k].equals(t)) {   // Have the same amount of instances of the checkIndex value.
                    countOriginal++;
                }
                if (sorted[k].equals(t)) {
                    countSorted++;
                }
            }
            if (countOriginal != countSorted) return false; // If both arrays contained the same amount of
        }                                           // the checkIndex value, the array moves on to the next index
                                                    //

        /*
        if(original.length == sorted.length){
            Arrays.sort(original);
            for(int i = 0; i < original.length; i++){
                if(!original[i].equals(sorted[i])){
                    return false;
                }
            }
        }else{
            return false;
        }
*/          // Both arrays had the same value of indexes and were equally long, the method is true.
        return true;
    }
}
