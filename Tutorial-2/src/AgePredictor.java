import java.util.Scanner;

public class AgePredictor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your current age: ");
        int age = sc.nextInt();

        int ageAfter10 = age + 10;
        int ageAfter25 = age + 25;
        int ageAfter50 = age + 50;

        int yearsTo100 = 100 - age;


        System.out.println("\n--- Age Predictions ---");
        System.out.println("Age after 10 years: " + ageAfter10);
        System.out.println("Age after 25 years: " + ageAfter25);
        System.out.println("Age after 50 years: " + ageAfter50);

        System.out.println("You will turn 100 in the year: " + yearsTo100);

        sc.close();
    }
}