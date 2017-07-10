package by.htp.easyfly.service;

import by.htp.easyfly.exception.ServiceException;

public interface DirectionCodeService {
	String directionCode(String direction) throws ServiceException;

}
