package DSA.tut7;

public class SLLStackNode {
    private String data;
    private SLLStackNode next;
    public SLLStackNode() {
        this.data = data;
        this.next = next;
    }
    public SLLStackNode(String data) {
        this.data = data;
    }

    public void setNext(SLLStackNode next) {
        this.next = next;
    }

    public SLLStackNode getNext() {
        return this.next;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
