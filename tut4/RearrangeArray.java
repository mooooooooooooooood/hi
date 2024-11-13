package DSA.tut4;
import java.util.Scanner;
import java.util.Arrays;
public class RearrangeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }

        //mergeSort(arr, 0, n-1);
        rearrangeArray(arr);

        System.out.print("Rearranged array: ");
        for (int num : arr) {
            System.out.print(num+ " ");
        }
    }

    public static void mergeSort (int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid +1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge (int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    //O(n) có thể tham khảo quicksort
    public static void rearrangeArray (int[] A){
        int negativeIndex = 0;
        int zeroIndex = 0;
        int positiveIndex = A.length - 1;

        while (zeroIndex <= positiveIndex) {
            if (A[zeroIndex] < 0) {
                // Negative element, swap with negativeIndex
                swap(A, zeroIndex, negativeIndex);
                zeroIndex++;
                negativeIndex++;
            } else if (A[zeroIndex] > 0) {
                // Positive element, swap with positiveIndex
                swap(A, zeroIndex, positiveIndex);
                positiveIndex--;
            } else {
                // Zero element, leave it in the middle
                zeroIndex++;
            }
        }

        /* Sort negative and positive segments
        Arrays.sort(A, 0, negativeIndex);
        Arrays.sort(A, positiveIndex + 1, A.length);*/
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

