/*

   Design an efficient algorithm that finds the index of the first occurrence of
   an element larger than a specified key k; return -1 if every element is less 
   than or equal to k.

 */

package SortingAndSearching;

/**
 *
 * @author Reza Amini
 */
public class FirstLargerInSortedArray {
    
    // Perform a binary search to find a number larger than the given one
    // Then perform another binary search to find the first occurrence of that
    // Time complexity: O(log n)
    public static int findFirstLarger(int[] arr, int k)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int firstOccurrence = Integer.MIN_VALUE;
        
        while( low <= high )
        {
            mid = low + (high - low) / 2;
            if ( k < arr[mid] )
            {
                firstOccurrence = mid;
                high = mid - 1;
            }
            else if ( k > arr[mid])
                low = mid + 1;
            else 
                low = mid + 1;
        }
        
        if (firstOccurrence != Integer.MIN_VALUE)
            return firstOccurrence;
        else
            return -1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {0, 1, 2, 3, 3, 3, 3, 9, 9, 9, 10, 11, 12, 13, 14, 15};
        
        System.out.println(findFirstLarger(arr, 3));
        System.out.println(findFirstLarger(arr, 9));
    }
}
