public class UnionFind {

    private int[] father;
    private int[] size;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        father = new int[n];
        size = new int[n];
        for (int i = 0; i < father.length; ++i) {
            father[i] = -1;
            size[i] = 1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex < 0 || vertex >= father.length) {
            throw new IllegalArgumentException(vertex + " is not in UnionFindDS!");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        validate(v1);
        return size[v1];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        validate(v1);
        if (father[v1] < 0) {
            return - size[v1];
        }
        return father[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        int root1 = find(v1);
        int root2 = find(v2);
        return root1 == root2;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);
        if (!connected(v1, v2)) {
            int root1 = find(v1);
            int root2 = find(v2);
            if (sizeOf(root1) <= sizeOf(root2)) {
                father[root1] = root2;
                size[root2] = size[root2] + size[root1];
            } else {
                father[root2] = root1;
                size[root1] = size[root1] + size[root2];
            }
        } else {
            int root1 = find(v1);
            int root2 = find(v2);
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        validate(vertex);
        int r = vertex;
        while (parent(r) >= 0) {
            r = parent(r);
        }
        int root = r;
        r = vertex;
        while (parent(r) >= 0) {
            if (parent(parent(r)) >= 0) {
                size[parent(r)] = size[parent(r)] - size[r];
            }
            father[r] = root;
            r = parent(r);
        }

        return root;
    }

    public void printWholeSet() {
        System.out.println("father: ");
        for (int i = 0; i < father.length; ++i) {
            System.out.print(father[i] + " ");
        }
        System.out.println();
        System.out.println("size: ");
        for (int i = 0; i < size.length; ++i) {
            System.out.print(size[i] + " ");
        }
        System.out.println();
    }

}
