package DSA.tut7;

public class ArrayStackApp {
    public static void copyStack(ArrayStack src, ArrayStack des) {
        ArrayStack tempStack = new ArrayStack();

        // Copy elements from src to tempStack while preserving src
        while (!src.isEmpty()) {
            String element = src.pop();
            tempStack.push(element);
        }

        // Copy elements from tempStack to des and restore src
        while (!tempStack.isEmpty()) {
            String element = tempStack.pop();
            des.push(element);
            src.push(element);
        }
    }

    public static void printStack(ArrayStack stack) {
        ArrayStack tempStack = new ArrayStack();

        // Copy elements from stack to tempStack while preserving stack
        while (!stack.isEmpty()) {
            String element = stack.pop();
            System.out.println(element);
            tempStack.push(element);
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

    }
    public static void main(String[] args) {
        ArrayStack stack1 = new ArrayStack();
        ArrayStack stack2 = new ArrayStack();

        stack1.push("a");
        stack1.push("b");
        stack1.push("c");

        System.out.println("Stack 1:");
        printStack(stack1);
        System.out.println("Top of stack 1: "+stack1.peek());
        System.out.println();

        copyStack(stack1, stack2);
        System.out.println();

        System.out.println("Stack 2 (copied from Stack 1):");
        printStack(stack2);
        stack2.pop();
        System.out.println("Stack 2 after popping top: ");
        printStack(stack2);
    }
}
