package lab3;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private int capacity;

    public HashTable(int capacity){
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public String[] view() {
        String[] arr = new String[capacity];
        for (int i = 0; i < table.length; i++) {
            ArrayList ar1 = new ArrayList<>();
            if (table[i] == null) {
                continue;
            }
            for (Entry<K, V> entry: table[i]) {
                ar1.add(String.valueOf(entry.getKey()) + " " + String.valueOf(entry.getValue().toString()));
            }
            arr[i] = ar1.toString();
        }
        return arr;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }



    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

