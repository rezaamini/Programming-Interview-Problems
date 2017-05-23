/*

    Merge sort

*/
package sortingandsearching;

import java.util.Arrays;

/**
 *
 * @author Reza Amini
 */
public class MergeSort {
    // Time complexity (average and worst case): O(n.log n)
    public static void mergeSort(int[] a, int i, int j)
    {
        if(i == j) return;
        int mid = i + (j - i) / 2;
        mergeSort(a, i, mid);
        mergeSort(a, mid + 1, j);
        
        // Merge
        int l = mid - i + 1;
        int[] temp = new int[l];
        System.arraycopy(a, i, temp, 0, l); // Make a copy of the lest side
        int index1 = 0; // pointer for temp (copy of left side)
        int index2 = mid + 1; // pointer for right array
        int index3 = i; // pointer for original array (output)
        while(index1 <= mid - i && index2 <= j)
            a[index3++]=(a[index2] < temp[index1])? a[index2++]: temp[index1++]; 
        while(index1 <= mid - i)
            a[index3++] = temp[index1++];
    }
    
    public static void main(String[] args)
    {
        int[] a = {6, 4, 7, 9 ,1 ,3 ,4, 0, 4, 1 , 54, 6, 1};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
