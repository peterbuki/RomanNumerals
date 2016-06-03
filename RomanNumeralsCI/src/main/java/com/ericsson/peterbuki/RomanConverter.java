package com.ericsson.peterbuki;

/**
 * Created by epetbuk on 2016.05.18..
 */
public class RomanConverter {
    public static final int MAX_VALUE = 3999 ;

    protected RomanConverter()
    {
        System.out.println("RomanConverter constructor.") ;
        for (RomanNumberEnum n : RomanNumberEnum.values())
        {
            System.out.println(n.name + " = " + n.value) ;
        }
    }

    public static int convertToArabic(String in)
    {
        boolean wasLastDouble ;
        int result = 0 ;
        for (int position = 0; position < in.length(); position+=wasLastDouble?2:1)
        {
            wasLastDouble=false ;
            RomanNumberEnum rn = RomanNumberEnum.Z ;

            // try to convertToRoman 2 characters
            if (in.length()-position > 1)
                rn = RomanNumberEnum.findByName(in.substring(position, position+2)) ;

            // converted 2 characters, pos increased by additional 1
            if (rn != RomanNumberEnum.Z)
                wasLastDouble=true ;
            else
                rn = RomanNumberEnum.findByName(in.substring(position, position+1)) ;

            result += rn.value ;
        }
        return result ;
    }
    public static boolean isArabic(String in)
    {
        boolean result ;
        try
        {
            int number = Integer.parseInt(in) ;
            result = (number <= MAX_VALUE) ;
        }
        catch (NumberFormatException e)
        {
            result = false ;
        }
        return result;
    }

    public static boolean isRoman(String in)
    {
        for (int pos=0 ; pos < in.length() ; pos++)
        {
            System.out.println("Checking: " + in.substring(pos,pos)) ;
            if (RomanNumberEnum.findByName(in.substring(pos,pos)) == RomanNumberEnum.Z)
            {
                return false ;
            }
        }
        return true ;
    }

    public static String convertToRoman(String in)
    {
        try
        {
            int number = Integer.parseInt(in) ;
            return convertToRoman(number) ;
        }
        catch (NumberFormatException e)
        {
            return "" ;
        }
    }
    public static String convertToRoman(int in)
    {
        RomanNumberEnum n =  RomanNumberEnum.findByValue(in) ;

        if ( n.value == in )
            return n.name ;
        else
            return n.name + convertToRoman(in-n.value) ;
    }
}
