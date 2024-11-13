package DSA.tut10;

public class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void addRoot(int value) {
        this.root = new BSTNode(value);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getTreeValue() {
        return root != null ? root.value : Integer.MIN_VALUE;
    }

    public boolean insert(int key, BinarySearchTree t) {
        if (t.isEmpty()) {
            t.addRoot(key);
            return true;
        }
        return insertHelper(key, t.root);
    }

    private boolean insertHelper(int key, BSTNode node) {
        if (node == null)
            return false;
        if (key == node.getValue())
            return false;
        if (key < node.getValue()) {
            if (node.getLeft() == null) {
                node.setLeft(new BSTNode(key));
                return true;
            } else {
                return insertHelper(key, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BSTNode(key));
                return true;
            } else {
                return insertHelper(key, node.getRight());
            }
        }
    }

    public int getMax(BinarySearchTree t) {
        if (t == null || t.root == null)
            return Integer.MIN_VALUE;
        BSTNode current = findMax(t.root);
        return current.value;
    }

    private BSTNode findMax(BSTNode node) {
        if (node.getRight() == null)
            return node;
        return findMax(node.getRight());
    }

    public int getMin(BinarySearchTree t) {
        if (t == null || t.root == null)
            return Integer.MAX_VALUE;
        BSTNode current = findMin(t.root);
        return current.value;
    }

    private BSTNode findMin(BSTNode node) {
        if (node.getLeft() == null)
            return node;
        return findMin(node.getLeft());
    }

    public boolean search(int key, BinarySearchTree t) {
        return searchHelper(key, t.root);
    }

    private boolean searchHelper(int key, BSTNode node) {
        if (node == null)
            return false;
        if (key == node.getValue())
            return true;
        if (key < node.getValue())
            return searchHelper(key, node.getLeft());
        else
            return searchHelper(key, node.getRight());
    }

    public void preOrderTraversal(BinarySearchTree t) {
        preOrderHelper(t.root);
    }

    private void preOrderHelper(BSTNode node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrderHelper(node.getLeft());
            preOrderHelper(node.getRight());
        }
    }
}
