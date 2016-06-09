package com.ericsson.peterbuki;

import org.junit.Test;

import static com.ericsson.peterbuki.RomanConverter.isConvertibleToArabic;
import static com.ericsson.peterbuki.RomanConverter.isConvertibleToRoman;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;

/**
 * Created by epetbuk on 2016.05.18..
 */
public class RomanConverterTest
{
    @Test
    public void isRomanTest_with_every_roman_character()
    {
        assertTrue(isConvertibleToArabic("MCDXLIV")); // Fails
    }

    @Test
    public void isRomanTest_with_internal_character_so_returns_false()
    {
        assertFalse(isConvertibleToArabic("MCDXLIVZ"));
    }

    @Test
    public void isRomanTest_with_not_roman_string()
    {
        assertFalse(isConvertibleToArabic("ALMAFA"));
    }

    @Test
    public void isArabicTest_with_maximum_value()
    {
        assertTrue(isConvertibleToRoman("3999"));
    }

    @Test
    public void isArabicTest_with_too_high_value()
    {
        assertFalse(isConvertibleToRoman("4000"));
    }

    @Test
    public void isArabicTest_with_character_string()
    {
        assertFalse(isConvertibleToRoman("ALMAFA"));
    }

    @Test
    public void isArabicTest_with_zero_string()
    {
        assertTrue(isConvertibleToRoman("0"));
    }

    @Test
    public void findByValueTest_with_1001()
    {
        assertEquals(RomanNumberEnum.M, RomanNumberEnum.findByValue(1001));
    }

    @Test
    public void findByValueTest_with_999()
    {
        assertEquals(RomanNumberEnum.CM, RomanNumberEnum.findByValue(999));
    }

    @Test
    public void findByNameTest_single_roman_number()
    {
        assertEquals(RomanNumberEnum.M, RomanNumberEnum.findByName("M"));
    }

    @Test
    public void findByNameTest_double_roman_number()
    {
        assertEquals(RomanNumberEnum.CD, RomanNumberEnum.findByName("CD"));
    }

    @Test
    public void convertToArabicTest_with_complicated_value_291()
    {
        assertEquals(291, RomanConverter.convertToArabic("CCXCI"));
    }

    @Test
    public void convertToRomanTest_with_complicated_value_1999()
    {
        assertEquals("MCMXCIX", RomanConverter.convertToRoman(1999));
    }


}
