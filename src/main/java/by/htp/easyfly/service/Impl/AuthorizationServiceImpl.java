package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.UserAuthorizationDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.AuthorizationService;

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
