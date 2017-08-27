package by.htp.easyfly.service.impl;

import by.htp.easyfly.bin.Ticket;
import by.htp.easyfly.bin.User;
import by.htp.easyfly.dao.SearchChangedFlightDao;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.Impl.SearchChangedFlightServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author Anton Mazets
 * This class serves for testing self-titled service implementation class SearchChangedFlightServiceImpl
 * Class uses Mockito- framework, JAVA-based library that is used for effective unit testing of JAVA applications.
 * All unit tests should test functionality in isolation.
 * @see by.htp.easyfly.service.SearchChangedFlightService
 * @see org.mockito.Mockito
 * @since 1.0
 */
public class SearchChangedFlightServiceImplTest {
    private SearchChangedFlightDao searchChangedFlightDao;
    private SearchChangedFlightServiceImpl service;
    private User user;

    @Before
    public void setUp(){
        searchChangedFlightDao=mock(SearchChangedFlightDao.class);
        service=new SearchChangedFlightServiceImpl(searchChangedFlightDao);

        Ticket ticket = new Ticket(1, 1, true, false, 100.0);
        user = new User(3, "Boris", "Blade", "boris@blade.by", ticket);
    }
    @Test
    public void searchChangedFlightTest() throws ServiceException, DAOException {

        service.searchChangedFlight(user);
        verify(searchChangedFlightDao, times(1)).searchChangedFlight(user);
    }
    @Test(expected = ServiceException.class)
    public void searchChangedFlightExceptionTest() throws ServiceException, DAOException {

        when(searchChangedFlightDao.searchChangedFlight(user)).thenThrow(new DAOException(""));
        service.searchChangedFlight(user);
        verify(searchChangedFlightDao,times(1)).searchChangedFlight(user);
    }
    @Test
    public void searchCancelledFlightTest() throws ServiceException, DAOException {

        service.searchCancelledFlight(user);
        verify(searchChangedFlightDao, times(1)).searchCancelledFlight(user);
    }
    @Test(expected = ServiceException.class)
    public void searchCancelledFlightTestException() throws DAOException, ServiceException {
        when(searchChangedFlightDao.searchCancelledFlight(user)).thenThrow(new DAOException(""));
        service.searchCancelledFlight(user);
        verify(searchChangedFlightDao,times(1)).searchCancelledFlight(user);
    }
}
