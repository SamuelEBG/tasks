package pg42sg.task02c;

import org.pg4200.les02.list.MyListTestTemplate;

public class MyBidirectionalLinkedListTest extends MyListTestTemplate {

    @Override
    protected <T> MyBiDirectionalLinkedList<T> getNewInstance(Class<T> klass) {
        return new MyBiDirectionalLinkedList<>();
    }
}
