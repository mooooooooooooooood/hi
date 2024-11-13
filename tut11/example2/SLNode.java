package DSA.tut11.example2;

public class SLNode {
    private int data;
    private SLNode next;
    public SLNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }

    public SLNode getNext() {
        return this.next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }
}
