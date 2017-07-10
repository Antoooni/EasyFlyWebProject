package by.htp.easyfly.service;

import by.htp.easyfly.bin.Passenger;
import by.htp.easyfly.exception.ServiceException;

public interface CreatePassengerService {
	public int passenger(Passenger passenger) throws ServiceException;

}
