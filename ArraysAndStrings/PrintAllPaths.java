/*
 
Given a m x n matrix, print all the paths from top-left corner to the 
bottom-right corner.
Eaxmple:

int[][] arr = int[5][5]

(0,0)->(0,1)->(0,2)->(0,3),(0,4)->(1,4)->(2,4)->(3,4)->(4,4)
(0,0)->(1,0)->(1,1)->(1,2)->(1,3)->(1,4)->(2,4)->(3,4)->(4,4)
...

*/

package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reza Amini
 */
public class PrintAllPaths
{
    public static List<String> getAllPaths(int[][] arr){
        List<String> pathList = new ArrayList<String>();
        getAllPaths(arr, 0, 0, "", pathList);
        return pathList;
    }
    
    public static void getAllPaths(int[][] arr, int i, int j, String path, List<String> pathList)
    {
        if( i >= arr.length || j >= arr[0].length) // wrong way
            return;
        
        path += String.format("(%d,%d)", i , j);
        if(i < arr.length - 1 || j < arr[0].length - 1)
            path += "->";
        if(i == arr.length - 1 && j == arr[0].length - 1) // end point
            pathList.add(path);
        
        getAllPaths(arr, i, j + 1 , path, pathList);
        getAllPaths(arr, i + 1, j, path, pathList);
    }
    
    public static void main(String[] args)
    {
        int[][] arr = new int[3][3];
        String path = "";
        List<String> result = getAllPaths(arr);
        for(String s: result)
            System.out.println(s);
    }

}