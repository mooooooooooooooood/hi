package DSA.tut1;
import java.util.Scanner;
import java.util.Random;

public class example2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        sc.close();

        Random random = new Random();
        System.out.print("The generated array: ");
        for (int i = 0; i< arr.length; i++) {
            arr[i] = random.nextInt(100); //nếu ko có bound nó chạy ngẫu nhiên trong range của int, còn có thì chạy từ 0 đến bound-1
            System.out.print(arr[i] + " ");
        }
    }
}
