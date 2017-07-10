package by.htp.easyfly.service;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;

public interface SelectedFlightService {
	Flight flight(int flightId) throws ServiceException;

}
