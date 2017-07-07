package by.htp.service;

import by.htp.bin.Passenger;
import by.htp.bin.Ticket;
import by.htp.exception.ServiceException;

public interface CreatePassengerService {
	public int passenger(Passenger passenger) throws ServiceException;

}
