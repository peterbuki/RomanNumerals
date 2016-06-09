package com.ericsson.peterbuki;

import static com.ericsson.peterbuki.RomanConverter.isConvertibleToRoman;
import static com.ericsson.peterbuki.RomanConverter.isConvertibleToArabic;
import static com.ericsson.peterbuki.RomanConverter.convertToArabic ;
import static com.ericsson.peterbuki.RomanConverter.convertToRoman ;

public class RomanNumerals {
    private RomanNumerals() {}

    public static void main(String[] args) {
        if (args.length == 0)
            showUsage() ;
        for (String in : args)
        {
            if (isConvertibleToRoman(in))
            {
                System.out.println(convertToRoman(in)) ;
            }
            else if (isConvertibleToArabic(in))
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
