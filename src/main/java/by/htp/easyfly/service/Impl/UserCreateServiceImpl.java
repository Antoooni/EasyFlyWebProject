package by.htp.easyfly.service.Impl;

import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.UserCreateDao;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.UserCreateService;

/**
 * @author Anton Mazets
 * Class is implementation of interface that is a service for creating a new user
 * @see by.htp.easyfly.service.UserCreateService
 * @since 1.0
 */
public class UserCreateServiceImpl implements UserCreateService {
	private final UserCreateDao daoCreateUser;

    public UserCreateServiceImpl(UserCreateDao daoCreateUser) {
        this.daoCreateUser = daoCreateUser;
    }

    /**
     * @return created new user
     * @throws ServiceException
     */
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

    /**
     * @param login user's login
     * @return true if user is already exists or false for new user
     * @throws ServiceException
     */
	@Override
	public boolean checkUserExist(String login) throws ServiceException {
		try {
			return daoCreateUser.checkExistUser(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

    /**
     * @param email user's email
     * @return true if email is already exists to one of the users, false for new user
     * @throws ServiceException
     */
	@Override
	public boolean checkUserEmailExist(String email) throws ServiceException {
		try {
			return daoCreateUser.checkExistUserEmail(email);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
