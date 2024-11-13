package DSA.tut8;

public class SLLStack {
    private StackNode top;
    private int size;

    public SLLStack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char data) {
        StackNode newNode = new StackNode(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return '\0';
        } else {
            char popped = top.data;
            top = top.next;
            size--;
            return popped;
        }
    }

    public int size() {
        return size;
    }
}
