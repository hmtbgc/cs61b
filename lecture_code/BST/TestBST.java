public class TestBST {
    public static void main(String[] args) {
        BST T = new BST(1, 2);
        System.out.println(T.find(T.getRoot(), 1));
        T.insert(T.getRoot(), 0, 0);
        T.insert(T.getRoot(), 2, 4);
        System.out.println(T.find(T.getRoot(), 2));
        System.out.println(T.find(T.getRoot(), 0));

        System.out.println(T.getKey(T.getRightSon(T.getRoot())));
        System.out.println(T.getKey(T.getLeftSon(T.getRoot())));
        T.delete(T.getRoot(), 1);
        System.out.println(T.find(T.getRoot(), 1));
        System.out.println(T.find(T.getRoot(), 2));
    }
}
