/*

   Quick sort

 */

package SortingAndSearching;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Reza Amini
 */
public class QuickSort {
    
    // Average time complexity: O(n.log n)
    // Worst case time complexity: O(n^2)
    public static void quickSort(int[] arr, int start, int end)
    {
        int i = start;
        int j = end;
        Random r = new Random();
        int pivot = r.nextInt(end - start + 1) + start;
        // int pivot = start + (end - start) / 2;
        while(i <= j)
        {
            while(arr[i] < arr[pivot])
                i++;
            while(arr[j] > arr[pivot])
                j--;
            if(i <= j)
            {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        
        if (start < i - 1) // i - 1 = j
            quickSort(arr, start, i - 1);
        if (i < end)
            quickSort(arr, i, end);
    }
    
    public static void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {6, 5, 8, 9, 1, 1, 1, 1, 0, 3, 10, 8, 0, 12, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
