package Ques1;

public class Ques1Main {

    public static void main(String[] args){

        Student student1 = new Student("Pratyush Tamrakar",20,"BCS");
        Student student2 = new Student("Nishan Subedi",18,"BCS");

        student1.Display();
        student2.Display();
        student1.setName("Mohit Oli");
        student1.Display();

    }

}
