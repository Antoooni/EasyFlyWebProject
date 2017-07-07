package by.htp.service;

import by.htp.bin.User;
import by.htp.exception.ServiceException;

public interface AuthorizationService {
	User userData(String login, String password) throws ServiceException;
}
