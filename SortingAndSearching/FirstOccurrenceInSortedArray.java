/*

   Write a method that takes a sorted array A of integers and a key k and retuns 
   the index of first occurrence of k in A. Returns -l if k does not appear in A. 
   Write tests to verify your code.
   
   FOLLOW UP:
   Suppose you do not know the lengh of A in advance; accessing A[i] for i 
   beyond the end of the array throws an exception. Find the index of the first 
   occurrence in A of a specified key k; return -1 if k does not appear in A.

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
    
    // FOLLOW UP: if we do not know the length of array
    // We try to look for A[2^k] in the k-th step and catch exceptions for 
    // successive values of k till either we hit an exception or we hit a number 
    // greater than or equal to b. Then we do a binary search for b between 
    // indices 2^(k - 1) and 2^k . 
    // The runtime of the search algorithm is O(log n).
    public static int firstOccurence(int[] arr, int b)
    {
        int k = 0;
        // Find the index of a number (power of 2) larger than b in the array
        while(true)
        {
            try
            {
                int c = arr[(1 << k) - 1]; // -1 is because of 0-index arrays
                if (c >= b)
                    break;
                k++;
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                break;
            }
        }

        // binary search
        int low;
        if (k == 0)
            low = 0;
        else 
            low = 1 << (k - 1);
        
        int high = (1 << k) - 1;
        int mid;
        int firstOccurrence = -1;
        
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            try
            {
                if (arr[mid] > b)
                    high = mid - 1;
                else if (arr[mid] == b)
                {
                    firstOccurrence = mid;
                    high = mid - 1;
                }
                else 
                    low = mid + 1;
            }
            catch(ArrayIndexOutOfBoundsException ex)
            {
                high = mid - 1;
            }
        }
        
        if(firstOccurrence != -1)
            return firstOccurrence;
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {0, 1, 2, 3, 4, 4, 4, 4, 8, 9, 10, 11, 12, 13, 14, 15};
        
        System.out.println(binarySearch(arr, 4));
        System.out.println(binarySearch2(arr, 4));
        System.out.println(firstOccurence(arr, 4));
    }
}
