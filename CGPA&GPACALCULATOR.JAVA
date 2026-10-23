
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== GPA & CGPA CALCULATOR ===");

        System.out.print("Enter number of semesters: ");
        int semesters = sc.nextInt();
        sc.nextLine();

        double overallPercentage = 0;

        double totalObtained = 0;
        double totalMaximum = 0;

        for (int i = 1; i <= semesters; i++) {
            System.out.println("\n--- Semester " + i + " ---");

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();
            sc.nextLine();

            double semesterObtained = 0;
            double semesterMaximum = 0;

            for (int j = 1; j <= subjects; j++) {
                System.out.println("\nSubject " + j);

                System.out.print("Enter subject name: ");
                String name = sc.nextLine();

                System.out.print("Enter total marks: ");
                double maximum = sc.nextDouble();

                System.out.print("Enter marks obtained: ");
                double obtained = sc.nextDouble();
                sc.nextLine();

                if (maximum <= 0 || obtained < 0 || obtained > maximum) {
                    System.out.println("Invalid marks. Please restart.");
                    sc.close();
                    return;
                }

                semesterMaximum += maximum;
                semesterObtained += obtained;

                totalMaximum += maximum;
                totalObtained += obtained;
            }

            double gpa = (semesterObtained / semesterMaximum) * 10;

            System.out.printf(
                "\nSemester %d GPA: %.2f / 10%n", i, gpa
            );
            System.out.printf(
                "Semester %d Percentage: %.2f%%%n",
                i, (semesterObtained / semesterMaximum) * 100
            );
        }

        double cgpa = (totalObtained / totalMaximum) * 10;

        System.out.println("\n=== FINAL RESULT ===");
        System.out.printf("Total Marks: %.2f%n", totalMaximum);
        System.out.printf("Marks Obtained: %.2f%n", totalObtained);
        System.out.printf("Overall Percentage: %.2f%%%n",
                (totalObtained / totalMaximum) * 100);
        System.out.printf("Overall CGPA: %.2f / 10%n", cgpa);

        sc.close();
    }
}
