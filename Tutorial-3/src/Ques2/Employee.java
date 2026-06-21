package Ques2;
public class Employee{
    protected int id;
    protected String name;

    public Employee(int id, String name){
        this.id=id;
        this.name=name;
    }
    public void Display(){
        System.out.println("\n<---- Employees ---->");
        System.out.println("Emp id : "+id);
        System.out.println("Emp name : "+name);
    }
}