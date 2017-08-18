package by.htp.easyfly.service;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;

import java.io.IOException;

/**
 * Created by Ayumazec on 06.07.2017.
 */
public interface SendEmailService {
   public void sendEmail(Flight flight, String emailText) throws ServiceException, IOException;
}
