package Ques3;

import java.util.ArrayList;

public class Student{

    int rollnum;
    String name;
    ArrayList<Course> course;
    ArrayList<Course> regCourse;

    public Student(int rollnum, String name){
        this.rollnum = rollnum;
        this.name = name;
        this.course =new ArrayList<>();
        this.regCourse = new ArrayList<>();
    }
    public void RegCourses(Course course){
        regCourse.add(course);
        System.out.println("Registered sucessfully .... ");
    }
    public void Display(){
        System.out.println("\n\n<---- Student Details ---->");
        System.out.println("Name : "+name);
        System.out.println("Roll Number : "+rollnum);
        System.out.println("Registerd Courses : ");
        for(Course course : regCourse){
            System.out.println(course);
        }
    }

}