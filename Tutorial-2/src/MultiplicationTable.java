import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("<----- Multiplication Table ---->");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d \n" ,n,i, (n * i));
        }
        System.out.println("<------------------------------->");
    }
}