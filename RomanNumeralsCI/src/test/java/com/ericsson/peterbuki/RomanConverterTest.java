package com.ericsson.peterbuki;
import org.junit.Test ;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by epetbuk on 2016.05.18..
 */
public class RomanConverterTest extends RomanConverter {
    @Test
    public void findNearestByValueTest()
    {
        try
        {
            assertEquals(RomanNumber.M, RomanNumber.findNearestByValue(1001)) ;
            assertEquals(RomanNumber.CM, RomanNumber.findNearestByValue(999)) ;
        }
        catch (Exception e)
        {
            fail("Unexpected Exception :)");
        }
    }

    @Test
    public void findByNameTest()
    {
        try
        {
            assertEquals(RomanNumber.V, RomanNumber.findByName("V"));
            assertEquals(RomanNumber.M, RomanNumber.findByName("M"));
            assertEquals(RomanNumber.CD, RomanNumber.findByName("CD"));
        }
        catch (Exception e)
        {
            fail("Unexpected Exception :)");
        }

    }

    @Test
    public void convert()
    {
        try {


            assertEquals(3, convert("III"));
            assertEquals(5, convert("V"));
            assertEquals(291, convert("CCXCI"));
            assertEquals("XXIX", convert(29));
            assertEquals("XXXVIII", convert(38));
            assertEquals("MCMXCIX", convert(1999));
        }
        catch (Exception e)
        {
            fail("Unexpected Exception :)");
        }
    }

}
