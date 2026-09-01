import java.util.Scanner;

public class AttendanceChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of classes conducted: ");
        int classConducted = sc.nextInt();

        System.out.print("Enter number of classes attended: ");
        int classAttended = sc.nextInt();

        if (classConducted == 0) {
            System.out.println("Invalid input: Classes conducted cannot be zero.");
        } else {
            double attendancePercentage = ((double) classAttended / classConducted) * 100;

            System.out.printf("Attendance Percentage: %.2f \n ",attendancePercentage);

            if (attendancePercentage >= 75) {
                System.out.println("Eligible for Exam");
            } else {
                System.out.println("Not Eligible");
            }
        }

        sc.close();
    }
}