package DSA.tut5;
import java.util.Scanner;

public class QuickSort {
    public static void quickSort (int[] a, int left, int right) {
        if (left < right) {
           int pos = partition (a, left, right);
           quickSort(a, left, pos -1);
           quickSort(a, pos + 1, right);
        }
    }

    public static int partition (int[] a, int left, int right) {
        int down = left;
        int up = right;
        int pivot = a[left];
        while (down < up) {
            while (down < right && a[down] <= pivot) {down++;}
            while (up > left && a[up] > pivot) {up--;}
            if (down < up) {
                int tmp = a[down];
                a[down] = a[up];
                a[up] = tmp;
            }
        }
        a[left] = a[up];
        a[up] = pivot;
        return up;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        System.out.print("Enter elements of the array: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        quickSort(a, 0, n-1);
        System.out.print("Sorted array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
