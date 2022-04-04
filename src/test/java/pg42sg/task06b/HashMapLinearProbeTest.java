package pg42sg.task06b;

import org.pg4200.les06.hash.MyHashMap;
import org.pg4200.les06.hash.MyHashMapTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class HashMapLinearProbeTest extends MyHashMapTestTemplate {

    @Override
    protected <K, V> MyHashMap<K, V> getInstance() {
        return new HashMapLinearProbe<>();
    }
}