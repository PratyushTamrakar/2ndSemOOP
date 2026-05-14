public class Main{
    public static void main(String[] args){
         float a=20;
         float b=9;

         System.out.println("-----Arithmetic Operators-----");
         System.out.println("a+b:"+(a+b));
         System.out.println("a-b:"+(a-b));
         System.out.println("a*b:"+(a*b));
         System.out.println("a/b:"+(a/b));
         System.out.println("a%b:"+(a%b));

         System.out.println("-----Relational Operators-----");
         System.out.println("a>b:"+(a>b));
         System.out.println("a<b:"+(a<b));
         System.out.println("a==b:"+(a==b));
         System.out.println("a!=b:"+(a!=b));


         System.out.println("-----Logical Operators-----");

         int age = 20;
         boolean ID = true;

         if (age >= 18 && ID) {
              System.out.println("Allowed entry");
         }

         if (age < 18 || !ID) {
              System.out.println("Not allowed");
         }
    }
}