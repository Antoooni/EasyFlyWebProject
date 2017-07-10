package by.htp.easyfly.service;

/**
 * Created by Ayumazec on 06.07.2017.
 */
public interface SendEmailService {
   public void send (String subject, String text, String fromEmail, String toEmail);
}
