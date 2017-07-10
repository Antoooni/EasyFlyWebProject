package by.htp.easyfly.service;

import java.util.List;

import by.htp.easyfly.bin.FlightDirection;
import by.htp.easyfly.exception.ServiceException;

public interface DirectionService {
	List <FlightDirection> listDirections() throws ServiceException;

}
