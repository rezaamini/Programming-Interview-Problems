/*

 Write a program that can convert an integer to a string and back. You may NOT 
 use dynamic array to hold the string. You may use a helper method to convert a 
 single digit character like ‘9’ to an integer.
 
 */
package arraysandstrings;

/**
 *
 * @author Reza Amini
 */
public class Converter
{
    public static String toString(int number)
    {
        StringBuilder out = new StringBuilder();
        if(number == 0)
            out.append("0");
        
        if(number < 0)
        {
            out.append("-");
            number *= -1;
        }
        
        // find largest power of 10
        int temp = number;
        int power = -1;
        while(temp > 0)
        {
            power++;
            temp /= 10;
        }
        
        int decimalOrder = (int)Math.pow(10, power);
        while(decimalOrder > 0)
        {
            int x = number / decimalOrder;
            out.append(x);
            number %= decimalOrder;
            decimalOrder /= 10;
        }
        
        return out.toString();
    }
    
    public static int toInteger(String str)
    {
        boolean isNegative = false;
        int start = 0;
        if(str.charAt(0) == '-')
        {
            isNegative = true;
            start = 1;
        }
        
        int result = 0;
        int n = str.length();
        for(int i = start; i < n; i++)
        {
            result = result * 10 + (str.charAt(i) - '0');
        }
        
        if(isNegative)
            result = -result;
        return result;
    }
    
    public static void main(String[] args)
    {
        System.out.println(toString(0));
        System.out.println(toString(10));
        System.out.println(toString(100));
        System.out.println(toString(-10));
        System.out.println(toString(-100));
        System.out.println(toString(1234));
        System.out.println(toString(-1234));
        
        System.out.println(toInteger("0"));
        System.out.println(toInteger("098765"));
        System.out.println(toInteger("10"));
        System.out.println(toInteger("100"));
        System.out.println(toInteger("-10"));
        System.out.println(toInteger("-100"));
        System.out.println(toInteger("1234"));
        System.out.println(toInteger("-1234"));
        
    }
}
