package pg42sg.task02d;

import org.pg4200.les02.list.MyListTestTemplate;

public class MyMiddleBidirectionalLinkedListTest extends MyListTestTemplate {
    @Override
    protected <T> MyMiddleBidirectionalLinkedList<T> getNewInstance(Class<T> klass) {
        return new MyMiddleBidirectionalLinkedList<>();
    }
}
