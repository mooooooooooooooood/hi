package DSA.tut6;

public class ArrayList {
    private static final int MAX_LENGTH = 100;
    private int[] elements;
    private int length;

    public ArrayList() {
        this.elements = new int[MAX_LENGTH];
        this.length = 0;
    }

    // Add a new element to the end of the list
    public void add(int data) {
        ensureCapacity();
        elements[length++] = data;
    }

    // Add a new element into the list at the specified position
    public void add(int pos, int data) {
        ensureCapacity();

        if (pos < 0 || pos > length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = length; i > pos; i--) {
            elements[i] = elements[i - 1];
        }

        elements[pos] = data;
        length++;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == MAX_LENGTH;
    }

    //Current length
    public int length() {
        return length;
    }

    public void printNode(int pos) {
        if (pos < 0 || pos >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        System.out.println("Data at position " + pos + ": " + elements[pos]);
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.print("List elements: ");
            for (int i = 0; i < length; i++) {
                System.out.print(elements[i] + " ");
            }
            System.out.println();
        }
    }

    // Ensure the capacity of the list
    private void ensureCapacity() {
        if (length == elements.length) {
            elements = java.util.Arrays.copyOf(elements, 2 * length);
        }
    }

    //remove
    public void remove(int pos) {
        if (pos < 0 || pos >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = pos; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        length--;

    }
    public void removeAll(){
        length = 0;
    }
}
