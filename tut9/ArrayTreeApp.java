package DSA.tut9;

public class ArrayTreeApp {
    public static void main(String[] args) {
        ArrayTree T = new ArrayTree();

        T.addNode("A", -1);

        T.addNode("B", 0);
        T.addNode("C", 0);
        T.addNode("D", 0);

        T.addNode("G", 3);
        T.addNode("E", 2);
        T.addNode("H", 4);
        T.addNode("I", 4);
        T.addNode("F", 2);
        T.addNode("K", 6);

        T.printTree();

        System.out.println("The leftmost child of G is: " + T.getNodeLabel(T.leftMostChild(6)));
        System.out.println("The right sibling of D is: " + T.getNodeLabel(T.nearestRightSibling(3)));

        System.out.println("Degree of node D: " + T.getDegree(3));
        System.out.println("Is node D a leaf? " + T.isLeaf(3));
        System.out.println("Number of leaves in the tree: " + T.countLeaves());
        System.out.println("Level of node K: " + T.getLevel(9));
        System.out.println("Depth of the tree: " + T.getDepth());
        System.out.println("Position of node with label 'H': " + T.search("H"));
    }
}
