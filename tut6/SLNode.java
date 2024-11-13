package DSA.tut6;

public class SLNode {
    private String data;
    private SLNode next;

    public SLNode(String data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(SLNode n) {
        this.next = n;
    }

    public SLNode getNext() {
        return this.next;
    }

    public String getData() {
        return this.data;
    }

    public void print() {
        System.out.println("Node data: " + this.data);
    }
}