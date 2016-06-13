package com.ericsson.peterbuki;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.ericsson.peterbuki.RomanNumerals.main;
import static org.junit.Assert.assertEquals;

/**
 * Created by epetbuk on 2016.06.09..
 */
public class IntegrationTest
{
    private ByteArrayOutputStream stdout = new ByteArrayOutputStream();
    private ByteArrayOutputStream stderr = new ByteArrayOutputStream();


    @Before
    public void setup()
    {
        System.setOut(new PrintStream(stdout));
        System.setErr(new PrintStream(stderr));
    }

    @Test
    public void provide_usage_info_for_invalid_value()
    {
        main(new String[]{"4000"});
        assertEquals("", stdout.toString());
        assertEquals("Wrong argument. Usage: java -jar romannumerals.jar <NUMBER in 1..3999>" + System.getProperty
                ("line.separator"), stderr.toString());
    }

    @Test
    public void convert_an_arabic_number()
    {
        main(new String[]{"CCXCI"});
        assertEquals("291" + System.getProperty("line.separator"), stdout.toString());
        assertEquals("", stderr.toString());
    }

    @Test
    public void convert_a_roman_number()
    {
        main(new String[]{"MCMXCIX"});
        assertEquals("1999" + System.getProperty("line.separator"), stdout.toString());
        assertEquals("", stderr.toString());

    }

}
