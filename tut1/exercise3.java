package DSA.tut1;
import java.util.*;


public class exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        boolean boo = false;

        while (true) {
            try {
                System.out.print("Enter the number of integers in the array: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("Please enter a positive input!");
                    continue;
                }
                int[] array = new int[n];

                System.out.print("Enter the integers to the array: ");
                for (int x = 0; x<n; x++) {
                    int num = sc.nextInt();
                    array[x] = num;
                }

                System.out.print("The sorted array: " + Arrays.toString(selectionSort(array)));
                break;

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please enter a valid input!");
                sc.nextLine();
            }

        }
    }

    public static int[] selectionSort (int[] a) {
        int[] b = new int [a.length];
        for (int i = 0; i < a.length; i++) {
            int p = i;
            for (int j = i +1; j < a.length; j++) {
                if (a[j] < a[p]) { p = j; }
            }
            b[i] = a[p];
            a[p] = a[i];
        }
        return b;
    }
}
