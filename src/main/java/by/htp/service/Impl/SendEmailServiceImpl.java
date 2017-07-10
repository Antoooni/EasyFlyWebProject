package by.htp.service.Impl;

import by.htp.dao.EmailDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.service.SendEmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Ayumazec on 06.07.2017.
 */
public class SendEmailServiceImpl implements SendEmailService {

    private String username;
    private String password;
    private Properties props;
    private EmailDao emailDao;

    public SendEmailServiceImpl(){
        emailDao = DaoFactory.getInstance().getEmailDao();
    }

    public SendEmailServiceImpl(String username, String password) {
        this.username = username;
        this.password = password;

        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }

    @Override
    public void send(String subject, String text, String fromEmail, String toEmail) {
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            //от кого
            message.setFrom(new InternetAddress(username));
            //кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //Заголовок письма
            message.setSubject(subject);
            //Содержимое
            message.setText(text);

            //Отправляем сообщение
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
