package pg42sg.task04b;

import org.pg4200.ex04.Fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciImpMemoized implements Fibonacci {

    private final Map<Integer, Integer> fibMap = new HashMap<>();

    @Override
    public int compute(int n) throws IllegalArgumentException {

        if (n < 0) throw new IllegalArgumentException("cannot use negative numbers");

        if (n == 0) return 0;

        if (n == 1) return 1;

        if (this.fibMap.containsKey(n)) {
            return this.fibMap.get(n);
        }
        int result = compute(n-1) + compute(n-2);
        this.fibMap.put(n, result);
        return result;
    }

    public static void main(String[] args){
        var calc = new FibonacciImpMemoized();
        calc.compute(10);
    }
}
