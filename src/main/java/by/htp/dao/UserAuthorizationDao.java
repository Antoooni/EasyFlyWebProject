package by.htp.dao;

import by.htp.bin.User;
import by.htp.exception.DAOException;

public interface UserAuthorizationDao {
	User getUserData(String login, String password) throws DAOException;
}
