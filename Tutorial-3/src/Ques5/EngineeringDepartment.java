package Ques5;

public class EngineeringDepartment implements ResultProcessor{

    @Override
    public double calculateGrade(double marks) {

        return marks * 0.9;
    }

    @Override
    public String getGradeStatus(double marks) {
        double grade = calculateGrade(marks);
        if (grade >= 85) return "Distinction";
        else if (grade >= 70) return "First Class";
        else if (grade >= 50) return "Pass";
        else return "Fail";
    }
}
