/*
 Given a search string s and another string t, write an algorithm that returns 
 the index of the first occurrence of s in t, if any at all.
 */
package ArraysAndStrings;

import java.util.Scanner;

/**
 *
 * @author rezaamini
 */
public class SearchStringInString
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String t = scan.nextLine();
        System.out.println(search(s, t));
    }
    
    public static int search(String s, String t)
    {
        int n = t.length();
        int m = s.length();
        double hash = hash(s, 0, m - 1);
        double tempHash = hash(t, 0, m - 1);
        int i;
        for(i = 0; i < n - m; i++)
        {
            if(hash == tempHash && isEqual(s, t, i, i + m - 1))
                return i;
            tempHash = rollingHash(t, tempHash, i + m, i, m);
        }
        if(hash == tempHash && isEqual(s, t, i, i + m - 1))
            return i;
        return -1;
    }
    
    public static double hash(String str, int start, int end)
    {
        double hash = 0;
        int power = end - start;
        for(int i = start; i <= end; i++)
        {
            char c = str.charAt(i);
            hash += Math.pow(7, power) * c;
            power--;
        }
        return hash;
    }
    
    public static double rollingHash(String str, double lastHash, int addIndex, 
            int removeIndex, int length)
    {
        char remove = str.charAt(removeIndex);
        char add = str.charAt(addIndex);
        double hash = lastHash - remove * Math.pow(7, length - 1);
        hash *= 7;
        hash += add;
        return hash;
    }
    
    public static boolean isEqual(String s, String t, int start, int end)
    {
        for(int i = 0; i <= end - start; i++)
            if(s.charAt(i) != t.charAt(i + start))
                return false;
        
        return true;
    }
}
