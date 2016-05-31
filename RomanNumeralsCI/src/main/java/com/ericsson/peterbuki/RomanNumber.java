package com.ericsson.peterbuki;

/**
 * Created by epetbuk on 2016.05.31..
 */
public enum RomanNumber
{
    M(1000,"M"), CM(900, "CM"), D(500, "D"), CD(400, "CD"), C(100,"C"),
    XC(90, "XC"), XL(40, "XL"),
    L(50, "L"), X(10, "X"), IX(9, "IX"),
    V(5, "V"), IV(4, "IV"), I(1, "I"), Z(0, "Z") ;

    int value;
    String name;

    RomanNumber(int n, String c)
    {
        value =n ;
        name =c ;
    }

    private static RomanNumber findNearestByValue(int value)
    {
        for (RomanNumber n : RomanNumber.values())
            if (n.value<=value)
                return n ;
        return Z;
    }

    private static RomanNumber findByName(String name)
    {
        for (RomanNumber n : RomanNumber.values())
            if (n.name.equalsIgnoreCase(name))
                return n ;
        return Z ;
    }
}