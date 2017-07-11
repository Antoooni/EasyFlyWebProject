package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.EmailChangedFlightDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.SendEmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * Created by Ayumazec on 06.07.2017.
 */
public class EmailServiceImpl implements SendEmailService {

    private String username;
    private String password;
    private Properties props;
    private EmailChangedFlightDao emailChangedFlight;

    public EmailServiceImpl(){
        emailChangedFlight = DaoFactory.getInstance().getEmailChangedFlightDao();
    }

    public EmailServiceImpl(String username, String password) {
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
    public void sendEmail(Flight flight, String emailText) throws ServiceException {
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        String headerMessage = "This is Subject";
//        String textMessage = "TLS: This is text!";
//        String emailFrom = "easyfly.info@gmail.com";
//        String emailTo = "mazets_anton@tut.by";

        List<User> listUser= null;
        try {
            listUser = emailChangedFlight.selectUserChangedFlight(flight);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        if(null != listUser) {
            for (User aListUser : listUser) {
                if (aListUser.getUserEmail() != null) {
                    try {
                        Message message = new MimeMessage(session);
                        //от кого
                        message.setFrom(new InternetAddress(username));
                        //кому
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(aListUser.getUserEmail()));
                        //Заголовок письма
                        message.setSubject(headerMessage);
                        //Содержимое
                        message.setText(emailText);

                        //Отправляем сообщение
                        Transport.send(message);
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
