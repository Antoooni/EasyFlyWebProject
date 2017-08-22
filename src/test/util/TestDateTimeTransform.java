package util;

import by.htp.easyfly.util.DateTimeTransform;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Anton Mazets
 * This class serves for testing self-titled util class DateTimeTransform
 * Class uses JUnit- a simple framework to write repeatable tests.
 * @see DateTimeTransform
 * @see org.junit.runner.JUnitCore
 * @since 1.0
 */
public class TestDateTimeTransform {
    /**
     *Tests the method which the date relating to the future is passed as a parameter
     */
    @Test
    public void checkDateNotInPastTest(){
        /**
         *{@value #dateInFuture}  is a date relating to the future with which is compared the current date
         */
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        String dateInFuture = "31-12-2018 23:59:59";
        try {
            date = sdf.parse(dateInFuture);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**
         * Returns <tt>true</tt> if date greater than current date.
         */
        boolean result = DateTimeTransform.checkDateNotInPast(date);
        Assert.assertTrue(result);
    }

    /**
     *Tests the method which calculate duration between two dates
     */
    @Test
    public void durationTest(){
        /**
         *{@value #arrayHourMinExpected}  Expected result array which contains duration in hour and minutes
         */
        int []arrayHourMinExpected = new int[2];
        arrayHourMinExpected[0]=3;//hours
        arrayHourMinExpected[1]=10;//minutes
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

        int []arrayHourMin = DateTimeTransform.duration( departureDate,  departureTime,  arrivalDate,  arrivalTime);
        Assert.assertArrayEquals(arrayHourMinExpected, arrayHourMin);
    }

    /**
     *Tests the method which format data time
     */
    @Test
    public void convertTimeHHMMTest(){
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            d = sdf.parse("1970-01-01 10:30:00.000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Time expectedTime= null;
        if (d != null) {
            expectedTime = new Time(d.getTime());
        }
        Time presetTime = DateTimeTransform.convertTimeHHMM("10:30");
        Assert.assertEquals(expectedTime,presetTime );
    }
}
