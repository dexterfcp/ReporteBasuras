package com.fcp.reportebasuras.utils;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.MimeType;
import javax.activation.MimeTypeParameterList;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class MailJob extends AsyncTask<MailJob.Mail,Void,Void> {
    private final String user;
    private final String pass;

    public MailJob(String user, String pass) {
        super();
        this.user=user;
        this.pass=pass;
    }

    @Override
    protected Void doInBackground(Mail... mails) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pass);
                    }
                });
        for (Mail mail:mails) {

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(mail.from));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(mail.to));
                message.setSubject(mail.subject);

                Multipart _multipart = new MimeMultipart();
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText(mail.content);
                _multipart.addBodyPart(messageBodyPart);

                DataSource data = new ByteArrayDataSource(mail.bmp, "image/jpeg");
                BodyPart messageBodyPart2 = new MimeBodyPart();
                messageBodyPart2.setDataHandler(new DataHandler(data));
                messageBodyPart2.setFileName("imagenAdjunta.jpg");
                _multipart.addBodyPart(messageBodyPart2);
                message.setContent(_multipart);

                Transport.send(message);

            } catch (MessagingException e) {
                Log.d("MailJob", e.getMessage());
            }
        }
        return null;
    }

    public static class Mail{
        private final String subject;
        private final String content;
        private final String from;
        private final String to;
        private final byte[] bmp;

        public Mail(String from, String to, String subject, String content, byte[] bmp){
            this.subject=subject;
            this.content=content;
            this.from=from;
            this.to=to;
            this.bmp = bmp;
        }
    }
}
