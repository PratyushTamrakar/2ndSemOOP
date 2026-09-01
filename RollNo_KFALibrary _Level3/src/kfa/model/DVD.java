package kfa.model;

public class DVD extends LibraryItem {

    private final int durationMinutes;
    public int lendingdays=5;

    public DVD(String title, String isbn, double price, int durationMinutes){
        super(title,isbn,price);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public int getLendingPeriodDays(){
        return 5;
    }
    public void renew(int extraDays){
        lendingdays+= extraDays;
    };

    public String toString(){
        return String.format("[%s] %s-%.2f[%b] \nDuration[Min] : %d",isbn,title,price,available,durationMinutes);
    }
}
