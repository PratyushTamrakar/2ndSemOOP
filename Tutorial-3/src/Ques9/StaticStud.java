package Ques9;

public class StaticStud {
    public static int counter = 1000;
    private int id;
    private String name;

    StaticStud(String name){
        this.name = name;
        this.id = counter++;
    }
    public void displayInfo(){
        System.out.printf("\nID: %d   Name: %s ",this.id,this.name);
    }
}
