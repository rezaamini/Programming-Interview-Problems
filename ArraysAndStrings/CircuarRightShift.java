
package ArraysAndStrings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Implement circular right shift of size "shift" for an array of size n. 
 * 
 * @author Reza Amini
 */
public class CircuarRightShift
{
    // Time complexity: O(N)
    // Space complexity: O(1)
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int shift = scan.nextInt();
        shift = shift % n; // effective shift
        int[] input = new int[n];
        for(int i = 0; i < n; i++)
            input[i] = scan.nextInt();
        
        // Step 1: Reverse the whole array
        for(int i = 0; i < n / 2; i++)
            swap(input, i, n - i - 1);
        
        // Step 2: Reverse the first "shift" number of elements 
        for(int i = 0; i < shift / 2; i++)
            swap(input, i, shift - i - 1);
        
        // Step 3: Reverse the elements at the end of array
        for(int i = shift; i < (n + shift) / 2; i++)
            swap(input, i, n - i - 1 + shift);
        
        System.out.println(Arrays.toString(input));
    }
    
    public static void swap(int[] input, int i, int j)
    {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
