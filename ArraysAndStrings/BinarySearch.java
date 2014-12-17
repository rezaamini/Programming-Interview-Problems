package ArraysAndStrings;

import java.util.Scanner;

/**
 * In a sorted array of distinct integers, find the index in which a[i] = i.
 * 
 * @author Reza Amini
 */
public class BinarySearch
{
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = scan.nextInt();
        
        //System.out.println(binarySearch(array));
        System.out.println(binarySearch_recursive(array, 0, array.length - 1));
    }
    
    // Time complexity: O(logN)
    // Space complexity: O(1)
    public static int binarySearch(int[] array)
    {
        int n = array.length;
        int start = 0;
        int end = n - 1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(array[mid] == mid)
                return mid;
            else if (array[mid] > mid)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        return -1;
    }
    
    // Use recursion
    // Time complexity: O(logN)
    // Space complexity: O(logN) because of recursion stack
    public static int binarySearch_recursive(int[] array, int start, int end)
    {
        int n = array.length;
        int mid = start + (end - start) / 2;
        if (start < 0 || end >= n || start > end) 
            return -1;
        
        if(array[mid] == mid)
            return mid;
        
        int result = binarySearch_recursive(array, start, Math.min(mid - 1, array[mid]));
        if (result > -1)
            return result;
        return binarySearch_recursive(array, Math.max(mid + 1, array[mid]), end);
    }
}
