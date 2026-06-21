package Ques8;

public class Ques8Main {
    public static void main(String[] args) {

        System.out.println();
        Notification email = new EmailNotification();
        email.sendNotification("Your order has been placed", "user@example.com");
        email.notificationType();
        System.out.println();

        Notification sms = new SMSNotification();
        sms.sendNotification("Your OTP is 123456", "+977-98XXXXXXXX");
        sms.notificationType();
    }
}
