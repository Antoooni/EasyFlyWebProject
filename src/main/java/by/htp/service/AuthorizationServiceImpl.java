package by.htp.service;

import by.htp.bin.User;
import by.htp.dao.UserAuthorizationDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.exception.DAOException;
import by.htp.exception.ServiceException;

public class AuthorizationServiceImpl implements AuthorizationService {
	private UserAuthorizationDao daoNme;
	// DaoFactory daoFactory = new DaoFactory();

	public AuthorizationServiceImpl() {
		daoNme = DaoFactory.getInstance().getUserAuthorizationDao();

	}

	@Override
	public User userData(String login, String password) throws ServiceException {
		try {
			return daoNme.getUserData(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
