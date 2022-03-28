package pg42sg.task05d;

import org.pg4200.les05.MyMapRedBlackTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawRedBlackTreeMap<K extends Comparable<K>, V> extends MyMapRedBlackTree<K, V> {

    protected <K extends Comparable<K>, V> MyMapRedBlackTree<K, V> getInstance() {
        return new DrawRedBlackTreeMap<>();
    }

    private MyMapRedBlackTree<Integer, Integer> map;

    public void draw(){
        this.map = getInstance();

        int n = 10;
        List<Integer> keys = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            keys.add(i);
        }

        Collections.shuffle(keys);

        for (Integer key : keys) {
            map.put(key, 0);
        }

        System.out.println(keys);

    }
}
