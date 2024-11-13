package DSA.tut8;

public class ArrayReversing {
    public static void reverseStack(SLLStack stack) {
        int size = 0;
        char temp;
        ArrayQueue queue = new ArrayQueue(stack.size());

        // Empty the stack into the queue
        while (!stack.isEmpty()) {
            temp = stack.pop();
            queue.insert(temp);
            size++;
        }

        // Refill the stack from the queue
        while (!queue.isEmpty()) {
            temp = queue.remove();
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        SLLStack stack = new SLLStack();
        stack.push('A');
        stack.push('B');
        stack.push('C');

        System.out.println("Original stack:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        stack.push('A');
        stack.push('B');
        stack.push('C');

        reverseStack(stack);

        System.out.println("Reversed stack:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
