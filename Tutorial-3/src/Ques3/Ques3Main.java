package Ques3;


import java.util.ArrayList;

public class Ques3Main{
    public static void main(String[] args){

        Course[] courses = {
                new Course(101, "OOP"),
                new Course(102, "Computer System"),
                new Course(103, "Computer Architecture"),
                new Course(104, "Networking"),
                new Course(105, "Computer Ethics")
        };
        Student stud1 = new Student(18,"Pratyush Tamrakar");

        ArrayList<Course> courseList = new ArrayList<>();

        for(Course course : courses){
            courseList.add(course);
        }
        System.out.println("\nAvailable Courses");
        System.out.println("---------------------");
        for(Course course: courseList){
            System.out.println(course);
        }
        System.out.println("--------------------------------------------");


        stud1.RegCourses(courseList.get(1));
        stud1.RegCourses(courseList.get(0));
        stud1.Display();

        

    }
}