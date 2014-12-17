
package ArraysAndStrings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author rezaamini
 */
public class RemoveExtraSpacesFromString
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        char[] input = scan.nextLine().toCharArray();
        char target = ' ';
        
        Set<Integer> toBeDeleted = findToBeDeleted(input);
        
        int n = input.length;
        int current = 0;
        int candidate = 0;
        
        while(candidate < n)
        {
            while(candidate < n && toBeDeleted.contains(candidate))
                candidate++;
            if(candidate >= n)
                break;
            if(toBeDeleted.contains(current))
            {
                // swap
                char temp = input[current];
                input[current] = input[candidate];
                input[candidate] = temp;
                toBeDeleted.add(candidate); // because we added an extra space there
            }
            candidate++;
            current++;
        }
        
        for(int i = 0; i < current; i++)
            System.out.print(input[i]);
        System.out.println();
    }
    
    public static Set<Integer> findToBeDeleted(char[] input)
    {
        int n = input.length;
        Set<Integer> toBeDeleted = new HashSet<Integer>();
        for(int i = 0; i < n; i++)
        {
            if(input[i] == ' ')
            {
                if(i == 0 || input[i - 1] == ' ')
                    toBeDeleted.add(i);
                
                if(i == n - 1)
                {
                    int j = i;
                    while(j > 0 && input[j] == ' ')
                    {
                        toBeDeleted.add(j);
                        j--;
                    }
                }
            }
        }
        return toBeDeleted;
    }
}
