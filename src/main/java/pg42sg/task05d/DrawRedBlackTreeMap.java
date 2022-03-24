package pg42sg.task05d;

import org.pg4200.les05.MyMapRedBlackTree;

public class DrawRedBlackTreeMap<K extends Comparable<K>, V> extends MyMapRedBlackTree<K, V> {

    protected <K extends Comparable<K>, V> MyMapRedBlackTree<K, V> getInstance() {
        return new DrawRedBlackTreeMap<>();
    }

    private MyMapRedBlackTree<Integer, Integer> map;

    public void draw(){
        this.map = getInstance();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        System.out.println(map.size());
    }
}
