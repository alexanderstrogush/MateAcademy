package service;

import dao.UserDao;
import model.Code;
import model.User;
import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import java.util.Properties;

public class MailService {

    private static final Logger logger = Logger.getLogger(MailService.class);
    private static final UserDao USER_DAO = new UserDao();

    public static void sendMail(Code code) {
        final String username = "matesttest22@gmail.com";
        final String password = "Test12345-";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            User user = USER_DAO.getUserByUserID((code.getUserId())).get();

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("matesttest22@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail())
            );
            message.setSubject("Code for order confirm");
            message.setText(code.getValue());

            Transport.send(message);

            logger.debug("Message with code " + code.getValue() + " sent to " + user.getEmail());

        } catch (MessagingException e) {
            logger.error("Sending message error", e);
        }
    }
}
