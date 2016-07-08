package com.ericsson.peterbuki;

import java.util.Date;
import java.util.Random;

/**
 * Created by epetbuk on 2016.06.16..
 */
public class TextMunger
{
    private static Random randomGenerator ;

    public static void main(String ... args) {
        if (args.length == 0) {
            showUsage();
        }
        else {
            initializeRandomGenerator();
            mungeStringArray(args);
        }

    }

    private static void initializeRandomGenerator()
    {
        if (randomGenerator == null) {
            randomGenerator = new Random(System.nanoTime());
        }

    }

    protected static void setRandomGenerator( Random randomGenerator )
    {
        TextMunger.randomGenerator = randomGenerator;
    }

    protected static void mungeStringArray( String[] args )
    {
        for (String str : args) {
            System.out.println(mungeOneSentence(str));
        }
    }

    protected static void showUsage()
    {
        System.err.println("Usage: java -jar TextMunger.jar 'Text to be munged'");
    }

    protected static String mungeOneSentence( String sentence )
    {
        return "";
    }
}
