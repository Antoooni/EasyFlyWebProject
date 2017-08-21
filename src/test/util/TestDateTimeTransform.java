package util;

import by.htp.easyfly.util.DateTimeTransform;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Test
    public void checkDateNotInPastTest(){
        /**
         *Tests the method to which the date relating to the future is passed as a parameter
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
}
