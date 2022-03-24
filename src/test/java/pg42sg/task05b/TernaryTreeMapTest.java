package pg42sg.task05b;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapTestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TernaryTreeMapTest extends MyMapTestTemplate {

    /*
    private MyMap<Integer, Integer> map;

    @BeforeEach
    public void initTest() {
        map = getInstance();
    }

     */

    @Override
    protected <K extends Comparable<K>, V> MyMap<K, V> getInstance() {
        return new TernaryTreeMap<>();
    }
    /*
    @Test
    public void asdiuHs(){
        map = getInstance();
        map.put(4, 0);
        map.put(3, 0);
        map.put(0, 0);
        map.put(2, 0);
        map.put(1, 0);


        map.delete(4);
        map.delete(3);
        map.delete(1);
        assertEquals(2, map.size());
        map.delete(2);
        map.delete(0);
    }

    @Test
    public void fitteTest(){
        int n = 50; //if you get failures, you can use lower number to help debugging, eg 5
        List<Integer> keys = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            keys.add(i);
        }

        Collections.shuffle(keys);
        map = getInstance();

        for (Integer key : keys) {
            map.put(key, 0);
        }
        System.out.println(keys);

        assertEquals(keys.size(), map.size());
        for (Integer key : keys) {
            assertNotNull(map.get(key));
        }

        int size = keys.size();
        Collections.shuffle(keys);

        for (Integer key : keys) {
            System.out.println("deleting key " + key);
            map.delete(key);
            assertNull(map.get(key));
            size--;
            assertEquals(size, map.size(), "" + keys);
        }
    }

     */
}