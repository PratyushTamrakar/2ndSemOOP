package Ques2;

public class AdminStaff extends Employee{
    private final String department;

    public AdminStaff(int id, String name, String department){
        super(id,name);
        this.department = department;
    }

    @Override
    public void Display(){
        System.out.println("\n<---- AdminStaff ----->");
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Department : "+department);
    }
}