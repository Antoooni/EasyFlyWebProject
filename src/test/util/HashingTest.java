package util;

import by.htp.easyfly.util.Hashing;
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
}
