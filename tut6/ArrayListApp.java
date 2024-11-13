package DSA.tut6;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList myArrayList = new ArrayList();

        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        System.out.println("Size of ArrayList: " + myArrayList.length());
        System.out.println("Is the ArrayList empty? " + myArrayList.isEmpty());
        System.out.println("Is the ArrayList full? " + myArrayList.isFull());

        myArrayList.printList();

        myArrayList.add(1, 15);
        myArrayList.printList();// Display after adding a new element

        myArrayList.printNode(2);

        myArrayList.remove(1);
        myArrayList.printList();// Display the contents after removing an element
    }
}
