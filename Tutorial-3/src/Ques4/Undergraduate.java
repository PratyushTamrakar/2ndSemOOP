package Ques4;

class Undergraduate extends AbtStud{
    double credHr;
    double feePerCred;

    Undergraduate(String name, int id, double credHr, double feePerCred) {
        super(name, id);
        this.credHr = credHr;
        this.feePerCred = feePerCred;
    }

    @Override
    double calculateFee() {
        return credHr * feePerCred;
    }
}
