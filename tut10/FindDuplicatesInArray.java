package DSA.tut10;
import java.util.Scanner;

public class FindDuplicatesInArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        //Build bst from array
        BinarySearchTree bst = new BinarySearchTree();
        for (int i : array) {
            if (!bst.insert(i, bst))
                System.out.println("Duplicate found: " + i);
        }

        scanner.close();
    }
}
