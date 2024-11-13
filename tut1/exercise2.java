package DSA.tut1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        boolean condition = false;

        while (true) {
            try {
                System.out.print("Enter the number of integers in the list: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("Please enter a positive integer!");
                    continue;
                }

                int[] array = new int[n];
                System.out.print("Enter the intergers (seperated by spacing or enter): ");
                for (int i = 0; i < n; i++) {
                    int num = sc.nextInt();
                    array[i] = num;
                }

                int max = array[0];
                for (int j = 1; j < n; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                System.out.print("The maximum integer in the array is "+max);
                break;

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter an integer!");
                sc.nextLine();
            }
        }
    }
}
