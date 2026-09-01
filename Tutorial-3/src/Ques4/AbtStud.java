package Ques4;

abstract class AbtStud {

    String name;
    int id;

    AbtStud(String name, int id) {
        this.name = name;
        this.id = id;
    }
    abstract double calculateFee();

    public void display(){
        System.out.println("Name : "+name);
        System.out.println("ID : "+id);
    }
}
