/*

   Given a matrix in which each row and each column is sorted, 
   write a method to find an element in it.

 */
package SortingAndSearching;

/**
 *
 * @author Reza Amini
 */
public class SearchInSortedMatrix {
    // Assume the matrix is m x n.
    public static boolean findElement(int[][] mat, int elem, int m, int n)
    {
        int row = 0;
        int col = n - 1;
        
        while(row < m && col >= 0)
        {
            if(mat[row][col] == elem)
                return true;
            else if (mat[row][col] < elem)
                row++;
            else 
                col--;
        }
        
        return false;
    }
    
    public static void main(String[] args) 
    {
        int[][] mat = {{1,  2,  3,  4 },
                       {5,  6,  7,  8 },
                       {9,  10, 11, 12},
                       {13, 14, 15, 16}};
        
        System.out.println(findElement(mat, 10, 4, 4));
    }
}
