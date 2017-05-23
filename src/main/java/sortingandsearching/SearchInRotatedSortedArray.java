/*

   Given a sorted array of n integers that has been rotated an unknown number 
   of times, give an O(log n) algorithm that finds an element in the array. 
   You may assume that the array was originally sorted in increasing order.
   EXAMPLE:
   Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
   Output: 8 (the index of 5 in the array)
   
 */
package sortingandsearching;

/**
 *
 * @author Reza Amini
 */
public class SearchInRotatedSortedArray {
    // We can do this with a modification of binary search
    // If array has duplicate entries then we can't do better than O(n).
    public static int search(int[] a, int x, int lower, int upper) 
    {
        while (lower <= upper)
        {
            int m = lower + (upper - lower) / 2;
            if (x == a[m])
                return m;
            else if (a[lower] <= a[m])
            {
                if (x > a[m])
                    lower = m + 1;
                else if (x >= a[lower])
                    upper = m - 1;
                else 
                    lower = m + 1;
            }
            else if (x < a[m])
                upper = m - 1;
            else if (x < a[upper])
                lower = m + 1;
            else 
                upper = m - 1;
        }
        return -1; 
    }
    
    public static void main(String[] args)
    {
        int[] a = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(search(a, 19, 0, a.length - 1));
    }
}
