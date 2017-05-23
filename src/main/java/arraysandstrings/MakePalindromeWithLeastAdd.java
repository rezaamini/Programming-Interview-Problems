/*
    
    Given a string, return the least number of characters to be added the string
    in order to make it a palindrome.

 */
package arraysandstrings;

/**
 *
 * @author Reza Amini
 */
public class MakePalindromeWithLeastAdd
{
    // Find the longest palindrome at the end of the string.
    // The remaining number of characters is the answer.
    public static int leastCharastersToMakePalindrome(String s)
    {
        int n = s.length();
        int i = 0;
        while(i < n - 1)
        {
            if(isPalindrome(s.substring(i)))
                return i;
            i++;
        }
        return i;
    }
    
    public static boolean isPalindrome(String s)
    {
        int n = s.length();
        for(int i = 0; i < n / 2; i++)
            if(s.charAt(i) != s.charAt(n - 1 - i))
                return false;
        return true;
    }
    
    public static String makePalindromeWithLeastAdd(String s)
    {
        int i = leastCharastersToMakePalindrome(s);
        StringBuilder pal = new StringBuilder(s.substring(0, i));
        pal = pal.reverse();
        pal.insert(0, s);
        return pal.toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println(leastCharastersToMakePalindrome("aecbcb"));
        System.out.println(makePalindromeWithLeastAdd("aecbcb"));
        System.out.println(leastCharastersToMakePalindrome("bcb"));
        System.out.println(makePalindromeWithLeastAdd("bcb"));
    }
}
