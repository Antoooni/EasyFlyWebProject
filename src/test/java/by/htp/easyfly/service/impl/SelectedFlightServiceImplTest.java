package by.htp.easyfly.service.impl;

import by.htp.easyfly.dao.SelectedFlightDao;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.Impl.SelectedFlightServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author Anton Mazets
 * This class serves for testing self-titled service implementation class SelectedFlightServiceImpl
 * Class uses Mockito- framework, JAVA-based library that is used for effective unit testing of JAVA applications.
 * All unit tests should test functionality in isolation.
 * @see by.htp.easyfly.service.Impl.SelectedFlightServiceImpl
 * @see org.mockito.Mockito
 * @since 1.0
 */
public class SelectedFlightServiceImplTest {
    private SelectedFlightDao selectedFlightDao;
    private SelectedFlightServiceImpl service;

    @Before
    public void setUp() throws DAOException{
        selectedFlightDao=mock(SelectedFlightDao.class);
        service=new SelectedFlightServiceImpl(selectedFlightDao);
    }
    @Test
    public void flight() throws ServiceException, DAOException{
        int flightId=1;
        service.flight(flightId);
        verify(selectedFlightDao,times(1)).flight(flightId);
    }
    @Test(expected = ServiceException.class)
    public void flightException() throws ServiceException, DAOException{
        int flightId=1;
        when(selectedFlightDao.flight(flightId)).thenThrow(new DAOException(""));
        service.flight(flightId);
        verify(selectedFlightDao,times(1)).flight(flightId);
    }


}
