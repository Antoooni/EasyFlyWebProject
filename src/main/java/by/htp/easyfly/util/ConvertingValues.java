package by.htp.easyfly.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ayumazec on 16.07.2017.
 */
public class ConvertingValues {
    public ConvertingValues(){
    }
    public static Date convertDate(String inputStringDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date outputDate = null;
        try {
            outputDate = sdf.parse(inputStringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputDate;
    }
    public static Time convertTime(String inputStringTime){
        Time outputTime=null;
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        try {
            Date date = formatter.parse(inputStringTime);
            outputTime = new Time(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputTime;
    }
}
