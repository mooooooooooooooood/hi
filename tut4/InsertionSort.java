package DSA.tut4;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of integers in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }

        //Insertion sort
        int key;
        for (int j =1; j < n; j++) {
            key = arr[j];
            int i = j-1;
            while ((i >= 0) && (arr[i] > key)) {
                arr[i+1] = arr[i];
                i = i-1;
            }
            arr[i+1] = key;
        }

        System.out.print("Sorted array: ");
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}
