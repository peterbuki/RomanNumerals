package com.ericsson.peterbuki;

/**
 * Created by epetbuk on 2016.05.31..
 */
public enum RomanNumberEnum
{
    M(1000,"M"), CM(900, "CM"), D(500, "D"), CD(400, "CD"), C(100,"C"),
    XC(90, "XC"), XL(40, "XL"),
    L(50, "L"), X(10, "X"), IX(9, "IX"),
    V(5, "V"), IV(4, "IV"), I(1, "I"), UNKNOWN(0, "UNKNOWN") ;

    int value;
    String name;

    RomanNumberEnum(int n, String c)
    {
        value = n;
        name = c;
    }

    protected static RomanNumberEnum findByValue(int value)
    {
        for (RomanNumberEnum n : RomanNumberEnum.values())
            if (n.value<=value)
                return n ;
        return UNKNOWN;
    }

    protected static RomanNumberEnum findByName(char name)
    {
        return findByName(String.valueOf(name)) ;
    }

    protected static RomanNumberEnum findByName(String name)
    {
        for (RomanNumberEnum n : RomanNumberEnum.values())
            if (n.name.equalsIgnoreCase(name))
                return n ;
        return UNKNOWN;
    }
}