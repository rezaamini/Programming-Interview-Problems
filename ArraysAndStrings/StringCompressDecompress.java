
package ArraysAndStrings;

import java.util.Scanner;

/**
 *
 * @author rezaamini
 */
public class StringCompressDecompress
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        
        String compressed = compress(input); 
        System.out.println(compressed);
        String decompressed = decompress(compressed);
        System.out.println(decompressed);
    }
    
    public static String compress(String input)
    {
        StringBuilder out = new StringBuilder();
        int n = input.length();
        for(int i = 0; i < n; i++)
        {
            int counter = 1;
            char current = input.charAt(i);
            while(i + 1 < n && current == input.charAt(i + 1))
            {
                counter++;
                i++;
            }
            out.append(counter).append(current);
        }
        return out.toString();
    }
    
    public static String decompress(String input)
    {
        StringBuilder out = new StringBuilder();
        StringBuilder numberStr = new StringBuilder();
        int n = input.length();
        for(int i = 0; i < n; i++)
        {
            // get the bumber which can be more than one digit
            while(Character.isDigit(input.charAt(i)))
            {
                numberStr.append(input.charAt(i));
                i++;
            }
            int number = Integer.parseInt(numberStr.toString());
            // print character "number" times
            for(int j = 0; j < number; j++)
                out.append(input.charAt(i));
            numberStr.delete(0, numberStr.length());
        }
        
        return out.toString();
    }
}
