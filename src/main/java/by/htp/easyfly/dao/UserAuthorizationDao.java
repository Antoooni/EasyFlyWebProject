package by.htp.easyfly.dao;

import by.htp.easyfly.bin.User;
import by.htp.easyfly.exception.DAOException;

public interface UserAuthorizationDao {
	User getUserData(String login, String password) throws DAOException;
}
