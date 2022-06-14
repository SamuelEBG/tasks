package pg42sg.task03c;

import org.pg4200.ex03.SortChecker;

public class SortCheckerImp implements SortChecker {

    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {

            /*
                Are both arrays null? They are technically sorted.
                Is one null? The other cannot be a sorted version of it since they're not equal size.
                Both arrays have a length of 0? They are technically sorted, because they are empty. air == air.
                Is one array longer than the other, then it cannot be a copy of the other since it would have
                to have the same length.
             */
        if (original == null && sorted == null) return true;
        else if (original == null || sorted == null) return false;
        else if (original.length == 0 && sorted.length == 0) return true;
        if (original.length != sorted.length) return false;

            // Check for null elements in both arrays, first original then sorted, cannot have null values.
        for (T t : original) if (t == null) return false;
        for (T s : sorted) if (s == null) return false;

            // Check if the sorted array is sorted, if not, it cannot be a sorted copy of the
            // Original array.
        for (int i = 0; i < sorted.length-1; i++) if (sorted[i].compareTo(sorted[i+1]) > 0) return false;

        /*
            Check if both arrays have the same value of indexes.
            By first going through one of the arrays, start with creating a temporary
            T variable of the first index, after that iterating through the length
            of either sorted or original, both should be equally long.
            For each index we go through the entire array and check how many times
            that specific T value is present, if for example both arrays have 3 indexes
            if the Integer 6, both counters will get 3 counts.
            but if one of the arrays has a lesser or greater amount of that T value,
            the counters will != and the method will return false.
            So after checking for each index, if the for loop that goes through both arrays
            return with one of the arrays having not counted the T value, the array
            will exit right away. Both arrays have to count each index the same amount of time
            for the sorted array to be a copy of the original array.
         */

        for (T t : original) {

            int countOriginal = 0;
            int countSorted = 0;

                // Iterate through length of array (both are equally long),
                // and check if they have the same amount of instances of 't'.
            for (int k = 0; k < original.length; k++) {
                if (original[k].equals(t)) {
                    countOriginal++;
                }
                if (sorted[k].equals(t)) {
                    countSorted++;
                }
            }
            if (countOriginal != countSorted) return false;
                // If both the original and the sorted array contained the same instances of the index 't',
                // the T t : original for-loop continues its iteration, otherwise it returns false, since one of
                // the arrays is different from the other, one of them contains a different amount of T than the other one.
        }

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
