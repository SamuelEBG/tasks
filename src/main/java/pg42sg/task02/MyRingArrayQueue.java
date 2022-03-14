package pg42sg.task02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;

    private int head = -1;
    private int tail = -1;
    // First constructor with a int parameter for deciding capacity,
    public MyRingArrayQueue(int capacity) {
        this.data = new Object[capacity]; // Initializes the array with a fixed size.
    }
    // Second constructor without parameters.
    public MyRingArrayQueue() {
        this(10);  // Call the first constructor with parameter of capacity 10.
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
            //If there has been deQueue, so that head has moved from 0,
            // And enQueue has moved tail to 0 >, we add to tail (which has not yet reached head)
            if (tail < head -1) {
                tail++;
            } else {
                /* Now tail has reached head, but both head and tail positions
                    Are not 0 and data.length.
                    So we need to re-align head and tail so that head==0
                    and tail==data.length-1, and double the size of the array.
                 */
                Object[] biggerArray = new Object[data.length * 2];
                    /*
                        First we removed the head section, take data.length, remove the
                        integer that is up until head, which will remove the tail section, since that is
                        from index 0 up until the head index-1.
                        Now we iterate from 0, until the head index-1, which is i < indexesAfterHead.
                        Add each index to the new array will result in the head section
                        having moved to array[0] and up until the index where we start adding tail.
                     */
                int indexesAfterHead = data.length - head;
                for (int i = 0; i < indexesAfterHead; i++) {
                    biggerArray[i] = data[head + i]; // Add each element from head and upwards to array starting from 0.
                }
                    /*
                        Now we have to add the remaining tail section.
                        Start from j=0 and iterate until reached tail, here we dont
                        stop 1 index before because we want to get right up until tail,
                        otherwise we miss 1 index since we start from 0.

                     */
                for (int j = 0; j <= tail; j++) {
                    biggerArray[indexesAfterHead + j] = data[j];
                    // Populate the new array from our predefined counter until
                    // Where our tail was in our previous array which is <= tail.
                }

                tail = data.length; // New tail is the length of our last array.
                head = 0;   // Head is now at 0
                data = biggerArray; // our data array is now our new array.
            }
        }
        data[tail] = value; // Value that is enQueued is added to tail.
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
            throw new RuntimeException("Array is empty");
        }
        return (T) data[head];
    }

    public T peekTail(){
        if(isEmpty()){
            throw new RuntimeException("Array is empty");
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
            return (data.length - head) + (tail + 1);
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }

}
