import java.util.Scanner;

public class StudentResultsSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        if (numberOfStudents <= 0) {
            System.out.println("Number of students must be greater than zero.");
            input.close();
            return;
        }

        int[] marks = new int[numberOfStudents];

        int total = 0;
        int highest = 0;
        int lowest = 100;
        int passed = 0;
        int failed = 0;

        // Input students' marks
        for (int i = 0; i < numberOfStudents; i++) {

            System.out.print("Enter mark for student "
                    + (i + 1) + " (0-100): ");

            int mark = input.nextInt();

            if (mark < 0 || mark > 100) {
                System.out.println(
                        "Invalid mark. Enter a value from 0 to 100.");
                i--;
                continue;
            }

            marks[i] = mark;
            total += mark;

            if (mark > highest) {
                highest = mark;
            }

            if (mark < lowest) {
                lowest = mark;
            }

            if (mark >= 50) {
                passed++;
            } else {
                failed++;
            }
        }

        double average = (double) total / numberOfStudents;

        System.out.println("\n===== STUDENT RESULTS =====");

        for (int i = 0; i < marks.length; i++) {
            System.out.println(
                    "Student " + (i + 1) + ": " + marks[i]);
        }

        System.out.println("Total marks: " + total);
        System.out.printf("Average mark: %.2f%n", average);
        System.out.println("Highest mark: " + highest);
        System.out.println("Lowest mark: " + lowest);
        System.out.println("Students passed: " + passed);
        System.out.println("Students failed: " + failed);

        input.close();
    }
}
