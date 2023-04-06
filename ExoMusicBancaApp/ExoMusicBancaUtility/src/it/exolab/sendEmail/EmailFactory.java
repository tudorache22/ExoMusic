package it.exolab.sendEmail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import it.exoBanca.models.Otp;
import it.exoBanca.models.Utente;
import it.exolab.costanti.StringheEmail;

public class EmailFactory {

	private Properties properties = System.getProperties();
	private Session session;
	private MimeMessage message;

	public EmailFactory() {
		setaggioSession();
		setaggioPropieties();
	}

	public void setaggioPropieties() {
		properties.put("mail.smtp.host", StringheEmail.HOST);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
	}

	public void setaggioSession() {
		session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(StringheEmail.MITTENTE, StringheEmail.KEY);
			}
		});
	}

	public void settaggioMessageStandard(Utente utente, Otp otp) throws AddressException, MessagingException {
		message = new MimeMessage(session);
		message.setFrom(new InternetAddress(StringheEmail.MITTENTE));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(StringheEmail.DESTINATARIO));
		message.setSubject(StringheEmail.SUBJECT_OTP);
		message.setText(StringheEmail.getText(utente, otp));
	}

	public void settaggioMessageFile(Utente utente) throws IOException, MessagingException {

		message = new MimeMessage(session);
		MimeMultipart multipart = new MimeMultipart();
		MimeBodyPart attachmentPart = new MimeBodyPart();
		MimeBodyPart textPart = new MimeBodyPart();

		File file = new File(StringheEmail.PDF_LOCAZIONE);

		attachmentPart.attachFile(file);
		textPart.setText(StringheEmail.getText(utente));
		multipart.addBodyPart(textPart);
		multipart.addBodyPart(attachmentPart);

		message.setContent(multipart);
		message.setSubject(StringheEmail.SUBJECT);
		message.setFrom(new InternetAddress(StringheEmail.MITTENTE));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(StringheEmail.DESTINATARIO));
	}

	public void invioEmailStandard(Utente utente, Otp otp) {
		try {
			settaggioMessageStandard(utente, otp);
			Transport.send(message);
			System.out.println("email inviata");

		} catch (MessagingException e) {
			System.out.println("email non inviata");
			e.printStackTrace();
		}
	}

	public void invioEmailFile(Utente utente) {
		try {
			settaggioMessageFile(utente);
			Transport.send(message);
			System.out.println("email inviata");

		} catch (MessagingException | IOException e) {
			System.out.println("email non inviata");
			e.printStackTrace();
		}
	}

}