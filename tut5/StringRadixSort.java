package DSA.tut5;
import java.util.Scanner;

public class StringRadixSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of strings (n): ");
        int n = sc.nextInt();
        System.out.print("Enter the length of each string (m): ");
        int m = sc.nextInt();
        String[] strings = new String[n];

        System.out.println("Enter " + n + " strings of length " + m + ":");
        for (int i = 0; i < n; i++) {
            System.out.print("String " + (i + 1) + ": ");
            strings[i] = sc.next();
        }

        radixSort(strings, m);

        System.out.println("Sorted strings:");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static void radixSort(String[] arr, int m) {
        int n = arr.length;

        // Perform counting sort for each character place from right to left
        for (int i = m - 1; i >= 0; i--) {
            countingSort(arr, n, i);
        }
    }

    public static void countingSort(String[] arr, int n, int index) {
        int[] count = new int[256]; //ASCII characters (0 to 255)
        String[] output = new String[n];

        // Count occurrences of each character at the specified index
        for (int i = 0; i < n; i++) {
            count[arr[i].charAt(index)]++;
        }

        // Update count array to store cumulative counts
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array based on the current character place
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i].charAt(index)] - 1] = arr[i];
            count[arr[i].charAt(index)]--;
        }

        // Copy the sorted array back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }
}

