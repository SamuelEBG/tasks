package pg42sg.task04;

import org.pg4200.ex04.Fibonacci;

public class FibonacciImp implements Fibonacci {

    @Override
    public int compute(int n) throws IllegalArgumentException {

        if(n < 0){
            throw new IllegalArgumentException("cannot use negative numbers");
        }

        if(n == 1){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        return compute(n-2) + compute(n - 1);
    }
}
