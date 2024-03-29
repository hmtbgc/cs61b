public class TestUnionFind {
    public static void main(String[] args) {
        UnionFind d = new UnionFind(6);
        d.printWholeSet();
        d.union(0, 1);
        d.printWholeSet();
        d.union(2, 3);
        d.printWholeSet();
        d.union(4, 5);
        d.printWholeSet();
        System.out.println(d.connected(3, 4));
        d.union(2, 4);
        d.printWholeSet();
        d.union(2, 5);
        d.printWholeSet();
        d.union(0, 5);
        d.printWholeSet();
        d.union(0, 3);
        d.printWholeSet();

    }
}
