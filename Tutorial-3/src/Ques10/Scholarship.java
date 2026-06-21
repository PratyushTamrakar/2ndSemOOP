package  Ques10;

abstract class Scholarship{
    protected String name;

    public Scholarship(String name){
        this.name = name;
    }
    public abstract boolean isEligible();

    public void displayResult(){
        System.out.println();
        if(isEligible()){
            System.out.println(name+", you are eligible for Scholarship .");
        }else{
            System.out.println(name+", you are not eligible for this scholarship.");
        }
    }

}