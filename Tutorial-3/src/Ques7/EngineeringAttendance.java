package Ques7;

class EngineeringAttendance extends Attendance {

    public EngineeringAttendance(String name,int totalClasses, int attendedClasses) {
        super(name , totalClasses, attendedClasses);
    }

    @Override
    public double calculateAttendance() {
        double percentage = super.calculateAttendance();
        return Math.floor(percentage);
    }
}