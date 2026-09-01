import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        String grade =
                (marks >= 90) ? "A+" :
                        (marks >= 85) ? "A" :
                        (marks >= 80) ? "A-" :
                        (marks >= 75) ? "B+" :
                        (marks >= 70) ? "B" :
                        (marks >= 65) ? "B-" :
                        (marks >= 60) ? "C+" :
                        (marks >= 55) ? "C" :
                        (marks >= 50) ? "C-" :
                        "F";

        System.out.println("Grade: " + grade);

        sc.close();
    }
}