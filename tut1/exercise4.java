package DSA.tut1;
import java.util.*;

public class exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the list: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] nameList = new String[n];
        System.out.println("Enter the names into the list: ");
        for (int i = 0; i<n ; i++) {
            String name = sc.nextLine();
            nameList[i] = name;
        }

        System.out.print("Enter a name to search: ");
        String findName = sc.nextLine();
        int position = searchName(nameList, findName);

        if (position == -1) {
            System.out.print("This name is not on the list.");
        } else System.out.print("This name is found at position " + position);
        sc.close();
    }

    public static int searchName (String[] nameList, String searchName) {
        for (int i = 0; i < nameList.length; i++) {
            if (nameList[i].equalsIgnoreCase(searchName)) {
                return i;
            }
        }
        return -1;
    }
}
