package by.htp.easyfly.service;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.ServiceException;

/**
 * Created by Ayumazec on 20.07.2017.
 */
public interface SearchChangedFlightService {
    Flight searchChangedFlight(User user) throws ServiceException;
    Flight searchCancelledFlight(User user) throws ServiceException;
}
