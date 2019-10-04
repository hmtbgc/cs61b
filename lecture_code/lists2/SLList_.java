public class SLList_ {
	private class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	private IntNode sentinel;
	private int size;

	public SLList_() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public SLList_(int[] arr) {
		size = arr.length;
		sentinel = new IntNode(63, null);
		IntNode p, result;
		p = result = new IntNode(arr[0], null);
		for (int i = 1; i < size; ++i) {
			p.next = new IntNode(arr[i], null);
			p = p.next;
		}
		sentinel.next = result;
	}

	public SLList_(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size = size + 1;
	}

	public int getFirst() {
		return sentinel.next.item;
	}

	public void addLast(int x) {
		IntNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size = size + 1;
	}

	public int getLast() {
		IntNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		return p.item;
	}

	public int getith(int i) {
		assert i <= size;

		IntNode p = sentinel;
		for (int k = 0; k < i; ++k) {
			p = p.next;
		}
		return p.item;
	}

	public int size() {
		return size;
	}

	public void deleteFirst() {
		sentinel.next = sentinel.next.next;
		size = size - 1;
	}

	public static void main(String args[]) {
		int[] arr = new int[]{20, 30, 40};
		SLList_ L = new SLList_(arr);
		L.addFirst(20);
		L.addFirst(30);
		L.addLast(40);
		L.addLast(100);
		System.out.println(L.size());
		System.out.println(L.getFirst());
		System.out.println(L.getLast());
		//System.out.println(L.getith(4));
		L.deleteFirst();
		System.out.println(L.size());
		System.out.println(L.getFirst());
		System.out.println(L.getLast());
	}
}