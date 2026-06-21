package Ques10;

public class NeedBasedScholarship extends Scholarship{
    private double familyIncome;

    public NeedBasedScholarship(String name, double familyIncome) {
        super(name);
        this.familyIncome = familyIncome;
    }

    @Override
    public boolean isEligible() {
        return familyIncome <= 20000;
    }
}