package pg42sg.task05d;

import org.pg4200.les05.MyMapRedBlackTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawRedBlackTreeMap<K extends Comparable<K>, V> extends MyMapRedBlackTree<K, V> {

    public void draw(){

        int n = 10;
        List<Integer> keys = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            keys.add(i);
        }

        Collections.shuffle(keys);



        System.out.println(keys);

    }
}
