/*
 
 Find all palindromes inside a given string. 
 
*/ 

package arraysandstrings;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 * 
 * @author Reza Amini
 */
public class Palindrome
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int n = input.length();
        
        Set<String> outList = new HashSet<String>();
        
        for(int i = 0; i < n; i++)
        {
            // even sized palindromes
            findPalindromes(i, i + 1, outList, input);
            
            // odd sized palindromes
            findPalindromes(i - 1, i + 1, outList, input);
        }
        
        for(String palindrome: outList)
            System.out.println(palindrome);
    }
    
    public static void findPalindromes(int left, int right, Set<String> outList, String input)
    {
        StringBuilder out = new StringBuilder();
        // For odd palindromes, put the middle character in the middle of putput
        if(right - left == 2)
            out.append(input.charAt(left + 1));
        int n = input.length();
        while(left >= 0 && right < n)
        {
            if(input.charAt(left) != input.charAt(right))
                break;
            out.insert(0, input.charAt(left)); // insert to the beginning
            out.append(input.charAt(right)); // insert to the end
            outList.add(out.toString()); // save all palindromes in the way
            left--;
            right++;
        }
    }
}
