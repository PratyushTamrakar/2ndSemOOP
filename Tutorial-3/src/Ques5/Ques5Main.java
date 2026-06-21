package Ques5;

public class Ques5Main {
    public static void main(String[] args) {
        ResultProcessor eng = new EngineeringDepartment();
        ResultProcessor mgmt = new ManagementDepartment();

        double marks = 75;

        System.out.println("Engineering: " + eng.getGradeStatus(marks));
        System.out.println("Management: " + mgmt.getGradeStatus(marks));
    }
}
