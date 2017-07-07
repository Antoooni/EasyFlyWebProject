package by.htp.service;

import by.htp.bin.User;
import by.htp.exception.ServiceException;

public interface UserCreateService {
	public boolean checkUserExist(String login) throws ServiceException;

	public boolean checkUserEmailExist(String email) throws ServiceException;

	public User createNewUser(User user) throws ServiceException;

}
