package DSA.tut7;

import java.util.Arrays;

public class ArrayStack {
    private int top;
    private int maxSize;
    private String[] stack;
    public ArrayStack() {
        this.top = -1;
        this.maxSize = 10;
        this.stack = new String[maxSize];
    }
    public boolean isEmpty(){
        if (top == -1) return true;
            else return false;
    }

    public boolean isFull(){
        if (top == maxSize - 1) return true;
            else return false;
    }

    public void push(String newItem) {
        if (!isFull()) {
            top++;
            stack[top] = newItem;
        }
    }

    public String pop(){
        if (!isEmpty()) {
            String tmp = stack[top];
            top--;
            return tmp;
        } else return null;
    }

    public String peek(){
        if (!isEmpty()) return stack[top];
            else return null;
    }

    public void ensureCapacity() {
        if (maxSize == stack.length) {
            stack = Arrays.copyOf(stack, maxSize * 2);
        }
    }
}