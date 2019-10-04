public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	public void addAdjacent() {
		 IntList p = this;
		 while (p.rest != null) {
		 	if (p.first == p.rest.first) {
		 		p.first += p.rest.first;
		 		p.rest = p.rest.rest;
		 	}
		 	else {
		 		p = p.rest;
		 	}
		 }
	}

	public void addElement(int x) {
		IntList p = this;
		while (p != null) {
			IntList temp = new IntList(p.first * p.first, null);
			temp.rest = p.rest;
			p.rest = temp;
			p = p.rest.rest;
		}
		
		p = this;
		while (p.rest != null) {
			p = p.rest;
		}
		p.rest = new IntList(x, null);

	}

	public void printList() {
		IntList p = this;
		while (p != null) {
			System.out.println(p.first);
			p = p.rest;
		}
	}

	public static void main(String[] args) {
		IntList L = new IntList(2, null);
		L = new IntList(1, L);
		//L = new IntList(2, L);
		//L = new IntList(1, L);
		//L = new IntList(1, L);
		//L.addAdjacent();
		System.out.println(L.size());
		L.addElement(5);
		L.printList();
		System.out.println();
		L.addElement(7);
		L.printList();
		//System.out.println(L.get(0));
		//System.out.println(L.get(L.size() - 1));
		//System.out.println(L.get(100));
	}
} 