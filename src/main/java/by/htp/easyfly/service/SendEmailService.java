package by.htp.easyfly.service;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;

import java.util.List;

/**
 * Created by Ayumazec on 06.07.2017.
 */
public interface SendEmailService {
//   public List<User> searchUserChangedFlight();
   public void sendEmail(Flight flight, String emailText) throws ServiceException;
}
