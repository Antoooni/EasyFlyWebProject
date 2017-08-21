import by.htp.easyfly.util.DateTimeTransform;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ayumazec on 21.08.2017.
 */
public class TestDateTimeTransform {

    @Test
    public void checkDateNotInPastTest(){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInFuture = "31-12-2018 23:59:59";
        try {
            date = sdf.parse(dateInFuture);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean result = DateTimeTransform.checkDateNotInPast(date);
        Assert.assertTrue(result);
    }
}
