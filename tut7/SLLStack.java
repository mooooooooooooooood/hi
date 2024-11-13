package DSA.tut7;

public class SLLStack {
    private SLLStackNode top;
    public SLLStack() {
        this.top = top;
    }
    public boolean isEmpty() {
        if (top == null) return true;
            else return false;
    }

    public void push (SLLStackNode newNode) {
        newNode.setNext(top);
        top = newNode;
    }

    public SLLStackNode pop() {
        if (!isEmpty()) {
            SLLStackNode topNode = top;
            top = top.getNext();
            return topNode;
        } else return null;
    }

    public SLLStackNode peek() {
        if (!isEmpty()) return top;
            else return null;
    }
}