package by.htp.easyfly.util;



import org.apache.commons.codec.digest.DigestUtils;


/**
 * Created by Ayumazec on 15.08.2017.
 */
public class Hashing {
    public static String passwordEncode(String value){
        return DigestUtils.md5Hex(value);
    }
}
