package DSA.tut3;
import java.util.Scanner;

public class SimpleGCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first integer (m): ");
        int m = sc.nextInt();

        System.out.print("Enter the second integer (n): ");
        int n = sc.nextInt();

        System.out.println();
        int gcd = simpleGCD(m, n);
        System.out.print("The greatest common divisor (gcd) of " + m + " and " + n + " is " + gcd);
    }

    public static int simpleGCD(int m, int n) {
        int i = n;
        while (i > 1) {
            if ((m % i == 0) && (n % i == 0)) return i;
            i--;
        }
        return 1;
    }

    public static int efficientGCD(int m, int n) {
        while (n > 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
}