package pg42sg.task04c;

import org.pg4200.les03.sort.MySort;

public class MixedSort implements MySort {

    private final int bubbleLimit = 12;

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        // The method exits if the array is not initiated.
        if (array == null) {
            return;
        }

        /* Here we make a buffer array with the same length as the
        original array, we want to use this array for the sorting algorithm
        instead of the original array.
         */

        T[] buffer = (T[]) new Comparable[array.length];

        /*
            Use  the low limit, high limit, the original array and the buffer
            as parameters in a merge sort method.
            NOTE: The buffer is still just an array with the same length as the original
            array so far, we need to populate it with the elements of the original array.
        */
        mergesort(0, array.length - 1, array, buffer);
    }

    private <T extends Comparable<T>> void mergesort(int low, int high, T[] array, T[] buffer) {
        /*
            If the subareas have gone down to being less than the limit for when
            we decide to do a bubble sort, this method will run and sort the
            array directly, and then return.
        */
        if (high - low < this.bubbleLimit) {
            bubbleSort(low, high, array);
            return;
        }
        /*
            If low is equal or greater than (cannot happen?) high, then the subarea
            of the array is at the point where it does not need to be sorted.
        */
        if (low >= high) {
            return;
        }
        /*
            Now we need a middle to be able to split the array into 2 parts to sort
            each part of the array.
        */
        int middle = low + (high - low) / 2;
        /*
            Splitting array to the left for each recursion,
            Notice how middle is set to "high" which splits it further down
        */
        mergesort(low, middle, array, buffer);
        mergesort(middle + 1, high, array, buffer);
        /*
            After left half has been divided down to single pieces of arrays
            containing individual elements, we go on to split the array from the middle and upwards.
            Notice how each time the second mergeSort recourses it adds 1 to the middle.
         */
        merge(low, middle, high, array, buffer);
    }


    private <T extends Comparable<T>> void merge(int low, int middle, int high, T[] array, T[] buffer) {

        for(int i = low; i <= high; i++){
            buffer[i] = array[i];
        }
        int i = low; // Iterating through left portion, starting at 0,
        int j = middle + 1; // Iterating through right portion, starting at middle.
        int k = low; // For original array, starting at 0, this is were we place
                    // The smallest number and keep adding while increasing k.
        /*
            While i, also known as left side if the portion
            is not empty, while we haven't iterated through it so that it has
            reached the middle, we check if the element in the index i is
            greater or smaller than the element in the index j of the right portion.
         */
        while(i <= middle && j <= high){
            if(buffer[i].compareTo(buffer[j]) < 0){ // If left side is bigger than right side,
                array[k] = buffer[i];               // add left side to first index of original array
                i++;    // Increase one index of the left portion once the index is added.
            } else {    // If not, we add the element from the right portion to the original array.
                array[k] = buffer[j];
                j++; // And we instead increase the index of the right side.
            }
            k++; // Whatever side we add from we also have to increase the index of the original array.
        }
        while(i <= middle){
            array[k] = buffer[i];
            i++;
            k++;
        }
/*
        int i = low;

        int j = middle;

            for(int k = low; k <= high; k++){
                if(i > middle){   // When left half is done, we move on to the right half
                    array[k] = buffer[j++];
                } else if (j > high){  // Done with the right half, copy over the left.
                    array[k] = buffer[i++];
                } else if (buffer[j].compareTo(buffer[i]) < 0){
                    array[k] = buffer[j++];
                } else {
                    array[k] = buffer[i++];
                }
            }
        }

         */
    }

    private <T extends Comparable<T>> void bubbleSort(int low, int high, T[] array) {
        boolean swapped = true;
        if (high - low < bubbleLimit) {
            while (swapped) {
                swapped = false;
                for (int i = 0; i < high; i++) { // High will always be less than 4.
                    int j = i + 1;              // Set a index that is +1 from the starting index.
                                                // This is what we will compare to.
                    if (array[i].compareTo(array[j]) > 0) { // If index i is greater than j it will perform the swap
                        T tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;

                        swapped = true;
                    }
                }
            }
        }
    }
}

