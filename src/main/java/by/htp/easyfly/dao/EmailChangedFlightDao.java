package by.htp.easyfly.dao;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.DAOException;

import java.util.List;

/**
 * Created by Ayumazec on 07.07.2017.
 */
public interface EmailChangedFlightDao {
    List<User> emailData (Flight flight) throws DAOException;
}
