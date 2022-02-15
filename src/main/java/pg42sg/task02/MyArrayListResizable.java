package pg42sg.task02;

import org.pg4200.les02.list.MyArrayList;

public class MyArrayListResizable<T> extends MyArrayList<T> {

    //inheriting myArrayList method from parentclass MyArrayList
    // and renaming it resizable, with Super variable as inherited

    public MyArrayListResizable(){super();}

    public MyArrayListResizable(int capacity){super(capacity);}

    @Override
    public void add(int index, T value){

        if(size == data.length){

            Object[] biggerArray = new Object[data.length * 2];
            for(int i = 0; i < biggerArray.length;i++){
                biggerArray[i] = data[i];
            }
            data = biggerArray;
        }
        super.add(index, value);
    }
}
