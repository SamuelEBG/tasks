package pg42sg.task04;

import org.pg4200.ex04.FibonacciTestTemplate;

class FibonacciImpTest extends FibonacciTestTemplate {

    @Override
    protected FibonacciImp getInstance() {
        return new FibonacciImp();
    }

}