package Ques4;


public class Ques4Main {
    public static void main(String[] args){
        AbtStud ug = new Undergraduate("Pratyush", 101, 20, 150);
        AbtStud pg = new Graduate("Trishna", 201, 3000, 1200);

        ug.display();
        System.out.println("Undergraduate Fee: " + ug.calculateFee());

        System.out.println();

        pg.display();
        System.out.println("Graduate Fee: " + pg.calculateFee());
    }
}
