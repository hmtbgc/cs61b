public class QuickFindDS implements disjointSet {

    private int[] id;

    public QuickFindDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public void connect(int p, int q) {
        int idp = id[p];
        int idq = id[q];
        for (int i = 0; i < id.length; ++i) {
            if (id[i] == idp) {
                id[i] = idq;
            }
        }
    }

    public int size() {
        return id.length;
    }

    public int getith(int i) {
        return id[i];
    }
}
