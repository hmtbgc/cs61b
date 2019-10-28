import java.util.*;

public class MyHashMap<K, V> implements Map61B<K, V> {

    private class Node {
        public K key;
        public V value;

        public Node (K ke, V val) {
            key = ke;
            value = val;
        }
    }

    private ArrayList<ArrayList<Node>> hashTable;
    private int initialSize;
    private double loadFactor;
    private Set<K> keySet;
    private int size;
    private int numOfBucket;

    public MyHashMap() {
        this(16, 0.75);
    }

    public MyHashMap(int inputInitialSize) {
        this(inputInitialSize, 0.75);
    }

    public MyHashMap(int inputInitialSize, double inputLoadFactor) {
        initialSize = inputInitialSize;
        numOfBucket = initialSize;
        loadFactor = inputLoadFactor;
        hashTable = new ArrayList<>();
        keySet = new HashSet<>();
        size = 0;
        for (int i = 0; i < numOfBucket; ++i) {
            hashTable.add(new ArrayList<Node>());
        }
    }

    @Override
    public void clear() {
        hashTable = new ArrayList<>();
        numOfBucket = 16;
        for (int i = 0; i < numOfBucket; ++i) {
            hashTable.add(new ArrayList<Node>());
        }
        keySet = new HashSet<>();
        size = 0;
    }


    @Override
    public boolean containsKey(K key) {
        return keySet().contains(key);
    }

    private int keyHashTableCode(K key) {
        return Math.floorMod(key.hashCode(), numOfBucket);
    }

    @Override
    public V get(K key) {
        int keyCode = keyHashTableCode(key);
        ArrayList<Node> keyArray = hashTable.get(keyCode);
        for (int i = 0; i < keyArray.size(); ++i) {
            if (key.equals(keyArray.get(i).key)) {
                return keyArray.get(i).value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put (K key, V value) {
        if (! containsKey(key)) {
            size = size + 1;
            keySet.add(key);
        }
        if (size() >= loadFactor * numOfBucket) {
            resize(2 * numOfBucket);
        }
        int keyCode = keyHashTableCode(key);
        boolean flag = false;
        ArrayList<Node> keyArray = new ArrayList<>();
        keyArray = hashTable.get(keyCode);
        for (int i = 0; i < keyArray.size(); ++i) {
            if (key.equals(keyArray.get(i).key)) {
                keyArray.get(i).value = value;
                flag = true;
                break;
            }
        }
        if (! flag) {
            keyArray.add(new Node(key, value));
        }
    }

    public void resize(int capability) {
        ArrayList<ArrayList<Node>> newHashTable = new ArrayList<>();
        for (int i = 0; i < capability; ++i) {
            newHashTable.add(new ArrayList<Node>());
        }
        for (K key: this) {
            int keyCode = keyHashTableCode(key);
            newHashTable.get(keyCode).add(new Node(key, get(key)));
        }
        hashTable = newHashTable;
        numOfBucket = capability;
    }

    @Override
    public Set<K> keySet() {
        return keySet;
    }

    @Override
    public V remove(K key) {
        //throw new UnsupportedOperationException("Remove operation is unsupported!");
        return remove(key, get(key));
    }

    @Override
    public V remove(K key, V value) {
        //throw new UnsupportedOperationException("Remove operation is unsupported!");
        if (! containsKey(key)) {
            return null;
        }
        int keyCode = keyHashTableCode(key);
        ArrayList<Node> keyArray = hashTable.get(keyCode);
        for (int i = 0; i < keyArray.size(); ++i) {
            Node nd = keyArray.get(i);
            if (nd.key.equals(key) && nd.value.equals(value)) {
                keyArray.remove(nd);
                keySet.remove(nd.key);
                size = size - 1;
                return nd.value;
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet.iterator();
    }

}
