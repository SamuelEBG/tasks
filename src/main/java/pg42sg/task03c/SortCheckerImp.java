package pg42sg.task03c;

import org.pg4200.ex03.SortChecker;

import java.util.ArrayList;
import java.util.Arrays;

public class SortCheckerImp implements SortChecker {

    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {

        T[] tempSorted = sorted;

        if (original == null && sorted == null){
            return true;
        }else if(original == null || sorted == null){
            return false;
        }else if(original.length == 0 && sorted.length == 0){
            return true;
        }
        for (T t : original) {
            if (t == null) {
                return false;
            }
        }
        for(T s : sorted){
            if (s == null){
                return false;
            }
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

        if(original.length == sorted.length){
            for(int i = 0; i < original.length;i++){

            }
        }else {
            return false;
        }

         */
        return true;
    }
}
