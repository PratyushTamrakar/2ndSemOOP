package Ques2;

public class Ques2Main{
    public static void main(String[] args) {
        Employee emp = new Employee(1,"alan");
        AdminStaff admin = new AdminStaff(2,"John Wick","BCS");
        Teacher teach = new Teacher(3,"Harry Potter","Magic");

        emp.Display();
        admin.Display();
        teach.Display();

    }

}

