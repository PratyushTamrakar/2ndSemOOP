package Ques5;

public class ManagementDepartment implements  ResultProcessor{

    @Override
    public double calculateGrade(double marks){
        return marks;
    }
    public String getGradeStatus(double marks) {
        double grade = calculateGrade(marks);

        if (grade >= 80) return "Distinction";
        else if (grade >= 65) return "First Class";
        else if (grade >= 50) return "Pass";
        else return "Fail";
    }
}
