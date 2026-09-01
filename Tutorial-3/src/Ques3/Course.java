package Ques3;

public class Course{
    private int id;
    private String Cname;

    public Course(int id, String Cname){
        this.id = id;
        this.Cname = Cname;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.Cname;
    }

    @Override
    public String toString() {
        return "Course ID : "+this.id+" Course Name : "+this.Cname;
    }
}