public class LinkedListDeque <T> {
    private class IntNode <T> {
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(T i, IntNode n, IntNode m) {
            item = i;
            next = n;
            prev = m;
        }
    }

    private int size;
    private IntNode sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode(63, null, null);
    }

    public LinkedListDeque(LinkedListDeque other) {
        size = other.size();
        sentinel = new IntNode(63, null, null);
        IntNode p, result, pother;
        p = result = sentinel;
        pother = other.sentinel;
        for (int i = 0; i < other.size(); ++i) {
            pother = pother.next;
            p.next = new IntNode(pother.item, p, null);
            p = p.next;
        }
        p.next = sentinel;
        sentinel.prev = p;
        sentinel = result;
    }

    public void addFirst(T item) {
        size = size + 1;
        IntNode p = new IntNode(item, null, null);
        if (sentinel.next == null) {
            sentinel.next = sentinel.prev = p;
            p.prev = p.next = sentinel;
        }
        else {
            p.next = sentinel.next;
            sentinel.next.prev = p;
            sentinel.next = p;
            p.prev = sentinel;
        }
    }

    public void addLast(T item) {
        size = size + 1;
        IntNode p = new IntNode(item, null, null);
        if (sentinel.next == null) {
            sentinel.next = sentinel.prev = p;
            p.prev = p.next = sentinel;
        }
        else {
            p.next = sentinel;
            p.prev = sentinel.prev;
            sentinel.prev.next = p;
            sentinel.prev = p;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentinel;
        for (int i = 0; i < size(); ++i) {
            p = p.next;
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size = size - 1;
        IntNode p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        p.next = p.prev = null;
        return (T) p.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size = size - 1;
        IntNode p = sentinel.prev;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        p.next = p.prev = null;
        return (T) p.item;
    }

    public T get(int index) {
        if (index >= size()) {
            return null;
        }
        IntNode p = sentinel.next;
        for (int i = 0; i < index; ++i) {
            p = p.next;
        }
        return (T) p.item;
    }

    public T getRecursive(int index) {
        if (index >= size()) {
            return null;
        }
        return (T) helper(index, sentinel.next);
    }

    private T helper(int i, IntNode p) {
        if (i == 0) {
            return (T) p.item;
        }
        return (T) helper(i - 1, p.next);
    }


    public static void main(String args[]) {
        LinkedListDeque <Integer> L = new LinkedListDeque <> ();
        L.addFirst(10);
        L.addFirst(20);
        L.addFirst(30);
        L.addLast(40);
        L.addLast(50);
        System.out.println(L.isEmpty());
        System.out.println(L.size());
        L.printDeque();
        System.out.println(L.removeFirst());
        L.printDeque();
        System.out.println(L.size());
        System.out.println(L.removeLast());
        L.printDeque();
        System.out.println(L.size());
        System.out.println(L.get(2));
        System.out.println(L.getRecursive(2));
        L.printDeque();
        System.out.println(L.size());
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeLast();
        LinkedListDeque <Integer> LL= new LinkedListDeque <> (L);
        LL.addLast(60);
        LL.addFirst(70);
        LL.printDeque();
        System.out.println(LL.size());
        L.printDeque();
        System.out.println(L.size());
    }

}