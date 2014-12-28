/*
 
 Remove duplicate characters from a string.
 
*/

package ArraysAndStrings;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Reza Amini
 */
public class DuplicateRemover
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan..nextLine();
        char[] chars = input.toCharArray();
        System.out.println(removeDuplicates(chars));
        System.out.println(removeDuplicates(new StringBuilder(input));
        System.out.println(removeDuplicates(input);
    }
    
    // Time complexity: O(N)
    // Space complexity: O(N)
    public static String removeDuplicates(char[] input)
    {
        int n = input.length;
        HashSet set = new HashSet();
        
        int index = 0;
        for(int i = 0; i < n; i++)
        {
            if(!set.contains(input[i]))
            {
                set.add(input[i]);
                input[index] = input[i];
                index++;
            }
        }
        
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < index; i++)
            out.append(input[i]);
        return out.toString();
    }
    
    /* 
     * Without additional buffer.
     * We get the input as a StringBuilder and remove the duplicates in place.
     * Use StringBuilder when you want to concatinate strings in loops to use less space
     * Time complexity: O(n^2)
     */
    public static String removeDuplicates(StringBuilder str) 
    {
        int index = 1; // index of the next unique character in output
        for (int i = 1 ; i < str.length() ; i++) // for all characters in the string
        {
            int j; // runner pointer for previous unique characters
            for (j = 0 ; j < index ; j++) // compare the characters with previous unique ones
            { 
                if (str.charAt(i) == str.charAt(j))
                    break;
            }

            if (j == index) 
            {
                str.setCharAt(index, str.charAt(i));
                index++;
            }
        }

        str.setLength(index);
        return new String(str);
    }

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public static String removeDuplicates(String str) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if (output.indexOf(str.substring(i, i+1)) == -1)
                output.append(str.charAt(i));
        }
        return output.toString();
    }
}
