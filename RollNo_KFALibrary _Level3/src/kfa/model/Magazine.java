package kfa.model;

public class Magazine extends LibraryItem {

    private final int issueNumber;
    public int lendingdays=7;

    public Magazine(String title, String isbn, double price, int issueNumber){
        super(title,isbn,price);
        this.issueNumber = issueNumber;
    }

    @Override
    public int getLendingPeriodDays(){
        return lendingdays;
    }
    //magazine cannot be reneuwed because the library policy doesn't allow it


    public String toString(){
        return String.format("[%s] %s-%.2f[%b] \nIssue Number : %d",isbn,title,price,available,issueNumber);
    }
}
