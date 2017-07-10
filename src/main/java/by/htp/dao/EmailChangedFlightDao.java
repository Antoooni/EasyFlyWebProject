package by.htp.dao;

import by.htp.bin.Flight;
import by.htp.bin.User;
import by.htp.exception.DAOException;

import java.util.List;

/**
 * Created by Ayumazec on 07.07.2017.
 */
public interface EmailChangedFlightDao {
    List<User> emailData (Flight flight) throws DAOException;
}
