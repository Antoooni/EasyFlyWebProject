package by.htp.service;

import by.htp.bin.Flight;
import by.htp.exception.ServiceException;

public interface SelectedFlightService {
	Flight flight(int flightId) throws ServiceException;

}
