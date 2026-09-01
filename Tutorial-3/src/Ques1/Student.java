package Ques1;

public class Student {
    private String name;
    private int rollNum;
    private String faculty;

    public Student(String name, int rollNum, String faculty){
        this.name = name;
        this.rollNum = rollNum;
        this.faculty = faculty;
    }

    public String getName(){
        return name;
    }
    public int getRollNum(){
        return rollNum;
    }
    public String getFaculty(){
        return faculty;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setRollNum(int rollNum){
        this.rollNum = rollNum;
    }
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }

    public void Display(){
        System.out.println("\n<---- Student Profile ----->");
        System.out.println("Student Name : "+name);
        System.out.println("Student RollNumber : "+rollNum);
        System.out.println("Student Faculty : "+faculty);

    }

}
