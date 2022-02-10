package pg42sg.task01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pg4200.les01.MyListString;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListIntegerTest {

    protected MyArrayListInteger getNewInstance() {
        return new MyArrayListInteger(10);
    }

    private MyArrayListInteger list;

    @BeforeEach
    public void initTest(){
        list = getNewInstance();
    }

    @Test
    public void testEmpty(){
        assertEquals(0, list.size());
    }

    @Test
    public void testAddOneElement(){

        int n = list.size(); //create a variable that is the .size() of the array

        list.add(3); // add a integer to the .list

        assertEquals(n + 1, list.size()); //expected is the arrays current size + the added integer.

        // test does not try and test if the array is empty by expecting the size to be
        // only 1, instead we use n + 1. Because testing if the array is only 1 from
        // being created could be done elsewhere, here only want to test if the size
        // increased by 1.

    }

    @Test
    public void testAddAndRetrieveElement(){

        Integer value = 3;

        list.add(value);

        // because the container is empty, we are expecting the index to be 0

        Integer res = list.get(0);

        assertEquals(value, res); // test the integer value against what is actually in the get(0) index
    }

    @Test
    public void testAdd5Elements(){

        assertEquals(0, list.size());
        Integer a = 1;
        Integer b = 3;
        Integer c = 5;

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(a);
        list.add(b);

        assertEquals(a, list.get(0));
        assertEquals(b, list.get(1));
        assertEquals(c, list.get(2));
        assertEquals(a, list.get(3));
        assertEquals(b, list.get(4));
    }

    @Test
    public void testOutOfIndex(){

        assertNull(list.get(-1));
        assertNull(list.get(11));
    }

}