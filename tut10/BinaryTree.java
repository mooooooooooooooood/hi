package DSA.tut10;

public class BinaryTree {
    BTNode root;
    BinaryTree leftSubTree;
    BinaryTree rightSubTree;

    public BinaryTree() {
        this.root = null;
    }

    public void buildTree(String rootValue, BinaryTree left, BinaryTree right) {
        if (rootValue == null) {
            this.root = null;
            this.leftSubTree = null;
            this.rightSubTree = null;
        } else {
            root = new BTNode(rootValue);
            leftSubTree = left;
            rightSubTree = right;
        }
    }

    public void buildTreeByValue(String rootValue, String leftValue, String rightValue) {
        if (rootValue == null) {
            this.root = null;
            leftSubTree = null;
            rightSubTree = null;
        } else {
            root = new BTNode(rootValue);
            if (leftValue != null) {
                this.leftSubTree = new BinaryTree();
                this.leftSubTree.buildTree(leftValue, null, null);
            }

            if (rightValue != null) {
                this.rightSubTree = new BinaryTree();
                this.rightSubTree.buildTree(rightValue, null, null);
            }
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
        leftSubTree = null;
        rightSubTree = null;
    }

    public String getTreeValue() {
        return this.root.getLabel();
    }

    public void setTreeValue(String label) {
        if (root != null) {
            this.root.setLabel(label);
        }
    }

    public boolean isLeaf() {
        return this.root != null && this.leftSubTree == null && this.rightSubTree == null;
    }

    public BinaryTree getLeftSubTree() {
        return leftSubTree;
    }

    public void setLeftSubTree(BinaryTree left) {
        leftSubTree = left;
    }

    public BinaryTree getRightSubTree() {
        return rightSubTree;
    }

    public void setRightSubTree(BinaryTree right) {
        rightSubTree = right;
    }

    public void preOrderTraversal(BinaryTree t) {
        if (t != null) {
            System.out.print(t.getTreeValue() + " ");
            preOrderTraversal(t.getLeftSubTree());
            preOrderTraversal(t.getRightSubTree());
        }
    }

    public void inOrderTraversal(BinaryTree t) {
        if (t != null) {
            inOrderTraversal(t.getLeftSubTree());
            System.out.print(t.getTreeValue() + " ");
            inOrderTraversal(t.getRightSubTree());
        }
    }

    public void postOrderTraversal(BinaryTree t) {
        if (t != null) {
            postOrderTraversal(t.getLeftSubTree());
            postOrderTraversal(t.getRightSubTree());
            System.out.print(t.getTreeValue() + " ");
        }
    }

    public int getDepth(BinaryTree t) {
        if (t == null) return 0;
        if (t.isLeaf()) return  0;
        int rightSubTreeDepth = 0;
        rightSubTreeDepth = getDepth(t.getRightSubTree());
        int leftSubTreeDepth = getDepth(t.getLeftSubTree());
        return Math.max(rightSubTreeDepth, leftSubTreeDepth);
    }

    public int countLeaves(BinaryTree t) {
        if (t == null) {
            return 0;
        } else if (t.isLeaf()) {
            return 1;
        } else {
            return countLeaves(t.getLeftSubTree()) + countLeaves(t.getRightSubTree());
        }
    }

    public int iPathLength(BinaryTree t, int height) {
        if (t == null) {
            return 0;
        } else {
            return height + iPathLength(t.getLeftSubTree(), height + 1) + iPathLength(t.getRightSubTree(), height + 1);
        }
    }


    public int countNodes(BinaryTree t) {
        if (t == null) {
            return 0;
        } else {
            return 1 + countNodes(t.getLeftSubTree()) + countNodes(t.getRightSubTree());
            //1 là root
        }
    }

    public BinaryTree clone(BinaryTree t) {
        if (t == null) {
            return null;
        } else {
            BinaryTree cloneTree = new BinaryTree();
            cloneTree.root = new BTNode(t.getTreeValue());
            cloneTree.leftSubTree = clone(t.getLeftSubTree());
            cloneTree.rightSubTree = clone(t.getRightSubTree());
            return cloneTree;
        }
    }

    public boolean isEqual(BinaryTree t1, BinaryTree t2) {
        // Both trees are null, they are equal
        if (t1 == null && t2 == null) {
            return true;
        }
        // One of the trees is null, they are not equal
        if (t1 == null || t2 == null) {
            return false;
        }
        // Check if current nodes are equal and recursively check subtrees
        return (t1.getTreeValue() == null && t2.getTreeValue() == null) ||
                (t1.getTreeValue() != null && t1.getTreeValue().equals(t2.getTreeValue())) &&
                        isEqual(t1.getLeftSubTree(), t2.getLeftSubTree()) &&
                        isEqual(t1.getRightSubTree(), t2.getRightSubTree());
    }
}
