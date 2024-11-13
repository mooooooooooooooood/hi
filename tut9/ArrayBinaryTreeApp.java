package DSA.tut9;

public class ArrayBinaryTreeApp {
    public static void main(String[]args) {
        ArrayBinaryTree T=new ArrayBinaryTree();
        T.addRoot("A");
        T.addLeftChild("B",0);
        T.addRightChild("C",0);
        T.addLeftChild("D",1);
        T.addLeftChild("E",2);
        T.addRightChild("F",2);
        T.addLeftChild("G",3);
        T.addLeftChild("H",5);
        T.addRightChild("I",5);
        T.addRightChild("K",6);
        T.preOrderTravel(0);

        System.out.println();
        System.out.println("Is node D a leaf? " + T.isLeaf(3));
        System.out.println("Number of leaves in the tree: " + T.countLeaves());
        System.out.println("Level of node G: " + T.getLevel(6));
    }
}
