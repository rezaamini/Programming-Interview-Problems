/*
 
 Multiply two large numbers given in two large arrays of positive integers.
 
*/

package arraysandstrings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Reza Amini
 */
public class Multiply
{
    // Time complexity: O(N^2)
    // Space complexity: O(1) for calculations and O(N) for output
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        // get length of first number
        System.out.println("Enter length of 1st number: ");
        int n1 = scan.nextInt();
        // get length of second number
        System.out.println("Enter length of 2nd number: ");
        int n2 = scan.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        // Populate arrays of numbers
        for(int i = 0; i < n1; i++)
            arr1[i] = scan.nextInt();
        for(int i = 0; i < n2; i++)
            arr2[i] = scan.nextInt();
        
        int[] result = new int[n1 + n2];
        for(int i = 0; i < n1; i++)
        {
            int index = i;
            int carry = 0;
            for(int j = 0; j < n2; j++)
            {
                // multiply and add to the result of previous loop traversal and carry
                int temp = result[index] + (arr1[i] * arr2[j]) + carry;
                // keep the remainder by 10 as the result
                result[index] = temp % 10;
                // keep the division by 10 as the carry
                carry = temp / 10;
                index++;
            }
            if(carry > 0)
                result[index] = carry;
        }
        
        for(int i = 0; i < n1 + n2; i++)
            System.out.println(result[i]);
        
        System.out.println();
    }
}
