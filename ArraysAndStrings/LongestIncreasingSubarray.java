
package ArraysAndStrings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Find the longest increasing sub array in a given array of integers.
 * 
 * @author Reza Amini
 */
public class LongestIncreasingSubarray
{
    // Use 4 pointers: current start, current end, result start, result end
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        // Get number of elements in the array
        int n = scan.nextInt(); 
        int[] array= new int[n];
        // Populate the array
        for(int i = 0; i < n; i++)
            array[i] = scan.nextInt();
        // Single-element array
        if(n == 1)
        {
            System.out.println(array[0]);
            System.exit(0);
        }
        
        int currentStart = 0;
        int currentEnd = 0;
        int globalStart = currentStart;
        int globalEnd = currentEnd;
        for(int i = 1; i < n; i++)
        {
            if(array[i] > array[i - 1])
            {
                currentEnd = i;
                if(currentEnd - currentStart + 1 > globalEnd - globalStart + 1)
                {
                    globalStart = currentStart;
                    globalEnd = currentEnd;
                }
            }
            else
            {
                if(i + globalEnd - globalStart + 1 > n - 1)
                    break;
                // Make sure the new current start can result to a longer sequence
                while(array[i + globalEnd - globalStart + 1] <= array[i])
                {
                    if(i + globalEnd - globalStart + 1 > n - 1)
                        break;
                    i++;
                }
                   
                if(i + globalEnd - globalStart + 1 > n - 1)
                    break;
                
                currentStart = i;
            }
        }
        
        for(int i = globalStart; i <= globalEnd; i++)
            System.out.print(array[i] + " ");
        
        System.out.println();
    }   
}
