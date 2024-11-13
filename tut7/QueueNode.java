package DSA.tut7;

public class QueueNode {
    int data;
    QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    public QueueNode getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
