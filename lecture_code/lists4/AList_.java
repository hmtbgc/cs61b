public class AList_<T> {
	private T[] item;
	private int size;

	public AList_() {
		item = (T []) new Object[100];
		size = 0;
	}

	public void resize(int capacity, int start) {
 		T[] a = (T []) new Object[capacity];
 		System.arraycopy(item, 0, a, start, size);
 		item = a;
	}

	public void addFirst(T x) {
		resize(size + 1, 1);
		item[0] = x;
		size = size + 1;
	}

	public T getFirst() {
		return item[0];
	}

	public void addLast(T x) {
		if (size == item.length) {
			resize(size + 1, 0);
		}
		item[size] = x;
		size = size + 1;
	}

	public T getLast() {
		return item[size - 1];
	}

	public T get(int i) {
		return item[i];
	}

	public T deleteLast() {
		T returnItem = getLast();
		item[size - 1] = null;
		size = size - 1;
		return returnItem;
	}

	public int size() {
		return size;
	}

	public static void main(String args[]) {
		AList_ L = new AList_ <Integer>();
		for (int i = 0; i < 100; ++i) {
			L.addLast(i);
		}
		System.out.println(L.size());
		System.out.println(L.get(40));
		System.out.println(L.getLast());
		L.addLast(101);
		System.out.println(L.size());
		System.out.println(L.getLast());	
		System.out.println(L.deleteLast());
		System.out.println(L.size());
		System.out.println(L.getLast());
		L.addFirst(20);
		System.out.println(L.size());
		System.out.println(L.getFirst());
		System.out.println(L.get(1));
	}
}