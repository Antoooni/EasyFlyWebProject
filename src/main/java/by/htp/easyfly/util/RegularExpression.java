package by.htp.easyfly.util;

/**
 * Created by Ayumazec on 13.07.2017.
 */
public interface RegularExpression {
    String LOGIN="[A-z0-9_-]{4,20}";
    String PASSWORD="[A-z0-9_-]{6,20}";
    String EMAIL_PATTERN="[A-z0-9_\\.-]+@[a-z]+\\.[a-z]{2,4}";
    String NAME="^[a-zA-Z\\s]+$";
    String AGE="[0-9]{1,3}";
    String SURNAME ="^[A-zА-я]+";
    String USERNAME="^[a-zA-Z]+$";
    String USERSURNAME="^[a-zA-Z]+$";
    String PASSPORT= "[A-Za-z]{2}[0-9]{7}";


}
