/*

 Imagine you have an n x n matrix of numbers; write an algorithm to print the  
 Matrix in a spiral order.
 
*/

package ArraysAndStrings;

/**
 *
 * @author Reza Amini
 */
public class SpiralTraversal
{
    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2, 3, 4}, 
                          {12, 13, 14, 5}, 
                          {11, 16, 15, 6}, 
                          {10, 9, 8, 7}};
        
        int[][] matrix1 = {{1, 2, 3, 4, 5}, 
                          {16, 17, 18, 19, 6}, 
                          {15, 24, 25, 20, 7}, 
                          {14, 23, 22, 21, 8},
                          {13, 12, 11, 10, 9}};
        
        int[][] matrix2 = {{1}};
        
        int[][] matrix3 = {{1, 2},
                           {4, 3}};
                           
        int[][] matrix4 = {{1, 2, 3}, 
                          {8, 9, 4}, 
                          {7, 6, 5}};
                          
        System.out.println(traverse(matrix));
        System.out.println(traverse(matrix1));
        System.out.println(traverse(matrix2));
        System.out.println(traverse(matrix3));
        System.out.println(traverse(matrix4));
    }
    
    public static String traverse(int[][] matrix)
    {
        int n = matrix.length;
        if(n == 1)
            return String.valueOf(matrix[0][0]);
        StringBuilder out = new StringBuilder();
        int row = 0;
        int col = 0;
        while(n > 0)
        {
            if(n == 1)
            {
                out.append(matrix[row][col]).append("-");
                break;
            }
            
            // got to right
            for(int i = 0; i < n - 1; i++)
            {
                out.append(matrix[row][col]).append("-");
                col++;
            }
            
            // got to buttom
            for(int i = 0; i < n - 1; i++)
            {
                out.append(matrix[row][col]).append("-");
                row++;
            }
            
            // got to left
            for(int i = 0; i < n - 1; i++)
            {
                out.append(matrix[row][col]).append("-");
                col--;
            }
            
            // got to top
            for(int i = 0; i < n - 1; i++)
            {
                out.append(matrix[row][col]).append("-");
                row--;
            }
            
            row++;
            col++;
            n -= 2;
        }
        out.setLength(out.length() - 1);
        return out.toString();
    }
}
