package by.htp.service;

import by.htp.bin.Flight;
import by.htp.exception.ServiceException;

public interface ChangeFlightService {
	public void cancelFlight(Flight flight) throws ServiceException;
	public void chancheFlightData(Flight flight) throws ServiceException;
}
