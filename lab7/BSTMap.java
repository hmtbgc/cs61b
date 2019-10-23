import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable, V> implements Map61B<K, V> {
    private class Node {
        private K key;
        private V value;
        private Node leftSon;
        private Node rightSon;
        private int size;

        public Node(K k, V v) {
            key = k;
            value = v;
            leftSon = null;
            rightSon = null;
            size = 1;
        }
    }
    private Node root;
    private Set<K> keysSet = new HashSet<>();

    public BSTMap() {

    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (get(root, key) != null) {
            return true;
        }
        return false;
    }

    public V get(Node Root, K key) {
        if (Root == null) {
            return null;
        }
        int x = key.compareTo(Root.key);
        if (x == 0) {
            return Root.value;
        }
        if (x < 0) {
            return get(Root.leftSon, key);
        } else {
            return get(Root.rightSon, key);
        }
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    public int size(Node Root) {
        if (Root == null) {
            return 0;
        }
        return Root.size;
    }
    @Override
    public int size() {
        return size(root);
    }

    public Node put(Node Root, K key, V value) {
        if (Root == null) {
            return new Node(key, value);
        }
        int x = key.compareTo(Root.key);
        if (x == 0) {
            Root.value = value;
        } else if (x < 0) {
            Root.leftSon = put(Root.leftSon, key, value);
        } else {
            Root.rightSon = put(Root.rightSon, key, value);
        }
        Root.size = size(Root.leftSon) + size(Root.rightSon) + 1;
        return Root;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    public void getKey(Node Root) {
        if (Root == null) {
            return;
        }
        getKey(Root.leftSon);
        keysSet.add(Root.key);
        getKey(Root.rightSon);

    }

    @Override
    public Set<K> keySet() {
        // throw new UnsupportedOperationException("This operation is unsupported!");
        getKey(root);
        return keysSet;
    }


    public Node remove(Node Root, K key) {
        if (Root == null) {
            return null;
        }
        int x = key.compareTo(Root.key);
        if (x < 0) {
            Root.leftSon = remove(Root.leftSon, key);
        } else if (x > 0) {
            Root.rightSon = remove(Root.rightSon, key);
        } else {
            if (Root.leftSon == null) {
                return Root.rightSon;
            }
            if (Root.rightSon == null) {
                return Root.leftSon;
            }

            Node temp = Root;
            Root = min(temp.rightSon);
            Root.rightSon = removeMin(temp.rightSon);
            Root.leftSon = temp.leftSon;
        }
        Root.size = size(Root.leftSon) + size(Root.rightSon) + 1;
        return Root;
    }

    private Node min(Node Root) {
        if (Root.leftSon == null) {
            return Root;
        }
        return min(Root.leftSon);
    }

    private Node removeMin(Node Root) {
        if (Root.leftSon == null) {
            return Root.rightSon;
        }
        Root.leftSon = removeMin(Root.leftSon);
        Root.size = size(Root.leftSon) + size(Root.rightSon) + 1;
        return Root;
    }
    @Override
    public V remove(K key) {
        // throw new UnsupportedOperationException("This operation is unsupported!");
        V cmp = get(key);
        if (cmp == null) {
            return null;
        } else {
            root = remove(root, key);
        }
        return cmp;
    }

    @Override
    public V remove(K key, V value) {
        // throw new UnsupportedOperationException("This operation is unsupported!");
        V cmp = get(key);
        if (cmp == null || (! cmp.equals(value))) {
            return null;
        } else {
            root = remove(root, key);
        }
        return cmp;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("This operation is unsupported!");
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void printInOrder(Node Root) {
        if (Root == null) {
            return;
        }
        printInOrder(Root.leftSon);
        printNode(Root);
        printInOrder(Root.rightSon);
    }

    public void printNode(Node Root) {
        System.out.println(Root.key + " " + Root.value);
    }

}
