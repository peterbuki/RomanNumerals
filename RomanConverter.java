package com.ericsson.peterbuki;

/**
 * Created by epetbuk on 2016.05.18..
 */
public class RomanConverter {
    public static enum RomanNumber
    {
        M(1000,"M"), CM(900, "CM"), D(500, "D"), CD(400, "CD"), C(100,"C"),
        XC(90, "XC"), XL(40, "XL"),
        L(50, "L"), X(10, "X"), IX(9, "IX"),
        V(5, "V"), IV(4, "IV"), I(1, "I") ;

        int value;
        String name;

        RomanNumber(int n, String c)
        {
            value =n ;
            name =c ;
        }

        static RomanNumber findNearestByValue(int value)
        {
            for (RomanNumber n : RomanNumber.values())
                if (n.value<=value)
                    return n ;
            return null ;
        }

        static RomanNumber findByName(String name)
        {
            for (RomanNumber n : RomanNumber.values())
                if (n.name.equalsIgnoreCase(name))
                    return n ;
            return null ;
        }
    }

    protected RomanConverter()
    {
        System.out.println("RomanConverter constructor.") ;
        for (RomanNumber n : RomanNumber.values())
        {
            System.out.println(n.name + " = " + n.value) ;
        }
    }

    public static int convert(String in) throws Exception
    {
        int result = 0 ;
        String toDecode ;
        for (int position = 0; position < in.length(); position++)
        {
            RomanNumber rn = null ;

            // try to convert 2 characters
            if (in.length()-position > 1)
                rn = RomanNumber.findByName(in.substring(position, position+2)) ;

            // converted 2 characters, pos increased by additional 1
            if (rn != null)
                position++ ;
            else
                rn = RomanNumber.findByName(in.substring(position, position+1)) ;

            result += rn.value ;
        }
        return result ;
    }

    public static String convert(int in) throws Exception
    {
        RomanNumber n =  RomanNumber.findNearestByValue(in) ;

        if ( n.value == in )
            return n.name ;
        else
            return n.name + convert(in-n.value) ;
    }
}
