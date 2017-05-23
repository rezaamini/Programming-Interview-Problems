/*

   Given an image represented by an NxN matrix, where each pixel in the image
   is 4 bytes, write a method to rotate the image by 90 degrees.
   
   Can you do this in place?
 
 */

package arraysandstrings;

import java.util.Scanner;

/**
 *
 * @author Reza Amini
 */
public class RotateMatrix {
    public static void main(String[] args) {
        System.out.println("Enter the matrix dimention: ");
        Scanner dimScanner = new Scanner(System.in);
        int dim = dimScanner.nextInt();

        System.out.println("Enter the matric elements row-by-row: ");
        int[][] mat = new int[dim][dim];
        for(int i = 0 ; i < dim ; i++) {
            Scanner matRowScanner = new Scanner(System.in);
            for(int j = 0 ; j < dim ; j++) {
                mat[i][j] = matRowScanner.nextInt();
            }
        }
        System.out.println();
        printMat(mat);
        System.out.println();
        mat = rotate90Deg(mat);
        printMat(mat);
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public static int[][] rotate90Deg(int[][] mat) {
        int n = mat.length - 1;

        for (int layer = 0 ; layer < mat.length / 2 ; layer++) {
            for (int j = layer ; j < n - layer ; j++) {
                // save left
                int temp = mat[n - j][layer];
                // bottom -> left
                mat[n - j][layer] = mat[n - layer][n - j];
                // right -> bottom
                mat[n - layer][n - j] = mat[j][n - layer];
                // top -> right
                mat[j][n - layer]= mat[layer][j];
                // left -> top
                mat[layer][j] = temp; 
            }
        }

        return mat;
    }
    
    public static void printMat(int[][] mat) {
        for(int i = 0 ; i < mat.length ; i++) {
            for(int j = 0 ; j < mat.length ; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
