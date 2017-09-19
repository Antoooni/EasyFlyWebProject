package by.htp.easyfly.service.impl;

import by.htp.easyfly.bin.Direction;
import by.htp.easyfly.bin.Flight;
import by.htp.easyfly.dao.EmailChangedFlightDao;
import by.htp.easyfly.exception.DAOException;
import by.htp.easyfly.exception.ServiceException;
import by.htp.easyfly.service.Impl.EmailServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.*;

/**
 * @author Anton Mazets
 * This class serves for testing self-titled service implementation class SendEmailService
 * Class uses Mockito- framework, JAVA-based library that is used for effective unit testing of JAVA applications.
 * All unit tests should test functionality in isolation.
 * @see by.htp.easyfly.service.Impl.EmailServiceImpl
 * @see org.mockito.Mockito
 * @since 1.0
 */
public class SendEmailServiceTest {
    private EmailChangedFlightDao emailChangedFlightDao;
    private EmailServiceImpl service;

    Flight flight;
    Direction directionDepart;
    Direction directionArrival;

    @Before
    public void setUp(){
        emailChangedFlightDao=mock(EmailChangedFlightDao.class);
        service=new EmailServiceImpl(emailChangedFlightDao);

        directionDepart=new Direction("MOW","Domodedowo", "Russia","Moscow");
        directionArrival=new Direction("MSQ","Minsk 2", "Belarus","Minsk");
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            date = sdf.parse("1970-01-01 10:30:00.000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Time expectedTime= null;
        if (date != null) {
            expectedTime = new Time(date.getTime());
        }
        flight= new Flight(directionDepart, directionDepart, date,expectedTime,
                directionDepart, date,expectedTime, 1, "MOW");
    }
    @Test
    public void sendEmailTest() throws IOException, ServiceException, DAOException {
        service.sendEmail(flight, "Email sent");
        verify(emailChangedFlightDao,times(1)).selectUserChangedFlight(flight);
    }
    @Test(expected = ServiceException.class)
    public void sendEmailTestException() throws DAOException, IOException, ServiceException {
        when(emailChangedFlightDao.selectUserChangedFlight(flight)).thenThrow(new DAOException(""));
        service.sendEmail(flight,"Email sent");
        verify(emailChangedFlightDao,times(1)).selectUserChangedFlight(flight);
    }
}
