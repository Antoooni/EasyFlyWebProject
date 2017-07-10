package by.htp.easyfly.dao;

import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.DAOException;

public interface UserCreateDao {
	User createUser(User user) throws DAOException;

	boolean checkExistUser(String login) throws DAOException;

	boolean checkExistUserEmail(String email) throws DAOException;
}
