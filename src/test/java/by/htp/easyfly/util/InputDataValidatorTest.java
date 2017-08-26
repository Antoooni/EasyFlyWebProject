package by.htp.easyfly.util;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Anton Mazets
 * This class serves for testing self-titled util class InputDataValidator
 * Class uses JUnit- a simple framework to write repeatable tests.
 * @see by.htp.easyfly.util.InputDataValidator
 * @see org.junit.runner.JUnitCore
 * @since 1.0
 */@Ignore
public class InputDataValidatorTest {
    @Test
    public void isValidLoginTest(){
        Assert.assertTrue(InputDataValidator.isValidLogin("AnyLogin123"));
    }
    @Test
    public void isValidPasswordTest(){
        Assert.assertTrue(InputDataValidator.isValidPassword("AnyPassword123"));
    }
    @Test
    public void isValidUserTest(){
        Assert.assertTrue(InputDataValidator.isValidUser("AnyLogin123","AnyPassword123", "Anton", "Mazets","test@test.by"));
    }
    @Test
    public void isValidPassengerTest(){
        boolean b =InputDataValidator.isValidPassenger("Anton", "Mazets", 28, "HY3334455");
        Assert.assertTrue(b);
    }
    @Test
    public void isSameDestinationTest(){
        Assert.assertTrue(InputDataValidator.isSameDestination("Minsk","Minsk"));
    }
    @Test
    public void dateInPastTest(){
        Date departureDate=null;
        Date arrivalDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        try {
            departureDate = sdf.parse("30-12-2000");
            arrivalDate = sdf.parse("31-12-2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(InputDataValidator.dateInPast(departureDate,arrivalDate));
    }
    @Test
    public void isArrivalBeforeDepartureTest(){
        Date departureDate=null;
        Date arrivalDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        try {
            departureDate = sdf.parse("31-12-2018");
            arrivalDate = sdf.parse("30-12-2018");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(InputDataValidator.isArrivalBeforeDeparture(departureDate, arrivalDate));
    }
    @Test
    public void isBirthdayBeforeDepartureTest(){
        Date departureDate=null;
        Date birthDay = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        try {
            departureDate = sdf.parse("31-12-2018");
            birthDay = sdf.parse("30-12-2018");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(InputDataValidator.isBirthdayBeforeDeparture(departureDate, birthDay));
    }
    @Test
    public void isExpiryBeforeArrivalTest(){
        Date arrivalDate=null;
        Date expiry = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        try {
            arrivalDate = sdf.parse("31-12-2018");
            expiry = sdf.parse("30-12-2018");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(InputDataValidator.isExpiryBeforeArrival(arrivalDate, expiry));
    }
    @Test
    public void isValidDatesTest(){
        /**
         *{@value #departureDate}  departure date
         *{@value #arrivalDate}  arrival date
         *{@value #departureTime}  departure time
         *{@value #arrivalTime}  arrival date
         */
        Date departureDate;
        Date arrivalDate;
        Time departureTime;
        Time arrivalTime;
        //set departure date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2017);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        departureDate= cal.getTime();
        //set departure time
        Calendar time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY,10);
        time.set(Calendar.MINUTE,20);
        time.set(Calendar.SECOND,0);
        time.set(Calendar.MILLISECOND,0);
        Date departureTimeDate=time.getTime();
        departureTime=new Time(departureTimeDate.getTime());
        //set arrival date
        cal.set(Calendar.YEAR,2017);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        arrivalDate= cal.getTime();
        // set arrival time
        time.set(Calendar.HOUR_OF_DAY,13);
        time.set(Calendar.MINUTE,30);
        time.set(Calendar.SECOND,0);
        time.set(Calendar.MILLISECOND,0);
        Date arrivalTimeDate=time.getTime();
        arrivalTime=new Time(arrivalTimeDate.getTime());
        Assert.assertTrue(InputDataValidator.isValidDates(departureDate,  departureTime,  arrivalDate,  arrivalTime));
    }
    @Test
    public void isEmptyDateTest(){
        /**
         *{@value #departureDate}  departure date
         *{@value #arrivalDate}  arrival date
         *{@value #departureTime}  departure time
         *{@value #arrivalTime}  arrival date
         */
        Date departureDate;
        Date arrivalDate;
        Time departureTime;
        Time arrivalTime;
        //set departure date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2017);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        departureDate= cal.getTime();
        //set departure time
        Calendar time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY,10);
        time.set(Calendar.MINUTE,20);
        time.set(Calendar.SECOND,0);
        time.set(Calendar.MILLISECOND,0);
        Date departureTimeDate=time.getTime();
        departureTime=new Time(departureTimeDate.getTime());
        //set arrival date
        cal.set(Calendar.YEAR,2017);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        arrivalDate= cal.getTime();
        // set arrival time
        time.set(Calendar.HOUR_OF_DAY,13);
        time.set(Calendar.MINUTE,30);
        time.set(Calendar.SECOND,0);
        time.set(Calendar.MILLISECOND,0);
        Date arrivalTimeDate=time.getTime();
        arrivalTime=new Time(arrivalTimeDate.getTime());
        Assert.assertFalse(InputDataValidator.isEmptyDate(departureDate,  departureTime,  arrivalDate,  arrivalTime));
    }

}
