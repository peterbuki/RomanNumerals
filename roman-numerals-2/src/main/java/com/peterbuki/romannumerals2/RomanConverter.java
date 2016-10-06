package com.peterbuki.romannumerals2;


public class RomanConverter
{

    public enum RomanNumeral
    {
        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1),
        Invalid(0);

        public final int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public boolean isValid() {
            return this!=Invalid;
        }

        public static RomanNumeral getByAlphabet(String name) {
            for (RomanNumeral r : RomanNumeral.values())
            {
                if (name.equalsIgnoreCase(r.name())) {
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
            for (RomanNumeral currentRomanNumeral : RomanNumeral.values())
            {
                if (currentRomanNumeral.value <= remaining)
                {
                    result += currentRomanNumeral.name();
                    remaining -= currentRomanNumeral.value;
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
        return RomanNumeral.getByAlphabet(String.valueOf(c));
    }
}
