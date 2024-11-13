package DSA.tut8;
public class BaseConversion {

    public static String convertToBase(int number, int base) {
        if (number == 0) {
            return "0";
        }

        ArrayStack2 stack = new ArrayStack2(32);

        while (number > 0) {
            int remainder = number % base;
            stack.push(remainder);
            number /= base;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int number = 173;
        int base = 5;

        String result = convertToBase(number, base);
        System.out.println("Base " + base + " representation of " + number + ": " + result);
    }
}
