package com.peterbuki.romannumerals2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by epetbuk on 2016.09.21..
 */
public class RomanNumerals2Test
{
    RomanConverter romanConverter = new RomanConverter() ;

    @Before
    public void setUp() {

    }

    @Test
    public void testSingleNumeral() {
        assertEquals(1, romanConverter.convertRomanToArabic("I")) ;
        assertEquals(5, romanConverter.convertRomanToArabic("V")) ;
        assertEquals(10, romanConverter.convertRomanToArabic("X")) ;
        assertEquals(50, romanConverter.convertRomanToArabic("L")) ;
        assertEquals(100, romanConverter.convertRomanToArabic("C")) ;
        assertEquals(500, romanConverter.convertRomanToArabic("D")) ;
        assertEquals(1000, romanConverter.convertRomanToArabic("M")) ;
    }

    @Test
    public void testMultiNumeral() {
        assertEquals(9, romanConverter.convertRomanToArabic("IX"));
        assertEquals(3999, romanConverter.convertRomanToArabic("MMMCMXCIX"));
    }

    @Test
    public void testHighestArabic() {
        assertEquals("MMMCMXCIX", romanConverter.convertArabicToRoman(3999));
    }

    @Test(expected = NumberFormatException.class)
    public void invalidAlphabetThrowsException()
    {
        romanConverter.convertRomanToArabic("IDCLUXVM");
    }


}
