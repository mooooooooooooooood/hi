package DSA.tut4;
import java.util.Scanner;

public class TopStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to input n
        System.out.print("Enter the number of students (n): ");
        int n = scanner.nextInt();

        // Create arrays to store student names and marks
        String[] names = new String[n];
        int[] marks = new int[n];

        // Ask user to input student names and marks
        System.out.println("Enter the names and marks of students:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " Name: ");
            names[i] = scanner.next();
            System.out.print("Student " + (i + 1) + " Mark: ");
            marks[i] = scanner.nextInt();
        }

        // Ask user to input m
        System.out.print("Enter the number of top students to display (m): ");
        int m = scanner.nextInt();

        // Find and display the top m students
        displayTopStudents(names, marks, m);

        scanner.close();
    }

    private static void displayTopStudents(String[] names, int[] marks, int m) {
        // Ensure m is not greater than the number of students
        m = Math.min(m, names.length);

        // Sort students based on marks in descending order
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - i - 1; j++) {
                if (marks[j] < marks[j + 1]) {
                    // Swap marks
                    int tempMark = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = tempMark;

                    // Swap names
                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
            }
        }

        // Display the top m students
        System.out.println("Top " + m + " Students:");

        for (int i = 0; i < m; i++) {
            System.out.println(names[i] + ": " + marks[i]);
        }
    }
}
