/*
 
 Implement a partition method which puts all integer elements larger than a 
 given pivot after the pivot and puts elements smaller than pivot before it;
 Make sure you keep the elements equal to pivot beside pivot.
 
*/

package ArraysAndStrings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Reza Amini
 */
public class Partition
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        // get length of input array
        System.out.println("Enter array length: ");
        int n = scan.nextInt();
        // get pivot
        System.out.println("Enter pivot index: ");
        int pivotIndex = scan.nextInt();
        int[] array = new int[n];
        // get the input array
        System.out.println("Enter array elements: ");
        for(int i = 0; i < n; i++)
            array[i] = scan.nextInt();
        
        partition(array, array[pivotIndex]);
        System.out.println(Arrays.toString(array));
    }
    
    public static void partition(int[] array, int pivot)
    {
        int n = array.length;
        int smaller = 0;
        int equal = 0;
        int larger = n - 1;
        while(equal <= larger)
        {
            if(array[equal] < pivot)
            {
                swap(array, equal, smaller);
                equal++;
                smaller++;
            }
            else if(array[equal] == pivot)
            {
                equal++;
            }
            else // array[equal] > pivot
            {
                swap(array, equal, larger);
                larger--;
            }
        }
    }
    
    public static void swap(int[] array, int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
