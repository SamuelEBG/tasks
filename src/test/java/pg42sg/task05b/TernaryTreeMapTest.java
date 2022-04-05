package pg42sg.task05b;

import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapTestTemplate;
import org.pg4200.les05.MyMapTreeBased;

class TernaryTreeMapTest extends MyMapTestTemplate {

    protected <K extends Comparable<K>, V> MyMapTreeBased<K, V> getTreeInstance() {
        return new TernaryTreeMap<>();
    }

    @Override
    protected <K extends Comparable<K>, V> MyMap<K, V> getInstance() {
        return getTreeInstance();
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
        map.delete(2);
        assertEquals(2, map.size());
        map.delete(0);
    }

    @Test
    public void fitteTest(){

        int n = 100;
        List<Integer> keys = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            keys.add(i);
        }

        Collections.shuffle(keys);
        map = getInstance();

        for (Integer key : keys) {
            map.put(key, 0);
        }

        assertEquals(keys.size(), map.size());

        for (Integer key : keys) {
            assertNotNull(map.get(key));
        }

        int size = keys.size();
        Collections.shuffle(keys);

        for (Integer key : keys) {
            map.delete(key);
            assertNull(map.get(key));
            size--;
            assertEquals(size, map.size(), "" + keys);
        }
    }


  */

}