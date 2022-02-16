package pg42sg.task02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;

    private int head = -1;
    private int tail = -1;

    public MyRingArrayQueue() {
        this(10);
    }

    public MyRingArrayQueue(int capacity) {
        data = new Object[capacity];
    }

    @Override
    public void enqueue(Object value) {

        /*
        Structure of this if else loop is:
        Check if array is empty, or full if indexes with a wrapped around tail.
         */
        if (isEmpty()) {
            head = 0;
            tail = 0;
        } else if (head <= tail){  //check if head is smaller or equal to tail, which means
                                    // Either they are at the same index(empty) or they are apart
                                    // which means tail is in front which means there are indexes in the array
            if(tail < data.length -1){ // if tail is shorter than the last index of the array
                tail++;                // it means that the array is not filled up yet, which means we add
            } else {
                if (head != 0) { // if we got this far we know that tail is at the end, head <= tail
                    tail = 0;   // and head is not that 0, which means indexes have been deQueued,
                    //therefor we put tail at 0 and add from there.
                } else {
                    // none of the conditions above are met, which means:
                    // our head is at 0, and our tail is at the last index of the array.
                    // The structure of the array is that of a queue, but we want to add
                    // more objects to it, then we just double the length, and
                    // copy the current array into it, so that the tail keeps expanding
                    // and the head remains at 0.
                    Object[] extendedArray = new Object[data.length * 2];
                    System.arraycopy(data, 0, extendedArray, 0, data.length);
                        data = extendedArray;
                        tail++;
                }
            }
        } else {
            if (tail < head -1) {
                tail++;
            } else {
                Object[] biggerArray = new Object[data.length * 2];

                int indexesAfterHead = data.length - head;
                for (int i = 0; i < indexesAfterHead; i++) {
                    biggerArray[i] = data[head + i];
                }

                for (int j = 0; j < indexesAfterHead; j++) {
                    biggerArray[head + j] = data[j];
                }

                tail = data.length - 1;
                head = 0;
                data = biggerArray;
            }
        }
        data[tail] = value;
    }


    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Array is empty");
        }

        T value = (T) data[head];

        if(size() == 1){
            //now it ll be empty
            head = -1;
            tail = -1;
        } else {
            /*
                Removing this line will still make all tests pass, as it
                is not a functional bug: it only impacts performance.
                It is done to avoid "memory leaks" in which we keep unused
                objects that cannot be garbage-collected.
             */
            data[head] = null;
            head++;
            if(head >= data.length){
                head = 0;
            }
        }
        return value;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException();
        }
        return (T) data[head];
    }
    public T peekTail(){
        if(isEmpty()){
            throw new RuntimeException();
        }
        return (T) data[tail];
    }

    @Override
    public int size() {
        if(head < 0){
            return 0;
        } else if(head == tail) {
            return 1;
        } else if(head < tail) {
            //normal case
            return (tail - head) + 1;
        } else {
            int size = (data.length - head) + tail + 1 ;
            return size;
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }

}
