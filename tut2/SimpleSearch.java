package DSA.tut2;
import java.util.Scanner;

public class SimpleSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array (n): ");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.print("Enter the sorted array elements separated by space: ");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("Enter the integer to search (m): ");
        int m = sc.nextInt();

        int[] Arr = arraySort(A);

        int result = simpleSearch(Arr, n, m);
        if (result != -1) {
            System.out.println("Integer " + m + " found at index " + result);
        } else {
            System.out.println("Integer " + m + " does not appear in the array.");
        }

        sc.close();
    }

    public static int simpleSearch(int[] A, int n, int m) { //Big-Oh = O(n)
        for (int i = 0; i < n; i++) {
            if (A[i] == m) {
                return i;
            }
        }
        return -1;
    }

    public static int[] arraySort (int[] a) {
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
} //cải thiện thuật toán bằng cách dùng BinarySearch (Big-Oh sẽ là O(log n))