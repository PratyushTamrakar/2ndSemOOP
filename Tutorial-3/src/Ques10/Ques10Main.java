package Ques10;

public class Ques10Main{
    public static void main(String[] args){
        Scholarship std1 = new MeritScholarship("Pratyush",3.8);
        Scholarship std2 = new NeedBasedScholarship("Dipan",50000);

        std1.displayResult();
        std2.displayResult();
    }
}