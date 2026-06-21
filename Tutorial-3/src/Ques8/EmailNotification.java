package Ques8;

public class EmailNotification implements Notification{

    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending EMAIL to " + recipient);
        System.out.println("Message: " + message);
    }
    @Override
    public void notificationType(){
        System.out.println("It's a email notification ....");
    }
}
