package by.htp.service;

import java.util.List;

import by.htp.bin.FlightDirection;
import by.htp.exception.ServiceException;

public interface DirectionService {
	List <FlightDirection> listDirections() throws ServiceException;

}
