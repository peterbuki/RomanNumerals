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
            assertEquals(RomanNumber.M, RomanNumber.findByValue(1001)) ;
            assertEquals(RomanNumber.CM, RomanNumber.findByValue(999)) ;
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
        assertEquals(3, RomanConverter.convertToArabic("III"));
        assertEquals(5, RomanConverter.convertToArabic("V"));
        assertEquals(291, RomanConverter.convertToArabic("CCXCI"));
        assertEquals("XXIX", RomanConverter.convertToRoman(29));
        assertEquals("XXXVIII", RomanConverter.convertToRoman(38));
        assertEquals("MCMXCIX", RomanConverter.convertToRoman(1999));
    }

}
