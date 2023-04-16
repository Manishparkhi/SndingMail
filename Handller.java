package org.example;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Handller {

    void sendAttachment() {
        // gmail host : smtp

        String host = "smtp.gmail.com";

        Properties props = System.getProperties();
        System.out.println(props);

        // set properties

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");

        //session
        Session mailSession = Session.getInstance(props, new MailAuthenticator());

        //message object

        MimeMessage mimeMessage = new MimeMessage(mailSession);

        try {
            //sender
            mimeMessage.setFrom(CommonUse.SENDER);

            //receiver
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(CommonUse.RECEIVEREMAIL));

            //subject
            mimeMessage.setSubject(CommonUse.SUBJECT);

            //message
            mimeMessage.setText(CommonUse.MESSAGE);

            Transport.send(mimeMessage);


        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
