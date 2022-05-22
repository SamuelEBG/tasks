package pg42sg.task02d;


import org.pg4200.les02.list.MyList;

public class MyMiddleBidirectionalLinkedList<T> implements MyList<T> {

    private class ListNode{
        T value;
        ListNode next;
        ListNode previous;
    }
    private ListNode head;
    private ListNode tail;
    private ListNode middle;
    private int size;


    @Override
    public void add(int index, T value) {


        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        ListNode tempNode;
        ListNode node = new ListNode();
        node.value = value;
        int counter;

        if(head == null) {
            // Add to an empty list
            System.out.println("Adding to empty list");
            assert size == 0; //Adding 1 element.
            head = node;  // head is now node
            tail = node;  // tail is also node, because the objects left and right are both head and tail
            middle = node;
        } else if (index == 0){
            node.next = head; // This nodes .next is now the current head, we push the 0 index node one index to the left.
            head = node;    // Now we change the new node that is in index 0 to being the head.
            head.next.previous = head; // And change the formers .previous to the current head.
            middle = node;
        } else if(index == size){
            tail.next = node; // Adding element at the last index, the currents tail.next is the node
            node.previous = tail; // Change the nodes .previous to being the former tail.
            tail = node; // Now we can set the tail to being the current node.

                moveMiddleNext();

        } else if(index < (size * 0.25) || index > (size * 0.75)) {
                if(index < (size * 0.25)){
                    tempNode = head;
                    counter = 0;
                        while (counter != index -1){
                            tempNode = tempNode.next;
                            counter++;
                        }
                    node.next = tempNode.next;
                    node.previous = tempNode;
                    tempNode.next.previous = node;
                    tempNode.next = node;
                        moveMiddlePrevious();
                } else {
                    tempNode = tail;
                    counter = size()-1;
                        while(counter != index){
                            tempNode = tempNode.previous;
                            counter--;
                        }
                    node.previous = tempNode.previous;
                    node.next = tempNode;
                    node.previous.next = node;
                    moveMiddleNext();
                }

        }else{

            if(index <= middleTracker()){ // If the index is equal or less to halv the size
                // Then we choose to iterate through the array from the head.
                    tempNode = middle;                // Set the tempnode to be the head, index 0.
                    counter = middleTracker();                    // Counter is set to 0.
                    while (counter != index) {  // While counter is not index size
                        tempNode = tempNode.previous;   // We set the tempNode to be the next element, in this case
                        counter--;                  // head.next, which will be element in index 1.
                    }
                        /*
                            We have iterated through and found the index where we want to insert the element.
                            The tempNode is set to being the node .previous (because loop has ended before the index where we
                            want to insert a node) to the index of where we want to insert
                            the element, so when we use tempNode.next, we refer to the element to the right
                            of the index we want to insert.
                         */
                    node.previous = tempNode.previous;;  // This is our node at our desired index, so node.next is the same
                                                // thing as tempNode.next, because tempNode.next is the element to the left
                                                // of our desired index.
                    node.next = tempNode;       // As seen here, node.previous is our tempNode.
                    node.previous.next = node;  // Now we change our node.next objects .previous to being our node.
                                                // Last we change tempNode.next to be our node, which removes
                                                // the relationship between node.next and node.previous.
                moveMiddleNext();
            } else {
                    /*
                        Now we iterate from the back, we take counter to be size()-1, which will be same as the tail.
                        TempNode is set to tail. So when the while loop iterates through the array searching
                        for index that is equal to size()-1, when it finds the correct size, say 14,
                        the while-loop breaks, and the previous execution of the while-loop set the tempNode to be
                        tempNode.previous, which results in the tempNode being the index before the index we want to
                        insert our element.
                     */
                tempNode = middle;
                counter = middleTracker();
                while(counter != index -1){            // This loop will run until the counter is at the index we define in param
                    tempNode = tempNode.next;       // These arguments will be true when the index is -1 from the
                    counter++;                      // parameter in the while-loop.
                }
                node.next = tempNode.next;  // The actual nodes previous node is the same as the tempNodes previous
                node.previous = tempNode;               // The actual nodes next node is the tempNode specified in the while-loop-
                tempNode.next.previous = node;          // Now we destroy the link between node.previous and node.next
                tempNode.next = node;                                    // And insert the element in the index in the middle.
                    moveMiddlePrevious();
            }
        }
        size++;
    }

    @Override
    public T get(int index) {

        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        ListNode current;
        int counter;

        if(index <= size()/2){
            current = head;
            counter = 0;
            while(current != null){

                if(counter == index){
                    // When counter is the same as index, we have found the get(index).
                    return current.value;
                }
                // If not, we go to the next element.
                current = current.next; // Set current to be the next element, which for the first loop
                // is head.next, next time it will be node.next.
                counter++;
            }
        } else {
            current = tail;
            counter = size()-1; // Set counter to be size -1 to have it start at the end of the indexes
            while(current != null){

                if(counter == index){

                    return current.value;
                }

                current = current.previous;

                counter --;
            }
        }
        assert false;
        return null;
    }

    @Override
    public void delete(int index) {

        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        ListNode tempNode;
        int counter;

        if(index == 0){
            if(head.next != null){
                // This will now become the new head
                head = head.next;
                moveMiddlePrevious();
            }else{
                middle = null;
                head = null;
                tail = null;
            }
        } else if(index == size){
            tail.previous = tail;
            moveMiddlePrevious();
        } else if(index < (size * 0.25) || index > (size * 0.75)) {

            if(index < (size * 0.25)){
                tempNode = head;
                counter = 0;

                while(counter != index-1){
                    tempNode = tempNode.next;
                    counter++;
                }
                tempNode.next.next.previous = tempNode;
                tempNode.next = tempNode.next.next;
                moveMiddlePrevious();
            } else{
                tempNode = tail;
                counter = size()-1;
                while(counter != index){
                    tempNode = tempNode.previous;
                    counter--;
                }
                tempNode = tempNode.previous;
                tempNode.next.next = tempNode.next;
                moveMiddlePrevious();
            }
        } else {
            tempNode = middle;
            counter = middleTracker();
            if(index <= middleTracker()){
                while(counter != index){
                    tempNode = tempNode.previous;
                    counter--;
                }
                // tempNode = tempNode.previous;
                tempNode.previous.next = tempNode.next;
                // tempNode.next.next = tempNode.next;
                tempNode.next.previous = tempNode.previous;
                moveMiddlePrevious();
            } else{
                while(counter != index-1){
                    tempNode = tempNode.next;
                    counter++;
                }
                tempNode.next.previous = tempNode;
                tempNode.next = tempNode.next.next;
                moveMiddlePrevious();
            }
        }
        size--;
    }

    public void moveMiddleNext(){
        // Moves the middle node to the right of there has been 2 add/delete from last
        // edit of the array, so will move middle every second edit, same with
        // next method, but that will move it to the left.
        if((size&2) == 0){
            middle = middle.next;
        }
    }

    public void moveMiddlePrevious(){
        if((size&2) == 0){
            middle = middle.previous;
        }
    }

    public int middleTracker(){
        return (int) Math.ceil((size * 0.50)-1);
    }

    @Override
    public boolean isEmpty() {
        return MyList.super.isEmpty();
    }

    @Override
    public int size() {
        return size;
    }
}
