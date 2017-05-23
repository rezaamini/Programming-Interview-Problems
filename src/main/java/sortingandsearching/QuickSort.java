/*

   Quick sort

 */

package sortingandsearching;

import java.util.Arrays;

/**
 *
 * @author Reza Amini
 */
public class QuickSort {
    
    // Average time complexity: O(n.log n)
    // Worst case time complexity: O(n^2)
    public static int partition(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        //Random r = new Random();
        //int pivot = r.nextInt(end - start + 1) + start;
        int pivot = arr[start + (end - start) / 2];
        System.out.println("Pivot: " + pivot);
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
                System.out.println("i=" + i + ", j=" + j + ", " + Arrays.toString(arr));
            }
            while (arr[j] > pivot) {
                j--;
                System.out.println("i=" + i + ", j=" + j + ", " + Arrays.toString(arr));
            }
            if (i <= j) {
                swap(arr, i, j);
                System.out.println("i=" + i + ", j=" + j + ", " + Arrays.toString(arr) + "<-");
                i++;
                j--;
            }
        }

        System.out.println("Partition: " + i);
        return i;
    }

    public static void quickSort(int[] arr, int start, int end) {
        int partition = partition(arr, start, end);
        if (start < partition - 1)
            quickSort(arr, start, partition - 1);
        if (partition < end)
            quickSort(arr, partition, end);
    }
    
    public static void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[(left + right) / 2];
            int i = left;
            int j = right;

            do {
                while (arr[i] < pivot) {
                    i++;
                }

                while (arr[j] > pivot) {
                    j++;
                }

                if (i <= j) {
                    swap(arr, i, j);
                    i++;
                    j--;
                }
            } while (i <= j);

            quickSort2(arr, left, j);
            quickSort2(arr, i, right);
        }
    }

    
    public static void main(String[] args)
    {
        //int[] arr = {6, 5, 8, 9, 1, 1, 1, 1, 0, 3, 10, 8, 0, 12, 2};
        int[] arr = {11, 5, 6, 12, 1, 10, 9, 13, 8 ,10, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
