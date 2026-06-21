package Ques7;

class MedicalAttendance extends Attendance {

    public MedicalAttendance(String name,int totalClasses, int attendedClasses) {
        super(name , totalClasses, attendedClasses);
    }

    @Override
    public double calculateAttendance() {
        double percentage = super.calculateAttendance();
        return Math.ceil(percentage);
    }
}