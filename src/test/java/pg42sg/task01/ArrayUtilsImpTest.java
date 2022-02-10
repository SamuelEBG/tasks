//our own test class that extends the abstract testclass template

package pg42sg.task01;
import org.pg4200.ex01.ArrayUtils;
import org.pg4200.ex01.ArrayUtilsTestTemplate;

import org.junit.jupiter.api.Test;

class ArrayUtilsImpTest extends ArrayUtilsTestTemplate {

    @Test
    void min() {
    }

    @Test
    void max() {
    }

    @Test
    void mean() {
    }

    @Override
    protected ArrayUtils getNewInstance() {
        return new ArrayUtilsImp();
    }
}