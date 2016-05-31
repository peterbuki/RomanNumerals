package com.ericsson.peterbuki;

public class RomanNumerals {

    public static void main(String[] args) {
        if (args.length == 0)
            showUsage() ;
        for (String in : args)
        {
            try
            {
                int number = Integer.parseInt(in) ;
                if (number > 3999)
                    showUsage();
                String result = RomanConverter.convert(number) ;
                System.out.println(result) ;
                continue;
            }
            // Failed to interpret argument as number
            catch (NumberFormatException e)
            {
            }
            // Failed to convert argument
            catch (Exception e)
            {
            }

            try
            {
                int result = RomanConverter.convert(in) ;
                System.out.println(result) ;
            }
            catch (Exception e)
            {
               showUsage() ;
               break ;
            }

        }
    }

    private static void showUsage() {
        System.out.println("Wrong argument. Usage: java -jar romannumerals.jar <NUMBER in 1..3999>") ;
        System.exit(1) ;
    }
}
