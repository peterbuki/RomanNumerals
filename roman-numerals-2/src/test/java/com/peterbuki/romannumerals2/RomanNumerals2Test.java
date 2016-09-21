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
        assertEquals(1, romanConverter.convert("I")) ;
        assertEquals(5, romanConverter.convert("V")) ;
        assertEquals(10, romanConverter.convert("X")) ;
        assertEquals(50, romanConverter.convert("L")) ;
        assertEquals(100, romanConverter.convert("C")) ;
        assertEquals(500, romanConverter.convert("D")) ;
        assertEquals(1000, romanConverter.convert("M")) ;
    }


}
