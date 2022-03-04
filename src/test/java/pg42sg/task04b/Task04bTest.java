package pg42sg.task04b;

import org.junit.jupiter.api.Test;
import org.pg4200.ex04.Fibonacci;
import org.pg4200.ex04.FibonacciTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class Task04bTest extends FibonacciTestTemplate {

    @Override
    protected Task04b getInstance() {
        return new Task04b();
    }
}