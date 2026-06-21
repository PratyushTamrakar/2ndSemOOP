
import Ques1.Ques1Main;
import Ques10.Ques10Main;
import Ques2.Ques2Main;
import Ques3.Ques3Main;
import Ques4.Ques4Main;
import Ques5.Ques5Main;
import Ques6.Ques6Main;
import Ques7.Ques7Main;
import Ques8.Ques8Main;
import Ques9.Ques9Main;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Enter your choice (0-10): ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (0-10): ");
                sc.next();
            }
            choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    runModule("Q1 - Student Information System", () -> Ques1Main.main(new String[]{}));
                    break;
                case 2:
                    runModule("Q2 - University Employee System", () -> Ques2Main.main(new String[]{}));
                    break;
                case 3:
                    runModule("Q3 - Course Registration System", () -> Ques3Main.main(new String[]{}));
                    break;
                case 4:
                    runModule("Q4 - Fee Structure (Abstract Class)", () -> Ques4Main.main(new String[]{}));
                    break;
                case 5:
                    runModule("Q5 - Grade Calculation (Interface)", () -> Ques5Main.main(new String[]{}));
                    break;
                case 6:
                    runModule("Q6 - Library Member System", () -> Ques6Main.main(new String[]{}));
                    break;
                case 7:
                    runModule("Q7 - Attendance Calculation System", () -> Ques7Main.main(new String[]{}));
                    break;
                case 8:
                    runModule("Q8 - Notification System (Interface)", () -> Ques8Main.main(new String[]{}));
                    break;
                case 9:
                    runModule("Q9 - Auto-Generated Unique Student ID", () -> Ques9Main.main(new String[]{}));
                    break;
                case 10:
                    runModule("Q10 - Scholarship Eligibility System", () -> Ques10Main.main(new String[]{}));
                    break;
                case 0:
                    System.out.println("Exiting University Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number between 0 and 10.");
            }

            if (choice != 0) {
                System.out.println("\nPress Enter to return to menu...");
                sc.nextLine();
                sc.nextLine();
            }

        } while (choice != 0);

        sc.close();
    }

    interface ModuleRunner {
        void run();
    }

    private static void runModule(String title, ModuleRunner module) {
        System.out.println("------------------------------------------------------------");
        System.out.println("  RUNNING: " + title);
        System.out.println("------------------------------------------------------------\n");
        module.run();
        System.out.println("\n------------------------------------------------------------");
        System.out.println("  " + title + " completed.");
        System.out.println("------------------------------------------------------------");
    }

    private static void printMenu() {
        System.out.println("\n============================================================");
        System.out.println("        UNIVERSITY MANAGEMENT SYSTEM - MAIN MENU");
        System.out.println("============================================================");
        System.out.println(" 1.  Student Information System");
        System.out.println(" 2.  Employee System (Teacher / AdminStaff)");
        System.out.println(" 3.  Course Registration System");
        System.out.println(" 4.  Fee Structure (Undergraduate / Graduate)");
        System.out.println(" 5.  Grade Calculation (Engineering / Management)");
        System.out.println(" 6.  Library Member System (Student / Teacher)");
        System.out.println(" 7.  Attendance Calculation (Engineering / Medical)");
        System.out.println(" 8.  Notification System (Email / SMS)");
        System.out.println(" 9.  Auto-Generated Unique Student ID");
        System.out.println("10.  Scholarship Eligibility (Merit / Need-Based)");
        System.out.println(" 0.  Exit");
        System.out.println("============================================================");
    }
}