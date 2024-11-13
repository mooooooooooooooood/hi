package DSA.tut10;
import java.util.Scanner;
import java.util.Stack;

public class ExpressionTreeTest {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an infix expression (with parentheses): ");
            String infix = scanner.nextLine();

            String postfix = infixToPostfix(infix);
            System.out.println("Postfix expression: " + postfix);

            ExpressionTree expressionTree = new ExpressionTree();
            expressionTree.buildExpressionTree(postfix);

            int result = expressionTree.evaluate();
            System.out.println("Result: " + result);
        }

        private static String infixToPostfix(String infix) {
            StringBuilder postfix = new StringBuilder();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < infix.length(); i++) {
                char c = infix.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    postfix.append(c);
                } else if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop());
                    }
                    stack.pop(); // Remove '('
                } else {
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                        postfix.append(stack.pop());
                    }
                    stack.push(c);
                }
            }

            while (!stack.isEmpty()) {
                postfix.append(stack.pop());
            }

            return postfix.toString();
        }

        private static int precedence(char operator) {
            if (operator == '+' || operator == '-') {
                return 1;
            } else if (operator == '*' || operator == '/') {
                return 2;
            } else {
                return 0; // Parentheses have the lowest precedence
            }
        }
}