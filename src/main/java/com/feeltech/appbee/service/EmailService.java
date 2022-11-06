package com.feeltech.appbee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;



public class EmailService {


    String username = "edf59baf6768da";
    String password = "d1c85d14649342";



    private final Properties prop;

    public EmailService() {
        prop = new Properties();

           String host = "smtp.mailtrap.io";
           Integer port = 2525;

        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.ssl.trust", host);

    }





    public void signUpEmail(String token, String email, String nome) throws Exception {

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("admin@appbee.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("Finalize seu cadastro");

        String msgStyled = "<h4> Bem vindo! </h4>" + nome + " <p> Esse é o seu token para validar o cadastro:  <p> "  + token + " </p> </p>";
        MimeBodyPart mimeBodyPartWithStyledText = new MimeBodyPart();
        mimeBodyPartWithStyledText.setContent(msgStyled, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPartWithStyledText);

        message.setContent(multipart);

        Transport.send(message);
    }

    public void welcomeEmail(String token, String email, String nome) throws Exception {

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("admin@appbee.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("Bem Vindo ao AppBee");

        String msgStyled = "<h4> Parabéns, você conclui seu cadastro! </h4>" + nome + " <p> Esse é o seu token de autenticação:  <p> "  + token + " </p> </p>";
        MimeBodyPart mimeBodyPartWithStyledText = new MimeBodyPart();
        mimeBodyPartWithStyledText.setContent(msgStyled, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPartWithStyledText);

        message.setContent(multipart);

        Transport.send(message);
    }

    public void forgotPassEmail(String token, String email, String nome) throws Exception {

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("admin@appbee.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("Criar nova senha");

        String msgStyled = "<h4> Cadastrar nova senha </h4>" + nome + " <p> Esse é o seu token para o cadastro de nova senha:  <p> "  + token + " </p> " +
                "<p> Se você não solicitou alteração de senha desconsidere essa mensagem</p> </p>";
        MimeBodyPart mimeBodyPartWithStyledText = new MimeBodyPart();
        mimeBodyPartWithStyledText.setContent(msgStyled, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPartWithStyledText);

        message.setContent(multipart);

        Transport.send(message);
    }




}
