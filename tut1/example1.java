package DSA.tut1;
import java.text.DecimalFormat;
import java.util.*;

public class example1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first floating-point number: ");
        float a = sc.nextFloat();
        System.out.print("Enter the second floating-point number: ");
        float b = sc.nextFloat();
        sc.close();

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String num1 = decimalFormat.format(a);
        String num2 = decimalFormat.format(b);

        if (num1.equals(num2)) {System.out.print("The rounded numbers are the same.");}
            else {System.out.print("The rounded numbers are different.");}

    }
}
