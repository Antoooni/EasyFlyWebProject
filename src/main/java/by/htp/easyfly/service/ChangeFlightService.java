package by.htp.easyfly.service;

import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.exception.ServiceException;

public interface ChangeFlightService {
	public void cancelFlight(Flight flight) throws ServiceException;
	public void chancheFlightData(Flight flight) throws ServiceException;
}
