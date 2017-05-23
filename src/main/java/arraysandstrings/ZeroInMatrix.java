/*

 Given a matrix of 0 and 1, for each 0 in the matrix, set all elements in that 
 row and column to 0.
 
*/
package arraysandstrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author rezaamini
 */
public class ZeroInMatrix
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                matrix[i][j] = scan.nextInt();
        
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(matrix[i][j] == 0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(Integer i: rows)
        {
            for(int j = 0; j < n; j++)
                matrix[i][j] = 0;
        }
        
        for(Integer j: cols)
        {
            for(int i = 0; i < m; i++)
                matrix[i][j] = 0;
        }
        
        for(int i = 0; i < m; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
