package by.htp.easyfly.service.impl;

import by.htp.easyfly.bin.Ticket;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.UserCreateDao;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.Impl.UserCreateServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author Anton Mazets
 * This class serves for testing self-titled service implementation class UserCreateServiceImpl
 * Class uses Mockito- framework, JAVA-based library that is used for effective unit testing of JAVA applications.
 * All unit tests should test functionality in isolation.
 * @see by.htp.easyfly.service.Impl.UserCreateServiceImpl
 * @see org.mockito.Mockito
 * @since 1.0
 */
public class UserCreateServiceImplTest {
    private UserCreateDao daoCreateUser;
    private UserCreateServiceImpl service;


    @Before
    public void setUp() throws DAOException {
        daoCreateUser = mock(UserCreateDao.class);
        service = new UserCreateServiceImpl(daoCreateUser);
    }
    /**
     *Tests the method createNewUser of create new user which passed as a parameter
     */
    @Test
    public void createNewUserTest() throws ServiceException, DAOException {
        Ticket ticket = new Ticket(1,1, true, false,100.0);
        User user = new User(3, "Boris", "Blade", "boris@blade.by", ticket);
        when(daoCreateUser.createUser(any(User.class))).thenReturn(user);
        service.createNewUser(user);
        verify(daoCreateUser,times(1)).createUser(user);
    }
    /**
     *Tests exception in method createNewUser if user can not be created
     */
    @Test(expected = ServiceException.class)
    public void createNewUserTestException() throws ServiceException, DAOException {
        Ticket ticket = new Ticket(1,1, true, false,100.0);
        User user = new User(3, "InvalidUser", "Blade", "boris@blade.by", ticket);
        when(daoCreateUser.createUser(user)).thenThrow(new DAOException(""));
        service.createNewUser(user);
        verify(daoCreateUser,times(1)).createUser(user);
    }
    /**
     *Tests the method checkUserExist during create new user
     */
    @Test
    public void checkUserExistTest() throws ServiceException, DAOException {
        String login="qwerty";
        service.checkUserExist(login);
        verify(daoCreateUser,times(1)).checkExistUser(login);
    }
    /**
     *Tests exception in method checkUserExist if user already exists
     */
    @Test(expected = ServiceException.class)
    public void checkUserExistTestException() throws ServiceException, DAOException{
        String login="qwerty";
        when(daoCreateUser.checkExistUser(login)).thenThrow(new DAOException(""));
        service.checkUserExist(login);
        verify(daoCreateUser,times(1)).checkExistUser(login);
    }
    /**
     *Tests the method checkUserEmailExist during create new user
     */
    @Test
    public void checkUserEmailExistTest() throws ServiceException, DAOException {
        String email="test@test.by";
        service.checkUserEmailExist(email);
        verify(daoCreateUser,times(1)).checkExistUserEmail(email);
    }
    /**
     *Tests exception in method checkUserEmailExist if email already exists
     */
    @Test(expected = ServiceException.class)
    public void checkUserEmailExistTestException() throws DAOException, ServiceException {
        String email="test@test.by";
        when(daoCreateUser.checkExistUserEmail(email)).thenThrow(new DAOException(""));
        service.checkUserEmailExist(email);
        verify(daoCreateUser,times(1)).checkExistUserEmail(email);
    }
}
