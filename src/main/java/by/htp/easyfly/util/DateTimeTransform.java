package by.htp.easyfly.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Ayumazec on 16.07.2017.
 */
public class DateTimeTransform {
    public DateTimeTransform(){
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
    public static Time convertTimeHHMMSS(String inputStringTime){
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
    public static Time convertTimeHHMM(String inputStringTime){
        Time outputTime=null;
        DateFormat formatter = new SimpleDateFormat("hh:mm");
        try {
            Date date = formatter.parse(inputStringTime);
            outputTime = new Time(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputTime;
    }

    public static int[] duration(Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime){
        //0-hour, 1st-minutes
        int []arrayHourMin= new int[2];
        //departure to mms
        long resultDep = departureDate.getTime()+departureTime.getTime();
        //arrival to mms
        long resultArr=arrivalDate.getTime()+arrivalTime.getTime();

        Calendar calendarDeparture = Calendar.getInstance();
        Date departure = new Date(resultDep);
        calendarDeparture.setTime(departure);

        Calendar calendarArrival = Calendar.getInstance();
        Date arrival = new Date(resultArr);
        calendarArrival.setTime(arrival);

        // delta
        long delta = calendarArrival.getTimeInMillis()-calendarDeparture.getTimeInMillis();
        Calendar difference = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        difference.setTimeInMillis(delta);

        arrayHourMin[0]=difference.get(Calendar.HOUR);
        arrayHourMin[1]=difference.get(Calendar.MINUTE);
        return arrayHourMin;
    }
}
