package pg42sg.task01;

public class MyArrayListInteger{

    private Integer[] data;

    private int size = 0;

    public MyArrayListInteger(){
        // call the other constructor with "10" as default max size.
        this(10);
    }

    public MyArrayListInteger(int maxSize){
        data = new Integer[maxSize];
    }

    public Integer get(int index){

        if(index < 0 || index >= size){
            System.out.println("Index out of bounds"); // sout for whenever index is out of bounds, eg <-1 or >10
            return null; // returns null for some fucking reason
        }
        return data[index]; //else it returns whatever integer is at that index e.g .get(5)
    }

    public void add(Integer value){
        data[size] = value;
        size++;
    }

    public int size(){
        return size;
    }
}
