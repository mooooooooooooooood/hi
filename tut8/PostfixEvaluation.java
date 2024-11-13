package DSA.tut8;

public class PostfixEvaluation {
    public static int evaluatePostfix(String expression) {
        ArrayStack stack = new ArrayStack();
        String[] tokens = expression.split("\\s+"); // Split the expression by whitespace

        for (String token : tokens) {
            if (token.matches("-?\\d+")) { // Check if the token is a number
                stack.push(token); // Push numbers onto the stack
            } else {
                // Token is an operator
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());

                switch (token) {
                    case "+":
                        stack.push(String.valueOf(operand1 + operand2));
                        break;
                    case "-":
                        stack.push(String.valueOf(operand1 - operand2));
                        break;
                    case "*":
                        stack.push(String.valueOf(operand1 * operand2));
                        break;
                    case "/":
                        stack.push(String.valueOf(operand1 / operand2));
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String postfixExpression = "5 3 + 6 *";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}
