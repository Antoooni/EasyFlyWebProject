package by.htp.easyfly.service;

import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.ServiceException;

public interface UserCreateService {
	public boolean checkUserExist(String login) throws ServiceException;

	public boolean checkUserEmailExist(String email) throws ServiceException;

	public User createNewUser(User user) throws ServiceException;

}
