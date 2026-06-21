package Ques10;

public class MeritScholarship extends Scholarship{
    private final double gpa;

    public MeritScholarship(String name, double gpa) {
        super(name);
        this.gpa = gpa;
    }

    @Override
    public boolean isEligible() {
        return gpa >= 3.5;
    }
}