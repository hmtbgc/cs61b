public class BST {
    private class Node {
        private int key;
        private int value;
        private Node leftSon;
        private Node rightSon;
        private Node father;

        public Node(int ke, int val) {
            key = ke;
            value = val;
            leftSon = null;
            rightSon = null;
            father = null;
        }
    }

    private Node root;

    public BST() {
        root = new Node(0 ,0);
    }

    public BST(int firstKey, int firstVal) {
        root = new Node(firstKey, firstVal);
    }

    public Node getRoot() {
        return root;
    }

    public int find(Node Root, int searchKey) {
        if (Root == null) {
            return -1;
        }

        if (Root.key == searchKey) {
            return Root.value;
        }

        if (searchKey < Root.key) {
            return find(Root.leftSon, searchKey);
        } else {
            return find(Root.rightSon, searchKey);
        }
    }

    public void insert(Node Root, int insertKey, int insertValue) {
        if (insertKey == Root.key) {
            return;
        }

        if (insertKey < Root.key) {
            if (Root.leftSon != null) {
                insert(Root.leftSon, insertKey, insertValue);
            } else {
                Root.leftSon = new Node(insertKey, insertValue);
            }
        } else {
            if (Root.rightSon != null) {
                insert(Root.rightSon, insertKey, insertValue);
            } else {
                Root.rightSon = new Node(insertKey, insertValue);
            }
        }
    } // have no choice but to use arms-length recursion!
}
