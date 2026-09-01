import java.util.Scanner;

public class LogicOperator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three integer numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if ((a + b) == c) {
            System.out.println("Third number is the sum of first two.");
        } else {
            System.out.println("Third number is not the sum of first two.");
        }
    }
}