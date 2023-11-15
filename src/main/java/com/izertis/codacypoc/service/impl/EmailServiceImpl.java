package com.izertis.codacypoc.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.izertis.codacypoc.service.EmailService;
import com.izertis.codacypoc.utils.EmailUtils;


public class EmailServiceImpl implements EmailService {
    Properties properties;
    public EmailServiceImpl() {
        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); //TLS
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

    }

    @Override
    public boolean sendEmail(String email, String subject, String body) {
        if (EmailUtils.isValid(email)) {
            // Send the email using gmail
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("username", "password");
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("from-email@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setSubject(subject);
                message.setText(body);

                Transport.send(message);
            } catch (MessagingException e) {
                return false;
            }

            return true;
        } else {
            return false;
        }
    }
}
