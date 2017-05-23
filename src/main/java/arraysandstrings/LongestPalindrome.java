/*
 
    FInd the longest palindrome in a string.

 */
package arraysandstrings;

/**
 *
 * @author Reza Amini
 */
public class LongestPalindrome
{
    public static String longestPalindrome(String s)
    {
        int n = s.length();
        String longest = s.substring(0, 1);
        for(int i = 0; i < n; i++)
        {
            // Even sized palindromes
            String temp = longestPalindrome(i, i + 1, s);
            longest = (longest.length() > temp.length())? longest: temp;
            // Odd sized palindromes
            temp = longestPalindrome(i - 1, i + 1, s);
            longest = (longest.length() > temp.length())? longest: temp;
        }
        return longest;
    }
    
    public static String longestPalindrome(int left, int right, String s)
    {
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    
    public static void main(String[] args)
    {
        System.out.println(longestPalindrome("abcdfdcbfdea"));
    }
}
