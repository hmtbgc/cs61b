public class DLList {
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

	private IntNode sentFront;
	private IntNode sentBack;
	private int size;

	public DLList() {
		size = 0;
		sentFront = new IntNode(63, null, null);
		sentBack = new IntNode(63, null, sentFront);
		sentFront.next = sentBack;
	}

	public void addFirst(int x) {
		size = size + 1;
		IntNode p = new IntNode(x, sentFront.next, sentFront);
		sentFront.next.prev = p;
		sentFront.next = p;
	}

	public void addLast(int x) {
		size = size + 1;
		IntNode p = new IntNode(x, sentBack, sentBack.prev);
		sentBack.prev.next = p;
		sentBack.prev = p;
	}

	public int getFirst() {
		return sentFront.next.item;
	}

	public int getBack() {
		return sentBack.prev.item;
	}

	public void removeLast() {
		IntNode p = sentBack.prev.prev;
		p.next = sentBack;
		sentBack.prev = p;
		size = size - 1;
	}

	public void removeFirst() {
		IntNode p = sentFront.next.next;
		p.prev = sentFront;
		sentFront.next = p;
		size = size - 1;
	}

	public int size() {
		return size;
	}

	public void printDLList() {
		IntNode p = sentFront;
		for (int i = 0; i < size(); ++i) {
			p = p.next;
			System.out.println(p.item);
		}

		System.out.println();
	/*
		p = sentBack;
		for (int i = 0; i < size(); ++i) {
			p = p.prev;
			System.out.println(p.item);
		}
	*/

	}

	public static void main(String args[]) {
		DLList L = new DLList();
		L.addFirst(10);
		L.addFirst(20);
		L.addFirst(30);
		L.addLast(30);
		L.addLast(40);
		L.printDLList();
		L.removeFirst();
		L.printDLList();
		L.removeLast();
		L.printDLList();
		//System.out.println(L.getBack());
		//System.out.println(L.getFirst());
	}
}