package by.htp.easyfly.service;

import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.ServiceException;

public interface AuthorizationService {
	User userData(String login, String password) throws ServiceException;
}
