package DSA.tut9;

public class ArrayBinaryTree {
    private static final int maxSize = 100;
    private String[] l;

    public ArrayBinaryTree() {
        l = new String[maxSize];
    }

    public void addRoot(String label) {
        if (l[0] != null) {
            System.out.println("Root already exists.");
        }
        l[0] = label;
    }

    public int getLeftChild(int node) {
        int leftChild = 2 * node + 1;
        if (leftChild >= maxSize || l[leftChild] == null) {
            return -1; // No left child
        }
        return leftChild;
    }

    public int getRightChild(int node) {
        int rightChild = 2 * node + 2;
        if (rightChild >= maxSize || l[rightChild] == null) {
            return -1; // No right child
        }
        return rightChild;
    }

    public int getParent(int node) {
        if (node <= 0 || node >= maxSize || l[node] == null) {
            return -1; // Invalid node or node doesn't exist
        }
        return (int) Math.floor((node - 1) / 2); //làm tròn xuống
    }

    public String getNodeLabel(int node) {
        if (node < 0 || node >= maxSize || l[node] == null) {
            return null; // Invalid node or node doesn't exist
        }
        return l[node];
    }

    public void setNodeLabel(String label, int node) {
        if (node < 0 || node >= maxSize) {
            System.out.println("Invalid node index.");
            return; //nếu đk này xảy ra thì sẽ ko đi xuống lệnh dưới nữa mà dừng hẳn
        }
        l[node] = label;
    }

    public void addLeftChild(String label, int node) {
        int leftChild = 2 * node + 1;
        if (leftChild >= maxSize) {
            System.out.println("Cannot add left child, tree size exceeded.");
            return;
        }
        setNodeLabel(label, getLeftChild(node));
    }

    public void addRightChild(String label, int node) {
        int rightChild = 2 * node + 2;
        if (rightChild >= maxSize) {
            System.out.println("Cannot add right child, tree size exceeded.");
            return;
        }
        setNodeLabel(label, getRightChild(node));
    }

    public void preOrderTravel(int node) {
        if (node < 0 || node >= maxSize || l[node] == null) {
            System.out.println();
            return;
        }
        System.out.print(getNodeLabel(node) + " ");
        preOrderTravel(getLeftChild(node));
        preOrderTravel(getRightChild(node));
    }

    public boolean isEmpty() {
        return l[0] == null;
    }

    public boolean isLeaf(int node) {
        return getLeftChild(node) == -1 && getRightChild(node) == -1;
    }

    public int countLeaves() {
        int count = 0;
        for (int i = 0; i < maxSize; i++) {
            if (l[i] != null && isLeaf(i)) {
                count++;
            }
        }
        return count;
    }

    public int getLevel(int node) {
        int level = 0;
        while (node != 0) {
            node = getParent(node);
            level++;
        }
        return level;
    }
}
