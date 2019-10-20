public class TestBST {
    public static void main(String[] args) {
        BST T = new BST();
        System.out.println(T.find(T.getRoot(), 1));
        T.insert(T.getRoot(), 1, 2);
        System.out.println(T.find(T.getRoot(), 1));
        T.insert(T.getRoot(), 2, 4);
        System.out.println(T.find(T.getRoot(), 2));
    }
}
