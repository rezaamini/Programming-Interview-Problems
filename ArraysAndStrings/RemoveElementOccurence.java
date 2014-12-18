/*

 You have an array that may contain duplicate elements. 
 Given an element, write an algorithm that removes all the occurrences of that element.

*/

package ArraysAndStrings;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Reza Amini
 */
public class RemoveElementOccurence
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int target = scan.nextInt();
        int[] input = new int[n];
        for(int i = 0; i < n; i++)
            input[i] = scan.nextInt();
        
        int current = 0;
        int candidate = 0;
        
        while(candidate < n)
        {
            while(candidate < n && input[candidate] == target)
                candidate++;
            if(candidate >= n)
                break;
            if(input[current] == target )
            {
                // swap
                int temp = input[current];
                input[current] = input[candidate];
                input[candidate] = temp;
            }
            candidate++;
            current++;
        }
        
        for(int i = 0; i < current; i++)
        {
            System.out.print(input[i] + " ");
        }
    }
}
