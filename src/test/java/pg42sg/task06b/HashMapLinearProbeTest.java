package pg42sg.task06b;

import org.pg4200.les06.hash.MyHashMap;
import org.pg4200.les06.hash.MyHashMapTestTemplate;

class HashMapLinearProbeTest extends MyHashMapTestTemplate {

    @Override
    protected <K, V> MyHashMap<K, V> getInstance() {
        return new HashMapLinearProbe<>();
    }
}