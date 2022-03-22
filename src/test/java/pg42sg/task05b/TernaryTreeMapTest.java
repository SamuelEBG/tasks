package pg42sg.task05b;

import org.junit.jupiter.api.Test;
import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapTestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class TernaryTreeMapTest extends MyMapTestTemplate {

    @Override
    protected <K extends Comparable<K>, V> MyMap<K, V> getInstance() {
        return new TernaryTreeMap<>();
    }


}