package by.htp.easyfly.util;

import java.sql.Time;
import java.util.Date;
import java.util.regex.Pattern;

import static by.htp.easyfly.util.RegularExpression.*;

/**
 * Created by Ayumazec on 13.07.2017.
 */
public class InputDataValidator {
    public InputDataValidator() {
    }

    public boolean isValidLogin(String login) {
        return null != login && Pattern.matches(LOGIN, login);
    }

    public static boolean isValidPassword(String password) {
        return null != password && Pattern.matches(PASSWORD, password);
    }

    //Checking incoming parameters when creating a ticket
    public static boolean isValidUser(String login, String password, String name, String surname, String email) {
        return null != login && null != password && null != name && null != surname & null != email && Pattern.matches(LOGIN, login) && Pattern.matches(PASSWORD, password) && Pattern.matches(USERNAME, name) && Pattern.matches(USERSURNAME, surname) && Pattern.matches(EMAIL, email);
    }

    public static boolean isValidPassenger(String name, String surname, int age, String passportNumber){
        return null != name
                && null != surname
                && age != 0
                && null != passportNumber
                && Pattern.matches(NAME, name)
                && Pattern.matches(SURNAME, surname)
                && Pattern.matches(PASSPORT, passportNumber)
                && Pattern.matches(AGE, String.valueOf(age));
    }
    public static boolean isSameDestination(String departure, String arrival) {
        return departure.equals(arrival);
    }
    public static boolean dateInPast(Date departureDate, Date arrivalDate){
        Date currentDate = new Date();
        int resultForDeparture =departureDate.compareTo(currentDate);
        int resultForArrival =arrivalDate.compareTo(currentDate);
        return resultForDeparture < 0 || resultForArrival < 0;
    }
    public static boolean isArrivalBeforeDeparture(Date departureDate, Date arrivalDate){
        int resultForDeparture =arrivalDate.compareTo(departureDate);
        return resultForDeparture < 0;
    }
    public static boolean isBirthdayBeforeDeparture(Date departureDate, Date birthday){
        int resultCompare=birthday.compareTo(departureDate);
        return resultCompare < 0;
    }
    public static boolean isExpiryBeforeArrival(Date arrivalDate, Date expiry){
        int resultCompare=expiry.compareTo(arrivalDate);
        return resultCompare < 0;
    }
    public static boolean isValidDates(Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime) {

        if (departureDate.getTime() > arrivalDate.getTime()) {
            return false;
        }
        if (departureDate.getTime() == arrivalDate.getTime()) {
            if (departureTime.getTime() <= arrivalTime.getTime())
                return true;
            else
                return false;
        }
        else
            return true;
	}

    public static boolean isEmptyDate(Date departureDate, Time departureTime, Date arrivalDate, Time arrivalTime) {
        return departureDate == null || departureTime == null || arrivalDate == null || arrivalTime == null;
	}

}
