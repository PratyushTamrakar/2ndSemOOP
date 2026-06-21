package Ques6;

public class Ques6Main {
    public static void main(String[] args){

        Member student = new StudentMember("Ram");
        Member teacher = new TeacherMember("Shyam");

        student.borrowLimit();
        teacher.borrowLimit();

        student.Display();
        teacher.Display();

    }
}

