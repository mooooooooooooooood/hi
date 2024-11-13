package DSA.tut5;
import java.util.Scanner;

public class CountingSort {
    public static void countingSort(int[] a, int n, int k) {
        int[] b = new int[n];
        int[] c = new int[k + 1]; // Adjust the length of c

        // Initialize count array
        for (int i = 0; i <= k; i++) {
            c[i] = 0;
        }

        // Count occurrences of each element
        for (int i = 0; i < n; i++) {
            c[a[i]] = c[a[i]] + 1;
        }

        // Update count array to store cumulative counts
        for (int i = 2; i <= k; i++) {
            c[i] = c[i] + c[i - 1];
        }

        // Build the sorted array
        for (int i = n - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]] = c[a[i]] - 1;
        }

        // Copy the sorted array back to the original array
        System.arraycopy(b, 0, a, 0, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        System.out.print("Enter the maximum value (k) in the array: ");
        int k = sc.nextInt();

        int[] a = new int[n];
        System.out.print("Enter elements of the array: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        countingSort(a, n, k);
        System.out.print("Sorted array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
