package Ques7;

public class Attendance{
    protected String name;
    protected int totalClasses;
    protected int attendedClasses;

    public Attendance(String name, int totalClasses, int attendedClasses){
        this.name = name;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public double calculateAttendance(){
        if (attendedClasses ==0) return 0;
        else {
            return ((double) attendedClasses/totalClasses)*100 ;
        }
    }
}