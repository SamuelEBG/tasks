package pg42sg.task02d;

import org.junit.jupiter.api.Test;
import org.pg4200.les02.list.MyList;
import org.pg4200.les02.list.MyListTestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMiddleBidirectionalLinkedListTest extends MyListTestTemplate {
    @Override
    protected <T> MyMiddleBidirectionalLinkedList<T> getNewInstance(Class<T> klass) {
        return new MyMiddleBidirectionalLinkedList<>();
    }

    @Test
    public void testInsertLessThanQuarter(){
        MyList<String> data = getNewInstance(String.class);
        data.add("a");
        data.add("b");
        data.add("c");
        data.add("d");
        data.add("e");
        data.add("f");
        data.add("g");
        data.add("h");
        data.add("i");
        data.add("j");
        data.add("k");
        data.add("l");
        data.add("m");
        data.add("n");
        data.add("o");
        data.add("p");
        data.add("q");
        data.add("r");
        data.add("s");
        data.add("t");

        String value = "lägre än 25 prosänt";
        data.add(5, value);

        assertEquals("lägre än 25 prosänt", data.get(5));
    }
}
