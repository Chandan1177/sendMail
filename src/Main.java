import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import  java.util.Properties;
public class Main {
    static String receiver ="anishsingh.r87@gmail.com",sender="rajputkiran534@gmail.com",subject="try mail via java",body="" +
            "hey anish how are your,";
    static boolean send(String to,String from,String sub,String body){
        boolean flag=false;
        Properties prop=new Properties();
        prop.put("mail.smtp.port","587");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");

        String uname="rajputkiran534";
        String pass="tfrglzpmswniosxb";

        Session session=Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(uname,pass);
            }
        });
        try {
            Message msg=new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setSubject(sub);
            msg.setText(body);
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));

            Transport.send(msg);
            flag=true;
        }catch (Exception e){
            System.out.println(e);
        }

        return flag;
    }
    public static void main(String[] args) {
        boolean status= send(receiver,sender,subject,body);
        System.out.println(status);
    }
}