package Ques6;

public class Member {

    protected String name;

    public Member(String name){
        this.name = name;
    }

    public int borrowLimit(){
        return 2;
    }

    public void Display(){
        System.out.println("\nName : "+name);
        System.out.println("Burrow Limit : "+borrowLimit());
    }

}
