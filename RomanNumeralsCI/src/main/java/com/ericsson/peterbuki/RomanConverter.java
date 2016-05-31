package com.ericsson.peterbuki;

/**
 * Created by epetbuk on 2016.05.18..
 */
public class RomanConverter {


    protected RomanConverter()
    {
        System.out.println("RomanConverter constructor.") ;
        for (RomanNumber n : RomanNumber.values())
        {
            System.out.println(n.name + " = " + n.value) ;
        }
    }

    public static int convertToArabic(String in)
    {
        int result = 0 ;
        String toDecode ;
        for (int position = 0; position < in.length(); position++)
        {
            RomanNumber rn = RomanNumber.Z ;

            // try to convertToRoman 2 characters
            if (in.length()-position > 1)
                rn = RomanNumber.findByName(in.substring(position, position+2)) ;

            // converted 2 characters, pos increased by additional 1
            if (rn != RomanNumber.Z)
                position++ ;
            else
                rn = RomanNumber.findByName(in.substring(position, position+1)) ;

            result += rn.value ;
        }
        return result ;
    }

    public static String convertToRoman(int in)
    {
        RomanNumber n =  RomanNumber.findByValue(in) ;

        if ( n.value == in )
            return n.name ;
        else
            return n.name + convertToRoman(in-n.value) ;
    }
}
