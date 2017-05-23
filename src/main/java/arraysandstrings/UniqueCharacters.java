/*

 Implement an algorithm to determine if a string has all unique characters.
 What if you can not use additional data structures?
 
*/

package arraysandstrings;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Reza Amini
 */
public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext())
        {
            String word = input.next();
            if (word.equals("#"))
                break;
            boolean isUnique = isUniqueChars4(word);
        if (isUnique)
            System.out.println("All the characters are unique.");
        else
            System.out.println("Characters are not unique.");
        }
    }

    /* Assuming that all the characters of the string are ASCII
     * If characters are not ASCII we can increase the size of the charSet
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static boolean isUniqueChars(String str) {
        boolean[] charSet = new boolean[256];
        for (int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if (charSet[c])
                return false;
            else
                charSet[c] = true;
        }
        return true;
    }

    // In ordet not to worry about the ASCII codes
    public static boolean isUniqueChars2(String str) {
        HashMap<Character, Boolean> table = new HashMap<Character, Boolean>();
        for (int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if (table.containsKey(c) && table.get(c))
                return false;
            else
                table.put(c, Boolean.TRUE);
        }

        return true;
    }
    
    // Use less space (only one integer)
    // This approach does not work if you have characters whose ASCII codes are 
    // more than 31 appart. For example the ASCII code for '1' is 49 and the 
    // ASCII code for 'Q' is 81 which is 32 places away from 1. So, these two 
    // characters are recognized the same. Because, the shift left goes back to 
    // the first position again after passing 31 positions.
    public static boolean isUniqueChars3(String word)
    {
        int checker = 0;
        for(int i = 0; i < word.length(); i++)
        {
            int val = word.charAt(i);
            if((checker & (1 << val)) > 0)
                return false;
            checker |= (1 << val);
        }
        return true;
    }
    
    // Use no additional data structure
    public static boolean isUniqueChars4(String word)
    {
        char[] str = word.toCharArray();
        qSort(str, 0, str.length - 1);
        System.out.println(str);
        for(int i = 0; i < str.length - 1; i++)
            if(str[i] == str[i + 1])
                return false;
        return true;
    }
    
    public static void qSort(char[] str, int start, int end)
    {
        int i = start;
        int j = end;
        Random r = new Random();
        int pivot = r.nextInt(end - start + 1) + start;
        while(i <= j)
        {
            while(str[i] < str[pivot])
                i++;
            while(str[j] > str[pivot])
                j--;
            if(i <= j)
                swap(str, i++, j--);
        }
        
        if (start < i - 1)
            qSort(str, start, i - 1);
        if (i < end)
            qSort(str, i, end);
    }
    
    public static void swap(char[] str, int a, int b)
    {
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }
}
