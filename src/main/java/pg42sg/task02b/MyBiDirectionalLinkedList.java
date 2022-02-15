package pg42sg.task02b;


import org.pg4200.les02.list.MyList;

public class MyBiDirectionalLinkedList<T> implements MyList<T> {

    private class ListNode{
        T value;
        ListNode next;
    }
    private ListNode head;
    private ListNode tail;
    private int size;


    @Override
    public void delete(int index) {

    }

    @Override
    public boolean isEmpty() {
        return MyList.super.isEmpty();
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void add(T value) {
        MyList.super.add(value);
    }

    @Override
    public void add(int index, T value) {

    }

    @Override
    public int size() {
        return 0;
    }
}
