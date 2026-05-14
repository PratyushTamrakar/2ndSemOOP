import java.util.Scanner;

class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number :");
        float a = sc.nextFloat();

        System.out.println("Enter the second number :");
        float b = sc.nextFloat();

        float sum = a+b;

        System.out.println("Sum("+a+"+"+b+"):"+sum);

    }
}