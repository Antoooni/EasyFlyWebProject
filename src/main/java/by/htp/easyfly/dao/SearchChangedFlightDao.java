package by.htp.easyfly.dao;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.DAOException;

/**
 * Created by Ayumazec on 20.07.2017.
 */
public interface SearchChangedFlightDao {
    Flight searchChangedFlight(User user) throws DAOException;
    Flight searchCancelledFlight(User user) throws DAOException;
}
