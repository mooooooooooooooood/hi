package DSA.tut1;
import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = sc.nextLine();

        int n = 0;
        for (int i = 0; i < name.length() ; i++)
            if (name.charAt(i) != ' ') {
                n++;
            }

        System.out.print("The number of characters that the name has (exclusive the space) is " + n);
    }
}
