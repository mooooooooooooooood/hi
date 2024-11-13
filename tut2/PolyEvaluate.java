package DSA.tut2;
import java.util.Scanner;

public class PolyEvaluate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the degree of the polynomial (n): ");
        int n = sc.nextInt();

        double[] C = new double[n];
        System.out.print("Enter the coefficients of the polynomial (C) separated by space: ");
        for (int i = 0; i < n; i++) {
            C[i] = sc.nextDouble();
        }

        System.out.print("Enter the real number (x): ");
        double x = sc.nextDouble();

        //pt: f(x)= c0x0 + c1x^1 + c2x^2 + ....

        double result = polyEvaluate(C, n, x);
        System.out.println("The value of f(x) is: " + result);

        sc.close();
    }

    public static double polyEvaluate(double[] C, int n, double x) {
        double s = 0.0;

        for (int i = 0; i < n; i++) {
            double p = 1.0;

            if (i != 0) {
                for (int k = 1; k <= i; k++) {
                    p *= x;
                }
            }

            s += C[i] * p;
        }

        return s;
    }
}
