package by.htp.easyfly.util;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * @author Anton Mazets
 * <p>Class represent value in hex string representation of the md5 algorithm</p>
 * @since 1.0
 */
public class Hashing {
    public static String passwordEncode(String value){
        return DigestUtils.md5Hex(value);
    }
}
