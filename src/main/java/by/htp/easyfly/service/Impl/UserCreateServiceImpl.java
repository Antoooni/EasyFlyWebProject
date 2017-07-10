package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.UserCreateDao;
import by.htp.easyfly.dao.factory.DaoFactory;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.UserCreateService;

public class UserCreateServiceImpl implements UserCreateService {
	private UserCreateDao daoCreateUser;
	// DaoFactory daoFactory = new DaoFactory() ;

	public UserCreateServiceImpl() {
		daoCreateUser = DaoFactory.getInstance().getUserCreateDao();
	}

	@Override
	public User createNewUser(User user) throws ServiceException {
		try {
			User newUser = daoCreateUser.createUser(user);
			newUser.setUserName(user.getUserName());
			newUser.setUserSurname(user.getUserSurname());
			newUser.setUserEmail(user.getUserEmail());
			newUser.setTicket(null);
			return newUser;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean checkUserExist(String login) throws ServiceException {
		try {
			return daoCreateUser.checkExistUser(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean checkUserEmailExist(String email) throws ServiceException {
		try {
			return daoCreateUser.checkExistUserEmail(email);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
