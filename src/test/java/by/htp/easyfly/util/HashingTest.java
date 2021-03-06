package by.htp.easyfly.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Mazets
 * This class serves for testing self-titled util class Hashing
 * Class uses JUnit- a simple framework to write repeatable tests.
 * @see by.htp.easyfly.util.Hashing
 * @see org.junit.runner.JUnitCore
 * @since 1.0
 */
public class HashingTest {
    @Test
    public void passwordEncodeTest(){
      String stringExpected="25d55ad283aa400af464c76d713c07ad";
      Assert.assertEquals(stringExpected,Hashing.passwordEncode("12345678"));
    }
    @Deprecated
    public void md5HexTest(){
        String stringExpected="25d55ad283aa400af464c76d713c07ad";
        Assert.assertEquals(stringExpected,org.apache.commons.codec.digest.DigestUtils.md5Hex("12345678"));
    }
}
