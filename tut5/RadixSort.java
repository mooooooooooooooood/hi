package DSA.tut5;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        // Ask user to input n and k
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array (n): ");
        int n = sc.nextInt();
        System.out.print("Enter the maximum number of digits (k) in the array elements: ");
        int k = sc.nextInt();

        // Ask user to input array A
        int[] A = new int[n];
        System.out.println("Enter elements of the array (each element has maximum k digits):");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            A[i] = sc.nextInt();
        }

        // Sort the array A using Radix Sort algorithm
        radixSort(A, k);

        // Show the result
        System.out.print("Sorted array: ");
        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    // Radix Sort algorithm
    public static void radixSort(int[] a, int k) {
        int n = a.length;
        int maxNum = getMax(a);

        // Perform counting sort for every digit place
        for (int exp = 1; maxNum / exp > 0; exp *= 10) {
            countingSort(a, n, exp);
        }
    }

    // Counting Sort for Radix Sort
    public static void countingSort(int[] a, int n, int exp) {
        int[] b = new int[n];
        int[] c = new int[10]; // Assuming base 10 (digits 0 to 9)

        // Initialize count array
        for (int i = 0; i < 10; i++) {
            c[i] = 0;
        }

        // Count occurrences of each element
        for (int i = 0; i < n; i++) {
            c[(a[i] / exp) % 10]++;
        }

        // Update count array to store cumulative counts
        for (int i = 1; i < 10; i++) {
            c[i] = c[i] + c[i - 1];
        }

        // Build the sorted array
        for (int i = n - 1; i >= 0; i--) {
            b[c[(a[i] / exp) % 10] - 1] = a[i];
            c[(a[i] / exp) % 10]--;
        }

        // Copy the sorted array back to the original array
        System.arraycopy(b, 0, a, 0, n);
    }

    // Get the maximum number in the array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
