package DSA.tut10;
import java.util.Stack;
class ExpressionTree {
    ETNode root;

    public ExpressionTree() {
        this.root = null;
    }

    public void buildExpressionTree(String postfix) {
        Stack<ETNode> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(new ETNode(String.valueOf(c)));
            } else {
                ETNode right = stack.pop();
                ETNode left = stack.pop();
                ETNode newNode = new ETNode(String.valueOf(c));
                newNode.left = left;
                newNode.right = right;
                stack.push(newNode);
            }
        }

        this.root = stack.pop();
    }

    public int evaluate() {
        return evaluate(root);
    }

    private int evaluate(ETNode node) {
        if (Character.isDigit(node.value.charAt(0))) {
            return Integer.parseInt(node.value);
        }

        int leftValue = evaluate(node.left);
        int rightValue = evaluate(node.right);

        switch (node.value.charAt(0)) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Invalid operator: " + node.value);
        }
    }
}
