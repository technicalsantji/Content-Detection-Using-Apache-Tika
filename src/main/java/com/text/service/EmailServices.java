package com.text.service;

import java.io.File;
import java.net.Authenticator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {
	
//	String message = "Hello , Dear, this is message for security check . ";
//	String subject = "CodersArea : Confirmation";
//	String to = "learncodewithdurgesh@gmail.com";
	
	
//	sendEmail(message,subject,to,from);


//this is responsible to send the message with attachment
 public void sendAttach(String message, String subject, String to) {

	String from = "santkumar11032000@gmail.com";
	//Variable for gmail
	String host="smtp.gmail.com";
	
	//get the system properties
	Properties properties = System.getProperties();
	System.out.println("PROPERTIES "+properties);
	
	//setting important information to properties object
	
	//host set
	properties.put("mail.smtp.host", host);
	properties.put("mail.smtp.port","465");
	properties.put("mail.smtp.ssl.enable","true");
	properties.put("mail.smtp.auth","true");
	Session  session=Session.getInstance(properties,new javax.mail.Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			// TODO Auto-generated method stub
			return new PasswordAuthentication("santkumar11032000@gmail.com","ncltnldeezzbpcpn");
		}
		
	});
	
	session.setDebug(true);
	
	//Step 2 : compose the message [text,multi media]
	MimeMessage m = new MimeMessage(session);
	
	try {
	
	//from email
	m.setFrom(from);
	
	//adding recipient to message
	m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	
	//adding subject to message
	m.setSubject(subject);

	m.setContent(message,"text/html");
	
	//attachement..
	
	//file path
//	String path="/home/sant/Documents/SpringBootApp/Mca/ImgUploads";
//	
//	
//	MimeMultipart mimeMultipart = new MimeMultipart();
//	//text
//	//file
//	
//	MimeBodyPart textMime = new MimeBodyPart();
//	
//	MimeBodyPart fileMime = new MimeBodyPart();
//	
//	try {
//		
//		textMime.setText(message);
//		
//		File file=new File(path);
//		fileMime.attachFile(file);
//		
//		
//		mimeMultipart.addBodyPart(textMime);
//		mimeMultipart.addBodyPart(fileMime);
//	
//		
//	} catch (Exception e) {
//		
//		e.printStackTrace();
//	}
//	
//	
//	m.setContent(mimeMultipart);
//	
	
	//send 
	
	//Step 3 : send the message using Transport class
	Transport.send(m);
	System.out.println("Sent success...................");
	
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
	
	

	
	
	
}

}
