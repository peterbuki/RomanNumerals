package com.peterbuki.romannumerals2;

/**
 * Created by epetbuk on 2016.09.26..
 */
public class RomanNumerals2
{
    public static void main(String... args) {
        if (args.length != 1) {
            showHelp();
            return;
        }

        RomanConverter converter = new RomanConverter();

        try
        {
            int arabicNumberToConvert = Integer.parseInt(args[0]);
            String romanResult = converter.convertArabicToRoman(arabicNumberToConvert);
            System.out.println(romanResult);
            return;
        } catch (NumberFormatException e) {
        }

        try
        {
            int arabicResult = converter.convertRomanToArabic(args[0]);
            System.out.println(arabicResult);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            showHelp();
        }


    }

    private static void showHelp() {
        System.out.println("Usage:");
        System.out.println("RomanNumerals2 <arabic value|roman value>");
        System.out.println("Example:");
        System.out.println("RomanNumerals2 3999");
    }
}
