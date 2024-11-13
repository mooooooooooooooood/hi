package DSA.tut4;
import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmsBenchmark {
    public static void main(String[] args) {
        int N = 1000; // You can adjust the size of the array as needed
        int[] sourceArray = generateRandomArray(N);

        // Sort using different algorithms and measure running time
        benchmarkSortingAlgorithm("Bubble Sort", Arrays.copyOf(sourceArray, N), SortingAlgorithmsBenchmark::bubbleSort);
        benchmarkSortingAlgorithm("Selection Sort", Arrays.copyOf(sourceArray, N), SortingAlgorithmsBenchmark::selectionSort);
        benchmarkSortingAlgorithm("Insertion Sort", Arrays.copyOf(sourceArray, N), SortingAlgorithmsBenchmark::insertionSort);
        benchmarkSortingAlgorithm("Merge Sort", Arrays.copyOf(sourceArray, N), SortingAlgorithmsBenchmark::mergeSort);
    }

    // Function to generate a random array of the given size
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // You can adjust the upper limit as needed
        }

        return array;
    }

    // Function to benchmark a sorting algorithm and measure running time
    public static void benchmarkSortingAlgorithm(String algorithmName, int[] array, SortingFunction sortingFunction) {
        long startTime = System.nanoTime();

        // Perform sorting
        sortingFunction.sort(array);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds

        System.out.println(algorithmName + " sorted in " + duration + " milliseconds");
    }

    // Sorting algorithms implementations

    public static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i <= n-2; i++) {
                for (int j =0; j <= n-i-2; j++) {
                    if (arr[j] > arr[j+1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = tmp;
                    }
                }
            }
    }

    public static void selectionSort(int[] arr) {
            int n = arr.length;
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
        }

    public static void insertionSort(int[] arr) {
            int n = arr.length;
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
    }
    public static void mergeSort(int[] arr) {
        mergeSort1(arr, 0, arr.length - 1);
    }
    public static void mergeSort1(int[] arr, int left, int right) {
            int n = arr.length;
            if (left < right) {
                int mid = (left + right)/2;
                mergeSort1(arr, left, mid);
                mergeSort1(arr, mid +1, right);
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
    }

    // Functional interface for sorting functions
    @FunctionalInterface
    interface SortingFunction {
        void sort(int[] arr);
    }
