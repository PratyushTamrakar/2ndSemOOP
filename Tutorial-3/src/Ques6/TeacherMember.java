package Ques6;

public class TeacherMember extends Member{

    public TeacherMember(String name){
        super(name);
    }

    @Override
    public int borrowLimit(){
        return 10;
    }


}
