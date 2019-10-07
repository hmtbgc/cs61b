public class selectionSort {
	private int[] items;
	private int size;

	public selectionSort(int[] a) {
		size = a.length;
		items = a;
	}

	public int findMinIndex(int[] a) {
		int min = a[0];
		int index = 0;
		for (int i = 1; i < a.length; ++i) {
			if (min > a[i]) {
				min = a[i];
				index = i;
			}
		}
		return index;
	}

	public void exchange(int t1, int t2) {
		int t = items[t1];
		items[t1] = items[t2];
		items[t2] = t;
	}

	public void resize() {
		int[] a = new int[items.length - 1];
		System.arraycopy(items, 1, a, 0, items.length - 1);
		items = a;
	}

	public void sort() {
		int[] result = new int[size];
		int point = 0;
		while (point < size) {
			int index = findMinIndex(items);
			result[point] = items[index];
			exchange(index, 0);
			resize();
			point = point + 1;
		}
		items = result;
	}

	public void printArray() {
		for (int i = 0; i < items.length; ++i) {
			System.out.print(items[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] test = new int[]{1, 4, 2, 1, 3, 6, 7};
		int size = Integer.parseInt(args[0]);
		int[] a = new int[size];
		for (int i = 0; i < size; ++i) {
			a[i] = Integer.parseInt(args[i + 1]);
		}
		selectionSort L = new selectionSort(a);
		L.printArray();
		System.out.println();
		L.sort();
		L.printArray();
	}
}
