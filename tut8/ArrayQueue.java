package DSA.tut8;

public class ArrayQueue {
    private int maxSize;
    private char[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public ArrayQueue(int size) {
        this.maxSize = size;
        this.queueArray = new char[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(char data) {
        if (rear == maxSize - 1)
            rear = -1;
        queueArray[++rear] = data;
        nItems++;
    }

    public char remove() {
        char temp = queueArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}
