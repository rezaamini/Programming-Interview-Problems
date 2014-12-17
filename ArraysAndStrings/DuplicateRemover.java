
package ArraysAndStrings;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Remove duplicate characters from a string.
 * 
 * @author Reza Amini
 */
public class DuplicateRemover
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        char[] input = scan.nextLine().toCharArray();
        System.out.println(removeDuplicates(input));
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
}
