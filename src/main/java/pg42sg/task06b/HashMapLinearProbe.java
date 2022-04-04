package pg42sg.task06b;

import org.pg4200.les06.hash.MyHashMap;

import java.lang.reflect.Array;
import java.util.Objects;

public class HashMapLinearProbe<K, V> implements MyHashMap<K, V> {
        // Int with a prime number value, so when we hash
        // our key and modulo with this number, we put the key value pair
        // anywhere in our array that will also be the size of this number.
        // So our key hashcode modulo with this prime number defines the
        // index spot.
    private final int M = 997;
    private int size = 0;

        // Every insertion in our HashMap is going to be
        // made into an object, where the key is going to be hashed
        // and determine where in our map we insert the object.
    private class Entry{
        K key;
        V value;
            // Constructor that will set the key and the value whenever
            // we create and object.
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] data = (Entry[]) Array.newInstance(Entry.class, M);

    @Override
    public void put(K key, V value) {

        Objects.requireNonNull(key);

        int k = index(key);

        while(data[k] != null){

            if(data[k].key.equals(key)){
                data[k].value = value;
                return;
            }
            k = (k + 1) % M;
        }

        if(data[k] == null){
            data[k] = new Entry(key, value);
            this.size++;
        }
        /*
        for(int k = i; data[k] != null; k = (k + 1) % M){
            if(data[k].key.equals(key)){
                data[k].value = value;
                return;
            }
        }
        if(data[i] == null){
            data[i] = new Entry(key, value);
            this.size++;
        }
         */
    }

    private int index (K key){

        int positiveKey = key.hashCode() & 0x7f_ff_ff_ff;

        return positiveKey % M;
    }

    @Override
    public void delete(K key) {

        int i = index(key);
        for(int k = i; data[k] != null; k = (i + 1) % M){
            if(data[k].key.equals(key)){
                data[k].key = null;
                data[k].value = null;
                size--;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        int i = index(key);

        for(int k = i; data[k] != null; k = (k + 1) % M){
            if(data[k].key == key){
                return data[k].value;
            }
            /*
            if(data[k] == null){
                return null;
            }

             */
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
