package DSA.tut9;

import java.util.Arrays;

public class ArrayTree {
    private static final int maxSize = 10;
    private int n; // Current number of nodes
    private String[] l; //label
    private int[] p; //parent

    public ArrayTree() {
        n = 0;
        l = new String[maxSize];
        p = new int[maxSize];
        Arrays.fill(p, -2); //cho tất cả phần tử trong mảng = -2
    }

    public boolean isFull() {
        return n == maxSize;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void addNode(String label, int parent) {
        if (isFull()) {
            System.out.println("Tree is full, cannot add node.");
            return;
        }
        if (parent < -1 || parent >= maxSize || (parent >= 0 && l[parent] == null)) {
            System.out.println("Invalid parent node index.");
            return;
        }

        if (parent == -1) {
            p[0] = -1;
            l[0] = label;
            return;
        }

        int pos = parent + 1;
        while (p[pos] <= parent && pos < n) {
            pos++;
        }

        for (int i = n; i> pos; i--) {
            p[i] = p[i-1];
            l[i] = l[i-1];
        }
        p[pos] = parent;
        l[pos] = label;
        n++;
    }


    public int getParent(int node) {
        if (node < 0 || node >= maxSize) {
            System.out.println("Invalid node index.");
            return -1;
        }
        return p[node];
    }

    public String getNodeLabel(int node) {
        if (node < 0 || node >= maxSize) {
            System.out.println("Invalid node index.");
            return null;
        }
        return l[node];
    }

    public void setNodeLabel(int node, String label) {
        if (node < 0 || node >= maxSize) {
            System.out.println("Invalid node index.");
            return;
        }
        l[node] = label;
    }

    public int leftMostChild(int node) {
        if (node < 0 || node >= maxSize) {
            System.out.println("Invalid node index.");
            return -1;
        }
        for (int i = node + 1; i < n; i++) {
            if (p[i] == node) return i;
        }
        return -1; // No children
    }

    public int nearestRightSibling(int node) {
        if (node < 0 || node >= maxSize) {
            System.out.println("Invalid node index.");
            return -1;
        }

        if (p[node] == p[node + 1]) {
            return node;
        }
        return -1;
    }

    public void printTree() {
        System.out.println("Tree Structure:");
        for (int i = 0; i < maxSize; i++) {
            if (l[i] != null) {
                System.out.println("Node " + i + " (" + l[i] + ") -> Parent: " + p[i]);
            }
        }
    }

    public int getDegree(int node) {
        int degree = 0;
        for (int i = node + 1; i < n; i++) {
            if (getParent(i) == node) {
                degree++;
            }
        }
        return degree;
    }

    public boolean isLeaf(int node) {
        return getDegree(node) == 0;
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
        while (node != -1) {
            node = p[node];
            level++;
        }
        return level - 1; // Subtract 1 as the root level is considered 0
    }

    public int getDepth() {
        int maxDepth = 0;
        for (int i = 0; i < maxSize; i++) {
            if (l[i] != null && isLeaf(i)) {
                int depth = getLevel(i);
                if (depth > maxDepth) {
                    maxDepth = depth;
                }
            }
        }
        return maxDepth;
    }

    public int search(String label) {
        for (int i = 0; i < maxSize; i++) {
            if (l[i] != null && l[i].equals(label)) {
                return i;
            }
        }
        return -1;
    }
}
