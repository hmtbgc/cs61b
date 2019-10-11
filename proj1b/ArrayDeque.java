public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size, fpoint, bpoint, cap, factor;

    public ArrayDeque() {
        size = fpoint = 0;
        bpoint = 1;
        cap = 8;
        factor = 2;
        items = (T []) new Object[cap];
    }

    public ArrayDeque(ArrayDeque other) {
        size = other.size;
        fpoint = 0;
        bpoint = other.size + 1;
        cap = other.cap + 1;
        factor = 2;
        items = (T []) new Object[cap];
        System.arraycopy(other.items, 0, items,1, size);
    }

    @Override
    public int size() {
        return size;
    }

    public void resize(int capability) {
        T[] a = (T []) new Object[capability];
        System.arraycopy(items, 0, a, 0, bpoint);
        if (fpoint + 1 >= bpoint) {
            System.arraycopy(items, fpoint + 1, a, fpoint + 1 + capability - items.length,
                            items.length - fpoint - 1);
        }
        items = a;
    }

    @Override
    public void addFirst(T item) {
        size = size + 1;
        items[fpoint] = item;
        fpoint = fpoint - 1;
        if (fpoint + 1 == 0) {
            if (size < cap) {
                fpoint = cap - 1;
            }
            else {
                cap = cap * factor;
                resize(cap);
                fpoint = cap - 1;
            }
        }
        else if (fpoint + 1 == bpoint) {
            cap = cap * factor;
            resize(cap);
            fpoint = cap - size + bpoint - 1;
        }
        else {
            return;
        }
    }

    @Override
    public void addLast(T item) {
        size = size + 1;
        items[bpoint] = item;
        bpoint = bpoint + 1;
        if (bpoint >= cap) {
            cap = cap * 2;
            resize(cap);
            fpoint = cap - size + bpoint - 1;
        }
        else if (fpoint + 1 == bpoint) {
            cap = cap * 2;
            resize(cap);
            fpoint = cap - size + bpoint - 1;
        }
        else {
            return;
        }
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    public void printWholeArray() {
        for (int i = 0; i < cap; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void printDeque() {
        if (fpoint < bpoint) {
            for (int i = fpoint + 1; i < bpoint; ++i) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }
        else {
            for (int i = fpoint + 1; i < cap; ++i) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < bpoint; ++i) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        size = size - 1;
        fpoint = fpoint + 1;
        if (fpoint >= cap) {
            fpoint = 0;
        }
        T p = items[fpoint];
        items[fpoint] = null;
        return p;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        size = size - 1;
        bpoint = bpoint - 1;
        if (bpoint <= 0) {
            bpoint = cap;
        }
        T p = items[bpoint];
        items[bpoint] = null;
        return p;
    }

    @Override
    public T get(int index) {
        if (index >= size()) {
            return null;
        }
        return items[(index + fpoint + 1) % cap];
    }

    public static void main(String[] args) {
        /*
        ArrayDeque <Integer> A = new ArrayDeque <> ();
        for (int i = 1; i < 2; ++i) {
            A.addFirst(i * 10);
        }
        for (int i = 10; i < 12; ++i) {
            A.addLast(i * 10);
        }
        System.out.println(A.fpoint + " " + A.bpoint + " " + A.size() + " " +
                            A.cap);
        A.printDeque();
        //System.out.println(A.removeFirst());
        //A.printDeque();
        //System.out.println(A.removeLast());
        //A.printDeque();
        System.out.println(A.get(0));

        ArrayDeque<Integer> AA = new ArrayDeque<> (A);
        AA.printDeque();
        for (int i = 0; i < 5; ++i) {
            AA.addFirst(i);
        }
        for (int i = 5; i < 10; ++i) {
            AA.addLast(i);
        }
        AA.printDeque();
        AA.printWholeArray();
        System.out.println(AA.fpoint + " " + AA.bpoint + " " + AA.size() + " " +
                AA.cap);
        System.out.printf("usage ratio = %.3f\n", (double) AA.size() / (double) AA.cap);
        System.out.println(AA.get(1));
        System.out.println(AA.size());
        System.out.println(AA.removeFirst());
        AA.printDeque();
        for (int i = 0; i < 5; ++i) {
            System.out.println(AA.removeLast());
            System.out.println(AA.removeFirst());
            AA.printDeque();
        }


         */
        ArrayDeque<Character> d = new ArrayDeque<>();
        d.addLast('c');
        d.addLast('d');
        d.addFirst('e');
        d.addFirst('f');
        d.addFirst('g');
        d.addFirst('z');
        d.addFirst('f');
        d.addFirst('g');
        d.printDeque();
    }
}
