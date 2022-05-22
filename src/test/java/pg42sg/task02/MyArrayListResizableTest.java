package pg42sg.task02;

import org.junit.jupiter.api.Test;
import org.pg4200.les02.list.MyList;
import org.pg4200.les02.list.MyListTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListResizableTest extends MyListTestTemplate {

    @Override
    protected <T> MyList<T> getNewInstance(Class<T> klass) {
        return new MyArrayListResizable<>();
    }
}