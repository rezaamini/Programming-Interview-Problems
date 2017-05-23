/*
    Count frequency of a give number in a sorted array.
 */
package sortingandsearching;

/**
 *
 * @author Reza Amini
 */
public class CountFrequencyInSortedArray
{
    // Use binary search to find the first and last occurrence.
    // Time complexity: O(log n)
    public static int findFreq(int [] arr, int q) 
    {
        int n = arr.length;
        // FInd first occurrene of q in array
        int start = 0;
        int end = n - 1;

        int firstOccurrence = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid] == q)
            {
                firstOccurrence = mid;
                end = mid - 1;
            }
            else if(arr[mid] > q)
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        // Find last occurrence of q in array
        start = firstOccurrence;
        end = n - 1;
        int lastOccurrence = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid] == q)
            {
                lastOccurrence = mid;
                start = mid + 1;
            }
            else if(arr[mid] > q)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return lastOccurrence - firstOccurrence + 1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {0, 1, 2, 3, 4, 4, 4, 4, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(findFreq(arr, 4));
    }
}
