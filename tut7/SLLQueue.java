package DSA.tut7;

public class SLLQueue {
    private QueueNode front;
    private QueueNode rear;
    public SLLQueue(){
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void enqueue (int newItem) {
        QueueNode newNode = new QueueNode(newItem);
        newNode.setNext(null);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public QueueNode dequeue() {
        if (!isEmpty()) {
            QueueNode tmp;
            if (front == rear) {
                tmp = front;
                front = rear = null;
            } else {
                tmp = front;
                front = front.getNext();
            }
            return tmp;
        } else return null;
    }

    public QueueNode peek() {
        return front;
    }
}
