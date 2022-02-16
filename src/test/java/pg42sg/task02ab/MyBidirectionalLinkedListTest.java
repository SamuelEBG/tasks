package pg42sg.task02ab;

import org.pg4200.les02.list.MyList;
import org.pg4200.les02.list.MyListTestTemplate;
import pg42sg.task02b.MyBiDirectionalLinkedList;

public class MyBidirectionalLinkedListTest extends MyListTestTemplate {
    @Override
    protected <T> MyList<T> getNewInstance(Class<T> klass) {
        return new MyBiDirectionalLinkedList<>();
    }
}
