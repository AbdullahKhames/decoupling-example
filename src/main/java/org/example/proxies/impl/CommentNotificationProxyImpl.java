package org.example.proxies.impl;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.example.config.MailtrapConfiguration;
import org.example.models.Notification;
import org.example.proxies.CommentNotificationProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mailCommentNotificationProxy")
@Primary
public class CommentNotificationProxyImpl implements CommentNotificationProxy {
    @Override
    public void sendNotification(Notification notification) {
        Session session = MailtrapConfiguration.getSession();
        session.setDebug(true);
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("5miiss96@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("abdullahKhames96@gmail.com"));
            message.setSubject("Mail Subject");


            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(notification.toString(), "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
