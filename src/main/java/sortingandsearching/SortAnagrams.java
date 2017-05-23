/*

   Write a method to sort an array of strings so that all the anagrams 
   are next to each other.
   
 */
package sortingandsearching;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Reza Amini
 */
public class SortAnagrams {
    public static void main(String[] args) {
        String[] array = {"reza", "ali", "azer", "ial", "anoosheh", "oonasheh"};
        Arrays.sort(array, new AnagramComparator());
        
        for (String s: array) {
            System.out.print(s + "\t");
        }
    }
}

class AnagramComparator implements Comparator<String> {
 
    public String sortChars(String s) {
        char[] chars = s.toCharArray();
        
        Arrays.sort(chars);
        return new String(chars);
    }
    
    @Override
    public int compare(String o1, String o2) {
        return sortChars(o1).compareTo(sortChars(o2));
    }
}

