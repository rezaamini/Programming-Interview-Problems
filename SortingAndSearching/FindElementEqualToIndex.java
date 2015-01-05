/*

   Suppose that in addition to being sorted, the entries of A are distinct 
   integers. Design an efficient algorithm for finding an index i such that 
   A[i] = i, or indicating that no such index exists.

 */

package SortingAndSearching;

/**
 *
 * @author Reza Amini
 */
public class FindElementEqualToIndex {
    // Binary search
    public static int findIndex(int[] arr)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if (arr[mid] == mid)
                return mid;
            else if (arr[mid] > mid)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {-5, -4, -3, -2, 4, 8, 9, 10, 11, 12, 13, 14, 15};
        
        System.out.println(findIndex(arr));
    }
}
