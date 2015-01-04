package SortingAndSearching;

import java.util.Arrays;

/**
 *
 * @author Reza Amini
 */
public class BubbleSort {
    // Time complexity: O(n^2)
    public static void bubbleSort(int[] a)
    {
        int n = a.length;
        for(int i = 0; i < n; i++)
        {
            boolean swapped = false;
            for(int j = n - 1; j > i; j--)
            {
                if(a[j] < a[j - 1])
                {
                    swap(a, j, j - 1);
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }
    
    // Time complexity: O(n^2)
    public static void bubbleSort1(int[] a)
    {
        int n = a.length;
        boolean swapped;
        do
        {
            swapped = false;
            for(int i = 0; i < n - 1; i++)
            {
                if(a[i + 1] < a[i])
                {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }
        }while(swapped);
    }
    
    public static void swap(int[] a, int b, int c)
    {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
    
    public static void main(String[] args)
    {
        int[] a = {6, 4, 7, 9 ,1 ,3 ,4, 0, 4, 1 , 54, 6, 1};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
        int[] b = {296, 319, 346, 324, 303, 286, 306, 283, 360, 318, 351, 308, 348, 298, 366};
        bubbleSort1(b);
        System.out.println(Arrays.toString(b));
    }
}
