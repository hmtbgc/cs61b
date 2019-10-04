public class DLListone {
	private class IntNode {
		public int item;
		public IntNode next;
		public IntNode prev;

		public IntNode(int i, IntNode n, IntNode m) {
			item = i;
			next = n;
			prev = m;
		}
	}

	private int size;
	private IntNode sentinel;

	public DLListone() {
		size = 0;
		sentinel = new IntNode(63, null, null);
	}

	public void addFirst(int x) {
		size = size + 1;
		IntNode p = new IntNode(x, sentinel.next, sentinel);
		if (sentinel.next == null) {
			sentinel.prev = sentinel.next = p;
			p.next = sentinel;
		}
		else {
			sentinel.next.prev = p;
			sentinel.next = p;
		}
	}

	public void addLast(int x) {
		size = size + 1;
		IntNode p = new IntNode(x, sentinel, sentinel.prev);
		if (sentinel.prev == null) {
			sentinel.prev = sentinel.next = p;
			p.next = sentinel;
		}
		else {
			sentinel.prev.next = p;
			sentinel.prev = p;
		}
	}

	public int getFirst() {
		return sentinel.next.item;
	}

	public int getLast() {
		return sentinel.prev.item;
	}

	public int size() {
		return size;
	}

	public void removeFirst() {
		IntNode p = sentinel.next.next;
		p.prev = sentinel;
		sentinel.next = p;
		size = size - 1;
	}

	public void removeLast() {
		IntNode p = sentinel.prev.prev;
		p.next = sentinel;
		sentinel.prev = p;
		size = size - 1;
	}

	public void printlist() {
		IntNode p = sentinel;
		for (int i = 0; i < size(); ++i) {
			p = p.next;
			System.out.println(p.item);
		}
		System.out.println();
	}

	public static void main(String args[]) {
		DLListone L = new DLListone();
		L.addFirst(10);
		L.addFirst(20);
		L.addFirst(30);
		L.addLast(40);
		L.addLast(50);
		System.out.println(L.getFirst());
		System.out.println(L.getLast());
		System.out.println(L.size());
		L.printlist();
		L.removeFirst();
		L.printlist();
		L.removeLast();
		L.printlist();
	}

}