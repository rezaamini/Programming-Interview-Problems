/*

   Write a method that takes a sorted array A of integers and a key k and retuns 
   the index of first occurrence of k in A. Returns -l if k does not appear in A. 
   Write tests to verify your code.

 */

package SortingAndSearching;

/**
 *
 * @author Reza Amini
 */
public class FirstOccurrenceInSortedArray {
    // Binary search, receives a sorted array as input and returns the index
    // Then we perform a linear search to find the first occurrence
    // Time complexity: Theta(n)
    public static int binarySearch(int[] arr, int k)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid; 
        
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if (arr[mid] < k)
                low = mid + 1;
            else if (arr[mid] == k)
            {
                while (arr[mid] == k) // linear search
                    mid--;
                return (mid + 1);
            }
            else 
                high = mid - 1;
        }
        
        return -1;
    }
    
    // Binary search, receives a sorted array as input and returns the index
    // Then we perform another binary search to find the first occurrance
    // Time complexity: O(log n)
    public static int binarySearch2(int[] arr, int k)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid; 
        int firstOccurrence = Integer.MIN_VALUE;
        
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if (arr[mid] < k)
                low = mid + 1;
            else if (arr[mid] == k)
            {
                firstOccurrence = mid;
                high =  mid - 1;
            }
            else 
                high = mid - 1;
        }
        
        if (firstOccurrence != Integer.MIN_VALUE)
            return firstOccurrence;
        else 
            return -1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {0, 1, 2, 3, 4, 4, 4, 4, 8, 9, 10, 11, 12, 13, 14, 15};
        
        System.out.println(binarySearch(arr, 4));
        System.out.println(binarySearch2(arr, 4));
    }
}
