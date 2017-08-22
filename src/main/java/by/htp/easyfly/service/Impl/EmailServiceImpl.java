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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

    @Override
    public void sendEmail(Flight flight, String emailText) throws ServiceException, IOException {

        Properties property = new Properties();
        Thread currentThread = Thread.currentThread();
        ClassLoader contextClassLoader = currentThread.getContextClassLoader();
        InputStream is = contextClassLoader.getResourceAsStream("mailConfig.properties");
        if (is != null) {
            property.load(is);
        } else {
            throw (new FileNotFoundException());
        }
        username=property.getProperty("sender.mail");
        password= property.getProperty("sender.pass");

        props = new Properties();
        props.put(property.getProperty("smtp.host"), property.getProperty("smtp.hostValue"));
        props.put(property.getProperty("smtp.socketFactoryPort"), property.getProperty("smtp.socketFactoryPortValue"));
        props.put(property.getProperty("smtp.socketFactoryClass"), property.getProperty("smtp.socketFactoryClassValue"));
        props.put(property.getProperty("smtp.auth"), property.getProperty("smtp.authValue"));
        props.put(property.getProperty("smtp.port"), property.getProperty("smtp.portValue"));
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

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
                        //sender
                        message.setFrom(new InternetAddress(username));
                        //recipient
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(aListUser.getUserEmail()));
                        //Header
                        message.setSubject(property.getProperty("smtp.headerMessage"));
                        //body
                        message.setText(emailText);

                        //send
                        Transport.send(message);
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}