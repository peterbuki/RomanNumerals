package com.ericsson.peterbuki;

import static com.ericsson.peterbuki.RomanConverter.isArabic ;
import static com.ericsson.peterbuki.RomanConverter.isRoman ;
import static com.ericsson.peterbuki.RomanConverter.convertToArabic ;
import static com.ericsson.peterbuki.RomanConverter.convertToRoman ;

public class RomanNumerals {
    private RomanNumerals() {}

    public static void main(String[] args) {
        if (args.length == 0)
            showUsage() ;
        for (String in : args)
        {
            if (isArabic(in))
            {
                System.out.println(convertToRoman(in)) ;
            }
            else if (isRoman(in))
            {
                System.out.println(convertToArabic(in)) ;
            }
            else
                showUsage();
        }
    }

    private static void showUsage() {
        System.out.println("Wrong argument. Usage: java -jar romannumerals.jar <NUMBER in 1..3999>") ;
        System.exit(1) ;
    }
}
