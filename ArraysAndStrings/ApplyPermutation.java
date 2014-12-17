package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*

You have two arrays, A and P of size n. Array A, contains arbitrary elements and 
P has all the indexes of A, arranged in an arbitrary order:
A = { a, b, c, d, e, f }
P = { 3, 0, 1, 2, 5, 4 }
We call P a permutation array for A. Applying P to A causes each element of A to 
be mapped to a new position indicated by the value of the corresponding P index.
In the example above, ‘a’ will be mapped to position 3 and ‘b’ to position 0:
P(A) = { b, c, d, a, f, e }
Write an algorithm that can apply a permutation to an array. You cannot use 
additional memory to copy elements of the array but you may use additional 
memory for book keeping purposes.

*/

/**
 *
 * @author Reza Amini
 */
public class ApplyPermutation
{
    // Swap the elements in the A until all elements are in correct position
    // Time complexity: O(N^2)
    // Space complexity: O(N)
    public static char[] applyPermutation_1(char[] A, int[] P)
    {
        int n = A.length;
        if(n != P.length)
            throw new IllegalArgumentException();
        
        Set<Integer> duplicateChecker = new HashSet<Integer>();
        for(int i = 0; i < n; i++)
        {
            if(P[i] < 0 || P[i] >= n)
                throw new IllegalArgumentException();
            if(!duplicateChecker.contains(P[i]))
                duplicateChecker.add(P[i]);
            else
                throw new IllegalArgumentException();
        }
        
        Set<Integer> indicies = new HashSet<Integer>();
        for(int i = 0; i < n; i++)
        {
            if(!indicies.contains(i))
            {
                indicies.add(i);
                int nextIndex = P[i];
                char currentChar = A[i];
                while(nextIndex != i)
                {
                    char temp = A[nextIndex];
                    A[nextIndex] = currentChar;
                    currentChar = temp;
                    indicies.add(nextIndex);
                    nextIndex = P[nextIndex];
                }
                A[nextIndex] = currentChar;
            }
        }
        return A;
    }
    
    // Sort P along with A.
    // Time complexity: O(N.logN)
    // Space complexity: O(1)
    public static char[] applyPermutation_2(char[] A, int[] P)
    {
        // Assume that both arrays have valid numbers or check them like above method
        quickSort(A, P, 0, P.length - 1);
        return A;
    }
    
    public static void quickSort(char[] A, int[] P, int start, int end)
    {
        int i = start;
        int j = end;
        int pivot = P[start + (end - start) / 2];
        while(i <= j)
        {
            while(P[i] < pivot)
                i++;
            
            while(P[j] > pivot)
                j--;
            
            if(i <= j)
            {
                int tempInt = P[i];
                char tempChar = A[i];
                P[i] = P[j];
                A[i] = A[j];
                P[j] = tempInt;
                A[j] = tempChar;
                i++;
                j--;
            }
        }
        if(start < j)
            quickSort(A, P, start, j);
        if(i < end)
            quickSort(A, P, i, end);
    }
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char[] A = new char[n];
        int[] P = new int[n];
        for(int i = 0; i < n; i++)
            A[i] = scan.next().charAt(0);
        for(int i = 0; i < n; i++)
            P[i] = scan.nextInt();
        
        // You cannot run both methods because when you call the first one, the 
        // original array A is modified. So, test them one by one by commenting 
        // the other method.
        
        //System.out.println(Arrays.toString(applyPermutation_1(A, P)));
        System.out.println(Arrays.toString(applyPermutation_2(A, P)));
    }
}

