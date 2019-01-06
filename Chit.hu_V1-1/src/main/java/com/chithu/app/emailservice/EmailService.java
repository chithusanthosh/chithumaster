package com.chithu.app.emailservice;

import java.sql.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	    @Autowired
	    public JavaMailSender emailSender;
	 
	public void sendSimpleMessage(
		      String to, String subject, String text) {
		Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("santhosh.esk@gmail.com", "Ayivak_123");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   try {
			msg.setFrom(new InternetAddress("santhosh.esk@gmail.com", false));
			 msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("santhosh.esk@gmail.com"));
			   msg.setSubject("Tutorials point email");
			   msg.setContent("Tutorials point email", "text/html");
			   Transport.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  
		   
		          
		    }
}
