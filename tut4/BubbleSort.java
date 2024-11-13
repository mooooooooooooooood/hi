package DSA.tut4;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of integers in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }

        //Bubble sort
        for (int i = 0; i <= n-2; i++) {
            for (int j =0; j <= n-i-2; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        System.out.print("Sorted array: ");
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}
