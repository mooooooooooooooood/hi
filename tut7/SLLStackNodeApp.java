package DSA.tut7;

public class SLLStackNodeApp {
    public static void main(String[] args) {
        SLLStack stack = new SLLStack();

        // Push nodes onto the stack
        stack.push(new SLLStackNode("First Node"));
        stack.push(new SLLStackNode("Second Node"));
        stack.push(new SLLStackNode("Third Node"));

        // Peek at the top node
        SLLStackNode topNode = stack.peek();
        if (topNode != null) {
            System.out.println("Top Node: " + topNode.getData());
        } else {
            System.out.println("Stack is empty");
        }

        // Pop and print nodes from the stack
        System.out.println("Popping nodes from the stack:");
        while (!stack.isEmpty()) {
            SLLStackNode poppedNode = stack.pop();
            System.out.println("Popped Node: " + poppedNode.getData());
        }
    }
}
