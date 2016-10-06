package com.peterbuki.romannumerals2;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class IntegrationTest
{
    private ByteArrayOutputStream outByteArrayOutputStream;
    private ByteArrayOutputStream errByteArrayOutputStream;
    private PrintStream outPrintStream;
    private PrintStream errPrintStream;

    @Before
    public void setup() {
        outByteArrayOutputStream = new ByteArrayOutputStream();
        outPrintStream = new PrintStream(outByteArrayOutputStream);
        System.setOut(outPrintStream);
        errByteArrayOutputStream = new ByteArrayOutputStream();
        errPrintStream = new PrintStream(errByteArrayOutputStream);
        System.setErr(errPrintStream);
    }
    @Test
    public void printsHelp() {
        final String help = "Usage:" + System.lineSeparator() +
                "RomanNumerals2 <arabic value|roman value>" + System.lineSeparator() +
                "Example:" + System.lineSeparator() +
                "RomanNumerals2 3999" + System.lineSeparator();
        RomanNumerals2.main(new String[]{"uno", "due"});
        assertEquals(help, outByteArrayOutputStream.toString());
    }

    @Test
    public void printsOut3999InArabic() {
        RomanNumerals2.main(new String[]{"MMMCMXCIX"});
        assertEquals("3999" + System.lineSeparator(), outByteArrayOutputStream.toString());
    }

    @Test
    public void printsOut3999InRoman() {
        RomanNumerals2.main(new String[]{"3999"});
        assertEquals("MMMCMXCIX" + System.lineSeparator(), outByteArrayOutputStream.toString());
    }

}
