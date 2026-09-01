package Ques2;

public class Teacher extends Employee{
    protected String subject;

    public Teacher(int id, String name, String subject){
        super(id,name);
        this.subject=subject;
    }

    public void Display(){
        System.out.println("\n<----- Teacher ----->");
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Subject : "+subject);
    }
}