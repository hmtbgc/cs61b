import java.awt.*;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<T> implements Iterable<T> {
    private T[] s;
    private int size;

    public ArraySet() {
        size = 0;
        s = (T[]) new Object[100];
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {

        /*
        if (x == null) {
            return true;
        }
         */

        for (int i = 0; i < size; ++i) {
            if (s[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        /*
        if (x == null) {
            throw new IllegalArgumentException("Cannot add null!");
        }
         */
        if (x == null){
            return;
        }

        if (!(contains(x))) {
            s[size] = x;
            size = size + 1;
        }
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T>{
        private int pos;
        public ArraySetIterator() {
            pos = 0;
        }
        public boolean hasNext() {
            return pos < size;
        }
        public T next() {
            T returnItem = s[pos];
            pos = pos + 1;
            return returnItem;
        }
    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size; ++i) {
            returnSB.append(s[i]);
            if (i < size - 1) {
                returnSB.append(" ");
            }
        }
        returnSB.append("}");
        return returnSB.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArraySet<T> other = (ArraySet<T>) o;
        if (this.size() != other.size()) {
            return false;
        }
        for (T item : this) {
            if (! other.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
        for (String i : s) {
            System.out.println(i);
        }
        System.out.println(s);

        /*
        Set<Integer> javaset = Set.of(5, 42, 32);
        Set<Integer> javaset2 = Set.of(5, 42, 32);
        System.out.println(javaset == javaset2);
        System.out.println(javaset.equals(javaset2));

         */

        ArraySet<Integer> javaset = new ArraySet<>();
        ArraySet<Integer> javaset2 = new ArraySet<>();
        javaset.add(1);
        javaset.add(2);
        javaset.add(3);
        javaset2.add(1);
        javaset2.add(2);
        javaset2.add(3);
        System.out.println(javaset == javaset2);
        System.out.println(javaset.equals(javaset2));

    }


    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
