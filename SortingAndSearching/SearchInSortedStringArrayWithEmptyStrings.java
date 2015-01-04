/*

   Given a sorted array of strings which is interspersed with empty strings, 
   write a method to find the location of a given string. 
   
   Example: find "ball" in ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] 
   will return 4.
   
   Example: find "ballcar" in ["at", "", "", "", "", "ball", "car", "", "", "dad", "", ""] 
   will return -1.

 */
package SortingAndSearching;

/**
 *
 * @author Reza Amini
 */
public class SearchInSortedStringArrayWithEmptyStrings {
    // Use ordinary binary search, but when you hit an empty string, 
    // advance to the next non-empty string; if there is no next non-empty 
    // string, search the left half.
    public static int search(String[] strings, String str, int first, int last) 
    {
        while(first <= last)
        {
            // Ensure there is something at the end
            while(first <= last && strings[last].equals(""))
                last--;
            if (first > last)
                return -1;
            
            int mid = first + (last - first) / 2;
            while (strings[mid].equals(""))
                mid++;
            
            int r = strings[mid].compareTo(str);
            if (r == 0)
                return mid;
            else if (r < 0)
                first = mid + 1;
            else 
                last = mid - 1;
        }
        return -1;
    }
    
    public static int search(String[] strings, String str) 
    {
        if (strings == null || str == null)
            return -1;
        if (str.equals(""))
            for (int i = 0; i < strings.length; i++)
                if (strings[i].equals(""))
                    return i;
        return search(strings, str, 0, strings.length - 1);
    }
    
    public static void main(String[] args)
    {
        String[] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(search(strings, "ball"));
    }
}
