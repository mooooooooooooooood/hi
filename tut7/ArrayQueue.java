package DSA.tut7;

public class ArrayQueue {
    public int front;
    public int rear;
    private int maxSize;
    public int[] array;
    public ArrayQueue(int maxSize) {
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    public boolean isEmpty() {
        if (front == rear) return true;
            else return false;
    }

    public boolean isFull() {
        if (rear == front - 1) return true;
            else return false;
    }

    public void enqueue (int item) {
        if (!isFull()) {
            array[rear] = item;
            rear = (rear + 1) % maxSize;
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int pos = front;
            front = (front + 1) % maxSize;
            return array[pos];
        } else return -1; //not found
    }
}
