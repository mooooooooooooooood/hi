package DSA.tut10;

public class BinaryTreeApp {
    public static void main(String[] args) {
        BinaryTree t3 = new BinaryTree();
        t3.buildTreeByValue("2", null, null);
        BinaryTree t4 = new BinaryTree();
        t4.buildTreeByValue("6", "5", "11");
        BinaryTree t5 = new BinaryTree();
        t5.buildTreeByValue("9", "4", null);
        BinaryTree t1 = new BinaryTree();
        t1.buildTree("7", t3, t4);
        BinaryTree t2 = new BinaryTree();
        t2.buildTree("5", null, t5);
        BinaryTree t = new BinaryTree();
        t.buildTree("2", t1, t2);

        System.out.println("Pre-order traversal:");
        t.preOrderTraversal(t);
        System.out.println();

        System.out.println("In-order traversal:");
        t.inOrderTraversal(t);
        System.out.println();

        System.out.println("Post-order traversal:");
        t.postOrderTraversal(t);
        System.out.println();

        System.out.println("Cloning the tree:");
        BinaryTree clonedTree = t.clone(t);
        System.out.println("Is the cloned tree equal to the original tree? " + t.isEqual(t, clonedTree));

        System.out.println("The depth of the tree: " + t.getDepth(t));
        System.out.println("Total leaves of the tree: " + t.countLeaves(t));
        System.out.println("Internal path length of the tree: " + t.iPathLength(t, 0));
        System.out.println("Total nodes of the tree: " + t.countNodes(t));
    }
}
