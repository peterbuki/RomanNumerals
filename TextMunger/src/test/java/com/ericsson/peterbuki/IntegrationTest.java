package com.ericsson.peterbuki;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;


/**
 * Created by epetbuk on 2016.06.16..
 */
public class IntegrationTest
{
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private ByteArrayOutputStream err = new ByteArrayOutputStream();

    @Before
    public void setup_test_environment() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @After
    public void reset_output_streams() {
        out.reset();
        err.reset();
    }

    @Test
    public void print_usage_for_no_arguments()
    {
        TextMunger.main();
        assertTrue(out.toString().equals(""));
        assertTrue(err.toString().equals("Usage: java -jar TextMunger.jar 'Text to be munged'" +
                System.getProperty("line.separator")));
    }

    @Test
    public void mungle_one_sentence() {
        TextMunger.main("Some text to be munged.");
        assertTrue(err.toString().equals(""));
        assertTrue(out.toString().equals("Smoe txet to be megnud." +
                System.getProperty("line.separator")));
    }

    @Test
    public void randomized_mungling_test() {
        // checking each word for first and last character
        assertTrue(false);
    }

}
