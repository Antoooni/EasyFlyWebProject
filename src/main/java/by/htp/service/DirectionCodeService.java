package by.htp.service;

import by.htp.bin.Direction;
import by.htp.exception.ServiceException;

public interface DirectionCodeService {
	String directionCode(String direction) throws ServiceException;

}
