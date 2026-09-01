package Ques7;

public class Ques7Main {
    public static void main(String[] args) {
        Attendance eng = new EngineeringAttendance("Dipan Koirala",60, 52);
        Attendance med = new MedicalAttendance("Supreem Khadka",60, 60);

        System.out.println("Engineering Attendance: " + eng.calculateAttendance() + "%");
        System.out.println("Medical Attendance: " + med.calculateAttendance() + "%");
    }
}