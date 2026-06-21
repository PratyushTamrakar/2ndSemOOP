package Ques4;

public class Graduate extends AbtStud{
    double flatFee;
    double researchFee;

    Graduate(String name, int id, double flatFee, double researchFee) {
        super(name, id);
        this.flatFee = flatFee;
        this.researchFee = researchFee;
    }

    @Override
    double calculateFee() {
        return flatFee + researchFee;
    }
}
