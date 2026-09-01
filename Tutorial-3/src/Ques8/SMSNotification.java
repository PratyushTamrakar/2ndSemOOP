package Ques8;

public class SMSNotification implements Notification{

    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending SMS to " + recipient);
        System.out.println("Message: " + message);
    }
    @Override
    public void notificationType(){
        System.out.println("It's a SMS notification ....");
    }
}
