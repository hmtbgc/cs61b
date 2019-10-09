public class AList_<T> {
	private T[] items;
	private int size;

	public AList_() {
		items = (T []) new Object[100];
		size = 0;
	}

	public void resize(int capacity, int start) {
 		T[] a = (T []) new Object[capacity];
 		System.arraycopy(items, 0, a, start, size);
 		items = a;
	}

	public void addFirst(T x) {
		resize(size + 1, 1);
		items[0] = x;
		size = size + 1;
	}

	public T getFirst() {
		return items[0];
	}

	public void addLast(T x) {
		if (size == items.length) {
			resize(size + 1, 0);
		}
		items[size] = x;
		size = size + 1;
	}

	public T getLast() {
		return items[size - 1];
	}

	public T get(int i) {
		return items[i];
	}

	public T deleteLast() {
		T returnItems = getLast();
		items[size - 1] = null;
		size = size - 1;
		return returnItems;
	}

	public void insert(T item, int position) {
		T[] result = (T []) new Object[size + 1];
		for (int i = 0; i < position; ++i) {
			result[i] = items[i];
		}
		result[position] = item;
		for (int i = position; i < size; ++i) {
			result[i + 1] = items[i];
		}
		size = size + 1;
		items = result;
	}

	public int size() {
		return size;
	}

	public void printArray() {
		for (int i = 0; i < size(); ++i) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		AList_ L = new AList_ <Integer>();
		for (int i = 0; i < 10; ++i) {
			L.addLast(i);
		}
		L.printArray();
		/*
		System.out.println(L.size());
		System.out.println(L.get(40));
		System.out.println(L.getLast());
		*/
		L.addLast(101);
		L.printArray();
		/*
		System.out.println(L.size());
		System.out.println(L.getLast());	
		System.out.println(L.deleteLast());
		System.out.println(L.size());
		System.out.println(L.getLast());
		*/
		L.addFirst(20);
		/*
		System.out.println(L.size());
		System.out.println(L.getFirst());
		System.out.println(L.get(1));
		*/
		L.printArray();
		System.out.println(L.size());
		L.insert(30, 2);
		L.printArray();
	}
}