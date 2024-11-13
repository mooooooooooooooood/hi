package DSA.tut6;

public class SLListApp {
    public static void main(String[] args) {
        SLList myList = new SLList();

        myList.add(new SLNode("Node 1"));
        myList.add(new SLNode("Node 2"));
        myList.add(new SLNode("Node 3"));
        System.out.println("List after adding nodes:");
        myList.print();

        myList.addAt(2, new SLNode("New Node"));
        System.out.println("List after adding a new node at position 2:");
        myList.print();

        myList.remove(1);
        System.out.println("List after removing a node at position 1:");
        myList.print();

        int position = myList.search("Node 2");
        System.out.println("Position of 'Node 2' in the list: " + position);
    }
}
