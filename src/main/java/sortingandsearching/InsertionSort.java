/*

    Insertion sort

*/
package sortingandsearching;

import java.util.Arrays;

/**
 *
 * @author Reza Amini
 */
public class InsertionSort 
{
    // Time complexity: O(n^2)
    public static int[] insertionSort(int[] a)
    {
        for (int i = 1; i < a.length; i++)
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--)
                swap(a, j, j - 1); 
        return a;
    }
    
    public static void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static void main(String[] args)
    {
        int[] a = {6, 4, 7, 9 ,1 ,3 ,4, 0, 4, 1 , 54, 6, 1};
        System.out.println(Arrays.toString(insertionSort(a)));
    }
}
