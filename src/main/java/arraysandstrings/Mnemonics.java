/*
 
 Given a phone number in the form of an array of digits, determine all the 
 mnemonics for that phone number.
 Assume the mnemonics for all digits are given to you in a hash. Here is an 
 example of only one of the mnemonics for the phone number:
 215-5887 2155887 -> CALLTUR
 
 */
package arraysandstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Reza Amini
 */
public class Mnemonics
{
    Map<String, List<String>> cache; // used for dynamic programming
    Map<Integer, String> digitMnemonic;
    
    // Constructor
    public Mnemonics()
    {
        cache = new HashMap<>();
        // Create the one digit mnemonics to be passed as input to the algorithm
        digitMnemonic = new HashMap<>();
        digitMnemonic.put(0, "yz");
        digitMnemonic.put(1, "ab");
        digitMnemonic.put(2, "cd");
        digitMnemonic.put(3, "ef");
        digitMnemonic.put(4, "ghi");
        digitMnemonic.put(5, "jkl");
        digitMnemonic.put(6, "mno");
        digitMnemonic.put(7, "pqr");
        digitMnemonic.put(8, "stu");
        digitMnemonic.put(9, "vwx");
    }
    
    // Use recursion
    public List<String> getMnemonics(int[] number)
    {
        return getMnemonics(number, 0, number.length - 1);
    }
    
    public List<String> getMnemonics(int[] number, int start, int end)
    {
        List<String> result = new ArrayList<String>();
        String charMnemonics = digitMnemonic.get(number[start]);
        // If this is the last digit
        if(start == end)
        {
            for(int i = 0; i < charMnemonics.length(); i++)
                result.add(String.valueOf(charMnemonics.charAt(i)));
            return result;
        }
        
        // Look in the cache
        String cacheKey = getCacheKey(number, start, end);
        if(cache.containsKey(cacheKey))
            return cache.get(cacheKey);
        
        // If there are still other numbers after "start", recurse
        List<String> partialResult = getMnemonics(number, start + 1, end);
        for(int i = 0; i < charMnemonics.length(); i++)
        {
            String mnemonic = String.valueOf(charMnemonics.charAt(i));
            for(String s: partialResult)
                result.add(mnemonic + s);
        }
        // Cache the result for possible later use
        cache.put(cacheKey, result);
        return result;
    }
    
    public String getCacheKey(int[] number, int start, int end)
    {
        StringBuilder key = new StringBuilder();
        for(int i = start; i <= end; i++)
        {
            key.append(number[i]);
        }
        return key.toString();
    }
    
    public void printArrayList(List<String> arr)
    {
        for(String s: arr)
            System.out.println(s);
    }
            
    public static void main(String[] args)
    {
        Mnemonics test = new Mnemonics();
        int[] number = {9, 5, 4, 5, 9, 1, 0, 3, 6, 0};
        test.printArrayList(test.getMnemonics(number));
    }
}
