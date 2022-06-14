package pg42sg.task04b;

import org.pg4200.ex04.FibonacciTestTemplate;

class FibonacciImpMemoizedTest extends FibonacciTestTemplate {

    @Override
    protected FibonacciImpMemoized getInstance() {
        return new FibonacciImpMemoized();
    }
}