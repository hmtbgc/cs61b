public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null){
			return 1;
		}
		return 1 + rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null){
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if (i == 0){
			return first;
		}
		return rest.get(i - 1);
	}

	public int get_iterative(int i){
		IntList p = this;
		for (int k = 0; k < i; k++){
			p = p.rest;
		}
		return p.first;
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.println(L.iterativeSize());
		System.out.println(L.get_iterative(1));
	}
} 