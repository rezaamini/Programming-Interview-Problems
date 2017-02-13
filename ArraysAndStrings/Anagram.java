/*

 Get two strings and find out if they are anagrams.
  
 */

package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author rezaamini
 */
public class Anagram
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter 1st string: ");
        String s1 = scan.next().toLowerCase();
        System.out.print("Enter 2nd string: ");
        String s2 = scan.next().toLowerCase();
        checkAnagram_1(s1, s2);
        checkAnagram_2(s1, s2);
    }
    
    // Save the strings in arrays of characters, sort the arrays and compare them character by character. 
    // Time complexity: O(N.logN)
    // Space complexity: O(N)
    public static void checkAnagram_1(String s1, String s2)
    {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        
        if(s1Array.length != s2Array.length)
        {
            System.out.println("Not anagrams");
            System.exit(0);
        }
    
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
    
        for(int i = 0; i < s1Array.length; i++)
        {
            if(s1Array[i] != s2Array[i])
            {
                System.out.println("Not anagrams");
                return;
            }
        }
        
        System.out.println("Anagrams");
    }
    
    // Save the strings in arrays of characters, use a map to count characters
    // Time complexity: O(N)
    // Space complexity: O(N)
    public static void checkAnagram_2(String s1, String s2)
    {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        
        // If we know that all characters are alphabets, we can use an array of size 26 instead of the HashMap
        Map<Character, Integer> seen = new HashMap<>();
        if(s1Array.length != s2Array.length)
        {
            System.out.println("Not anagrams");
            return;
        }
        
        for(int i = 0; i < s1Array.length; i++)
        {
            if(seen.containsKey(s1Array[i]))
                seen.put(s1Array[i], seen.get(s1Array[i]) + 1);
            else
                seen.put(s1Array[i], 1);
        }
        
        for(int i = 0; i < s2Array.length; i++)
        {
            if(seen.containsKey(s2Array[i]))
                seen.put(s2Array[i], seen.get(s2Array[i]) - 1);
            else
            {
                System.out.println("Not anagrams");
                return;
            }
        }
        
        for(Character c: seen.keySet())
        {
            if(seen.get(c) != 0)
            {
                System.out.println("Not anagrams");
                return;
            }
        }
        
        System.out.println("Anagrams");
    }
}
