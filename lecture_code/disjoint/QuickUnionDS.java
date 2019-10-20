public class QuickUnionDS implements disjointSet {
    private int[] parent;

    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = -1;
        }
    }

    public int find(int q) {
        int r = q;
        while (parent[r] >= 0) {
            r = parent[r];
        }
        return r;
    }

    @Override
    public boolean isConnected(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        return rootp == rootq;
    }

    @Override
    public void connect(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        parent[rootp] = rootq;
    }

    public int size() {
        return parent.length;
    }

    public int getith(int i) {
        return parent[i];
    }
}
