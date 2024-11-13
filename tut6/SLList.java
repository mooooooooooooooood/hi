package DSA.tut6;

public class SLList {
    private SLNode head;

    public SLList() {
        this.head = null;
    }

    public void add(SLNode newNode) {
        newNode.setNext(head);
        head = newNode;
    }

    public void remove(int pos) {
        SLNode pre = traversing(pos-1);
        SLNode current = pre.getNext();
        pre.setNext(current.getNext());
    }

    public void addAt(int pos, SLNode newNode) {
        SLNode pre = traversing(pos-1);
        newNode.setNext(pre.getNext());
        pre.setNext(newNode);
    }

    public boolean isEmpty() {
        return head == null;
    }

    //Current length
    public int length() {
        int count = 0;
        SLNode current = head;

        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void print() {
        SLNode current = head;
        while (current != null) {
            current.print();
            current = current.getNext();
        }
    }

    // Search for a string data
    public int search(String data) {
        SLNode current = head;
        int pos = 1;

        while (current != null) {
            if (current.getData().equals(data)) {
                return pos;
            }
            current = current.getNext();
            pos++;
        }
        return -1; // Not found
    }
    //lấy node ở vị trí pos nào đó = get(int pos) nhưng thêm đk !isEmpty
    private SLNode traversing (int pos) {
        SLNode current = head;
        for (int i = 0 ; i < pos; i++) {
            current = current.getNext();
        }
        return current;
    }
}