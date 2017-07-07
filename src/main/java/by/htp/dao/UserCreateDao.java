package by.htp.dao;

import by.htp.bin.User;
import by.htp.exception.DAOException;

public interface UserCreateDao {
	User createUser(User user) throws DAOException;

	boolean checkExistUser(String login) throws DAOException;

	boolean checkExistUserEmail(String email) throws DAOException;
}
