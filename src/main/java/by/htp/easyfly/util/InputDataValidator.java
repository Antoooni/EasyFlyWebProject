package by.htp.easyfly.util;

import java.util.regex.Pattern;

import static by.htp.easyfly.util.RegularExpression.*;

/**
 * Created by Ayumazec on 13.07.2017.
 */
public class InputDataValidator {
    public InputDataValidator() {
    }

    public boolean isValidLogin(String login) {
        if (null != login) {
            return Pattern.matches(LOGIN, login);
        }
        return false;
    }

    public static boolean isValidPassword(String password) {
        if (null != password) {
            return Pattern.matches(PASSWORD, password);
        }
        return false;
    }

    //Checking incoming parameters when creating a ticket
    public static boolean isValidUser(String login, String password, String name, String surname, String email) {
        if (null != login && null != password && null != name && null != surname & null != email) {
            return
                    Pattern.matches(LOGIN, login) &&
                    Pattern.matches(PASSWORD, password) &&
                    Pattern.matches(USERNAME, name) &&
                    Pattern.matches(USERSURNAME, surname) &&
                    Pattern.matches(EMAIL, email);
        }
        return false;
    }
    public static boolean isValidPassenger(String name, String surname, int age, String passportNumber){
        if(null!=name && null!=surname && age!=0 &&null!=passportNumber){
            return
                    Pattern.matches(NAME, name) &&
                    Pattern.matches(SURNAME, surname) &&
                    Pattern.matches(PASSPORT, passportNumber) &&
                    Pattern.matches(AGE, String.valueOf(age));
        }
        return false;
    }
}
