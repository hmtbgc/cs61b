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

    public Node getfather(Node Root) {
        return Root.father;
    }

    public Node getLeftSon(Node Root) {
        return Root.leftSon;
    }

    public Node getRightSon(Node Root) {
        return Root.rightSon;
    }

    public int getKey(Node Root) {
        return Root.key;
    }

    public int getValue(Node Root) {
        return Root.value;
    }

    private int childrenNum(Node Root) {
        if (Root.leftSon != null && Root.rightSon != null) {
            return 2;
        } else if (Root.leftSon == null && Root.rightSon == null) {
            return 0;
        } else {
            return 1;
        }
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
                Root.leftSon.father = Root;
            }
        } else {
            if (Root.rightSon != null) {
                insert(Root.rightSon, insertKey, insertValue);
            } else {
                Root.rightSon = new Node(insertKey, insertValue);
                Root.rightSon.father = Root;
            }
        }

    } // have no choice but to use arms-length recursion!

    public void delete(Node Root, int deleteKey) {
        if (Root.key == deleteKey) {
            // case 0 : no child
            if (Root.leftSon == null && Root.rightSon == null) {
                if (Root.key < Root.father.key) {
                    Root.father.leftSon = null;
                } else {
                    Root.father.rightSon = null;
                }
                Root = null;
                return;
            }
            // case 1 : 1 child
            if (Root.leftSon != null && Root.rightSon == null) {
                if (Root.father.key > Root.leftSon.key) {
                    Root.father.leftSon = Root.leftSon;
                    Root = null;
                    return;
                } else {
                    Root.father.rightSon = Root.leftSon;
                    Root = null;
                    return;
                }
            }
            if (Root.rightSon != null && Root.leftSon == null) {
                if (Root.father.key > Root.rightSon.key) {
                    Root.father.leftSon = Root.rightSon;
                    Root = null;
                    return;
                } else {
                    Root.father.rightSon = Root.rightSon;
                    Root = null;
                    return;
                }
            }
            // case 2 : 2 children
            // using "Left Hibbard deletion"
            if (Root.rightSon != null && Root.leftSon != null) {
                Node p = Root.leftSon;
                if (p.rightSon == null) {
                    Root.rightSon.father = p;
                    p.rightSon = Root.rightSon;
                    Root.leftSon = null;
                    Root.rightSon = null;
                    Root = null;
                    return;
                }
                while (p.rightSon != null) {
                    p = p.rightSon;
                }
                if (childrenNum(p) == 0) {
                    p.father.rightSon = null;
                    Root.leftSon.father = p;
                    Root.rightSon.father = p;
                    p.leftSon = Root.leftSon;
                    p.rightSon = Root.rightSon;
                    Root = null;
                    return;
                } else {
                    p.leftSon.father = p.father;
                    p.father.rightSon = p.leftSon;
                    Root.leftSon.father = p;
                    Root.rightSon.father = p;
                    p.leftSon = Root.leftSon;
                    p.rightSon = Root.rightSon;
                    Root = null;
                    return;
                }
            }
        }
        if (Root.key < deleteKey) {
            delete(Root.rightSon, deleteKey);
        } else {
            delete(Root.leftSon, deleteKey);
        }
    }
}
