/*
 
    Given a string, return the minimum number of characters to be inserted into
    it, in order to make it palindrome.

    This questions is the same as: 
    Given a string, return the minimum number of character changes needed, 
    in order to make it palindrome. Changes include remove, insert, and swap.

 */
package ArraysAndStrings;

/**
 *
 * @author Reza Amini
 */
public class MakePalindromeWithLeastInsert
{
    // Let the input string be str[l...h]. The problem can be broken down into 
    // three parts:
    // 1. Find the minimum number of insertions in the substring str[l+1...h]
    // 2. Find the minimum number of insertions in the substring str[l...h-1]
    // 3. Find the minimum number of insertions in the substring str[l+1...h-1]

    // Recursive Solution
    // The minimum number of insertions in the string str[l...h] is:
    // minInsertions(str[l+1...h-1]) if str[l] is equal to str[h], 
    // min(minInsertions(str[l...h-1]), minInsertions(str[l+1...h]))+1 otherwise
    public static int minInsertions(String s, int l, int h)
    {
        // Base case
        if(l == h)
            return 0;
        if(l == h - 1)
            return ((s.charAt(l) == s.charAt(h))? 0: 1);
        
        if(s.charAt(l) == s.charAt(h))
            return minInsertions(s, l + 1, h - 1); // str[l+1...h-1]
        return 1 + Math.min(minInsertions(s, l + 1, h), minInsertions(s, l, h - 1));
    }
    
    public static int minInsertions_DP(String s)
    {
        int n = s.length();
        // table[i][j] shows minumum number of insertions needed to convert 
        // str[i...j] to a palindrome
        int[][] table = new int[n][n];
        // Fill the table
        for(int gap = 1; gap < n; gap++)
        {
            for (int l = 0, h = gap; h < n; l++, h++)
            {
                table[l][h] = (s.charAt(l) == s.charAt(h))? table[l+1][h-1] :
                          (Math.min(table[l][h-1], table[l+1][h]) + 1);
            }
        }
        return table[0][n - 1];
    }
    
    public static void main(String[] args)
    {
        String s = "geeks";
        System.out.println(minInsertions(s, 0, s.length() - 1));
        System.out.println(minInsertions_DP(s));
    }
}
