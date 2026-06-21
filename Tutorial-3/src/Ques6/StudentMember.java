package Ques6;

public class StudentMember extends Member{

    public StudentMember(String name){
        super(name);
    }

    @Override
    public int borrowLimit(){
        return 4;
    }

}
