package kfa.model;

public class Book extends LibraryItem implements Renewable {


    public String author;
    public static int totalBooks=0;
    public int lendingdays = 14;

    public Book(String title, String author, String isbn, double price) {
        super(title,isbn,price);
        this.author = author;

        totalBooks++;
    }

    //getters
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getIsbn(){
        return this.isbn;
    }
    public double getPrice(){
        return this.price;
    }
    public boolean getAvailable(){
        return this.available;
    }
    public static void getTotalBooks(){
        System.out.println("Total kfa.model.Book Count : "+ totalBooks);
    }

    //setters
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public void setPrice(double price){
        if(price < 0){
            System.out.println("Invalid price. Price should be greater than 0.");
        }else{
            this.price = price;
        }

    }
    public void setAvailable(boolean available){
        this.available = available;
    }

    //abstract method
    @Override
    public int getLendingPeriodDays(){
        return lendingdays;
    }
    public void renew(int extraDays){
        lendingdays+= extraDays;
    };

    public String toString(){
        return String.format("[%s] %s by %s- Rs.%.2f[%b]",isbn,title,author,price,available);
    }
}
