package Demo;

import java.io.File;
import java.util.Properties;
//import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {

	public static void main(String[] args) {
		final String senderEmail="sangeetha6mugam11@gmail.com";
		final String appPassword="ffdclboudplyndhq";
		final String recipientEmail="sangeetha6mugam11@gmail.com";
		
		//SMTP properties
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(prop,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail,appPassword);
				
			}
		});
		
		session.setDebug(true);
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject("Test Email From QA Automation");
			//message.setText("Hello \n This is a test email from java \n ");
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello \\n This is a test email from java \n Regards,\nQA Team");
			MimeBodyPart attachmentPart = new MimeBodyPart();
			String filePath = System.getProperty("user.dir")+"/reports/ExtentReport.html";
			System.out.println("Attachment path is -" + filePath);
			attachmentPart.attachFile(new File(filePath));
			
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);
			
			//send Email
			Transport.send(message);
			
			System.out.println("Emai send successfully");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		}
}


