package DSA.tut3;
import java.util.Scanner;

public class SimplePow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a real number: ");
        double x = sc.nextDouble();

        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        double s = efficientPow(x,n);
        System.out.print("The value of x power n is: " + s);

        sc.close();
    }

    public static double simplePow (double x, int n) {
        double s = 1;
        if (n == 0) {
            return s;
        }
        for (int i = 1; i <= n; i++) {
            s = s*x;
        }
        return s;
    }

    //O(log n)
    public static double efficientPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double halfPow = efficientPow(x, n / 2);

        if (n % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return x * halfPow * halfPow;
        }
    }
}
