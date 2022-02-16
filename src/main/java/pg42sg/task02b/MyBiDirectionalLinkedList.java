package pg42sg.task02b;

import org.pg4200.les02.list.MyList;

public class MyBiDirectionalLinkedList<T> implements MyList<T> {

    private class ListNode{
        T value;
        ListNode next;
        ListNode previous;
    }
    private ListNode head;
    private ListNode tail;
    private int size;

    @Override
    public void add(int index, T value) {

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        ListNode node = new ListNode();
        node.value = value;

        if(head == null) {
            // Add to an empty list
            System.out.println("Adding to empty list");
            assert size == 0; //Adding 1 element.
            head = node;  // head is now node
            tail = node;  // tail is also node, because the objects left and right are both head and tail
        } else if (index == 0){
            node.next = head; // This nodes .next is now the current head, we push the 0 index node one index to the left.
            head = node;    // Now we change the new node that is in index 0 to being the head.
            head.next.previous = head; // And change the formers .previous to the current head.
        } else if(index == size){
            tail.next = node; // Adding element at the last index, the currents tail.next is the node
            node.previous = tail; // Change the nodes .previous to being the former tail.
            tail = node; // Now we can set the tail to being the current node.
        } else {
            int counter; // Counter for each index.
            ListNode tempNode; // Create a temporary node that we will initialize in the loops below.

            if(index <= size()/2){ // If the index is equal or less to halv the size
                                    // Then we choose to iterate through the array from the head.
                tempNode = head;    // Set the tempnode to be the head, index 0.
                counter = 0;        // Counter is set to 0.
                while(counter != index -1){ // While counter is not index size -1
                    tempNode = tempNode.next; // We set the tempnode to be the next element, in this case
                    counter++;                  // head.next, which will be element in index 1.
                }
                /*
                    We have iterated through and found the index where we wnat to insert the element.
                    The tempnode is set to being the node .next to the index of where we want to insert
                    the element, so when we use tempNode.next, we refer to the element to the right
                    of the index we want to insert.
                 */
                node.next = tempNode.next; // This is our node at our desired index, so node.next is the same
                                            // thing as tempnode.next, because tempnode.next is the element to the left
                                            // of our desired index.
                node.previous = tempNode;   // As seen here, node.previous is our tempNode.
                node.next.previous = node;  // Now we change our node.next objects .previous to being our node.
                tempNode.next = node;       // Last we change tempnode.next to be our node, which removes
                                            // the relationship between node.next and node.previous.
            } else {
                /*
                    Now we iterate from the back, we take conter to be size()-1, which will be same as the tail.
                    Tempnode is set to tail. So when the while loop iterates through the array searching
                    for index that is equal to size()-1, when it finds the correct size, say 14,
                    the while-loop breaks, and the previous execution of the while-loop set the tempnode to be
                    tempnode.previous, which results in the tempnode being the index befor the index we want to
                    insert our element.
                 */
                tempNode = tail;
                counter = size()-1;
                while(counter != index){  // This loop will run untill the counter is at the index we define in param
                    tempNode = tempNode.previous;   // These arguments will be true when the index is -1 from the
                    counter--;                      // parameter in the while-loop.
                }
                node.previous = tempNode.previous; // The actual nodes previous node is the same as the tempNodes previous
                node.next = tempNode;           // The actual nodes next node is the tempNode specified in the while-loop-
                node.previous.next = node;      // Now we destroy the link between node.previus and node.next
                                                // And insert the element in the index in the middle.
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


        if(index == 0){
            if(head.next != null){
                // This will now become the new head
            }
        }

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
