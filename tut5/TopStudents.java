package DSA.tut5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students (n): ");
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        System.out.println("Enter student details (name and mark):");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " name: ");
            String name = sc.next();
            System.out.print("Student " + (i + 1) + " mark: ");
            int mark = sc.nextInt();
            students.add(new Student(name, mark));
        }

        System.out.print("Enter the number of top students to find (m): ");
        int m = sc.nextInt();

        List<String> topStudents = findTopStudents(students, m);
        System.out.println("Top " + m + " students:");

        for (String studentName : topStudents) {
            System.out.println(studentName);
        }
    }

    public static List<String> findTopStudents(List<Student> students, int m) {
        List<String> topStudents = new ArrayList<>();
        int[] buckets = new int[11];

        // Count the occurrences of each mark
        for (Student student : students) {
            buckets[student.getMark()]++;
        }

        // Find the top m students
        int count = 0;
        for (int mark = 10; mark >= 0; mark--) {
            for (Student student : students) {
                if (student.getMark() == mark) {
                    topStudents.add(student.getName());
                    count++;
                }

                if (count == m) {
                    return topStudents;
                }
            }
        }

        return topStudents;
    }
    static class Student {
        private String name;
        private int mark;

        public Student(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }

        public String getName() {
            return name;
        }

        public int getMark() {
            return mark;
        }
    }
}

