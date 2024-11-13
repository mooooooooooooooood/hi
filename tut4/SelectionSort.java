package DSA.tut4;
import java.util.Scanner;
public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of integers in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }

        //Selection sort
        int max, pos;
        for (int i = n-1; i > 0; i--) {
            max = arr[i];
            pos = i;
            for (int j = i - 1; j>= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                    pos = j;
                }
            }
            arr[pos] = arr[i];
            arr[i]= max;
        }

        System.out.print("Sorted array: ");
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}
