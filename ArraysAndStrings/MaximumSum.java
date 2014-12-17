
package ArraysAndStrings;

import java.util.Scanner;

/**
 * Find the maximum sum in a given array of integers.
 * 
 * @author Reza Amini
 */
public class MaximumSum
{
    // Time complexity: O(N)
    // Space complexity: O(1)
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        // Get array size
        int n = scan.nextInt();
        int[] array = new int[n];
        // Populate the array
        for(int i = 0; i < n; i++)
            array[i] = scan.nextInt();
        
        // Use 4 pointers: current start/end and result start/end
        int currentStartIndex = 0;
        int currentEndIndex = -1;
        int currentMax = 0;
        int startIndex = 0;
        int endIndex = -1;
        int globalMax = 0;
        for(int i = 0; i < n; i++)
        {
            // Add i-th element to the current sum if result is still positive
            if(currentMax + array[i] >= 0)
            {
                currentEndIndex = i;
                currentMax += array[i]; 
                if(currentMax > globalMax)
                {
                    startIndex = currentStartIndex;
                    endIndex = currentEndIndex;
                    globalMax = currentMax;
                }
            }
            else // If result is negative, start a new sum from next element
            {
                currentStartIndex = i + 1;
                currentEndIndex = -1;
                currentMax = 0;
            }
        }
        
        System.out.print("{");
        for(int i = startIndex; i <= endIndex; i++)
            System.out.print(array[i] + " ");
            
        System.out.println("\b}");        
    }
}
