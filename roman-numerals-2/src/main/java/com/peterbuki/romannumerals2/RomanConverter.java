package com.peterbuki.romannumerals2;


public class RomanConverter
{

    public enum RomanNumeral
    {
        M(1000, 'M'),
        D(500, 'D'),
        C(100, 'C'),
        L(50, 'L'),
        X(10, 'X'),
        V(5, 'V'),
        I(1, 'I'),
        Invalid(0, 'Z');

        public final int value;
        public final char alphabet;

        RomanNumeral(int i, char c) {
            value=i;
            alphabet=c;
        }

        public boolean isValid() {
            return this!=Invalid;
        }

        public static RomanNumeral getByAlphabet( char c) {
            for (RomanNumeral r : RomanNumeral.values())
            {
                if (c == r.alphabet) {
                    return r;
                }
            }
            return RomanNumeral.Invalid;
        }

        public static RomanNumeral getByValue( int value) {
            for (RomanNumeral r : RomanNumeral.values())
            {
                if (value == r.value) {
                    return r;
                }
            }
            return RomanNumeral.Invalid;
        }

    }

    public RomanConverter() {

    }

    public String convertArabicToRoman( int arabicNumberToConvert )
    {
        int remaining = arabicNumberToConvert;
        String result = "";
        while ( remaining > 0)
        {
            for (RomanNumeral r : RomanNumeral.values())
            {
                if (r.value < arabicNumberToConvert)
                {
                    result += r.alphabet;
                    remaining -= r.value;
                    break;
                }
            }
        }
        return result;
    }

    public int convertRomanToArabic( String romanNumber )
    {
        int result = 0;
        RomanNumeral previous = RomanNumeral.Invalid;
        for (int i = romanNumber.length()-1; i >= 0 ; i--)
        {
            RomanNumeral currentValue = convertRomanToArabic(romanNumber.charAt(i));
            if (currentValue.isValid()) {
                if (currentValue.value < previous.value) {
                    result -= currentValue.value;
                } else {
                    result += currentValue.value;
                }
                previous = currentValue;
            }
            else
            {
                throw new NumberFormatException(
                        String.format("Illegal roman character: '%s' at position %d", romanNumber.charAt(i), i));
            }
        }
        return result;
    }

    private RomanNumeral convertRomanToArabic( char c )
    {
        return RomanNumeral.getByAlphabet(c);
    }
}
