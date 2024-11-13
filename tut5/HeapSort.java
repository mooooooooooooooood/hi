package DSA.tut5;
import java.util.Scanner;

public class HeapSort {
    public static void heapSort (int[] a) {
        int n = a.length;
        buildHeap(a, n);
        for (int i = n - 1; i >= 1; i--) {
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            n = n-1;
            trickleDown(a, n, 0);
        }
    }
    public static void buildHeap (int[] a, int n) {
        for (int i = n/2 - 1; i >= 0; i--) {
            trickleDown(a, n, i);
        }
    }
    public static void trickleDown(int[] a, int n, int i) {
        int left = 2 * i + 1; //leftChild(i)
        int right = 2 * i + 2; //rightChild(i)
        int maxPos = i;
        if (left < n && a[left] > a[maxPos]) {
            maxPos = left;
        }
        if (right < n && a[right] > a[maxPos]) {
            maxPos = right;
        }
        if (maxPos != i) {
            int tmp = a[i];
            a[i] = a[maxPos];
            a[maxPos] = tmp;

            trickleDown(a, n, maxPos);
        }
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

        heapSort(a);
        System.out.print("Sorted array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
