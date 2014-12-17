/*

Implement the fill function of a paint program. Imagine a two dimensional 
array representing the screen. The element at the i-th row and j-th column
is represented by s[i][j] and is set to true if the corresponding cell on 
the screen has a color. Given a cell, s[i][j], color the area that bounds
that point.

*/

package ArraysAndStrings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Reza Amini
 */
public class Paint
{
    // Use recursion. Disadvantage: a single point is seen multiple times
    // Time complexity: O(N1.N2)
    // Space complexity: O(1) but we have the burden of recursion stack
    public void paint_Recursive(boolean[][] screen, int x, int y)
    {
        if(x < 0 ||
           x >= screen.length ||
           y < 0 ||
           y >= screen[0].length)
            return;
        
        if(screen[x][y] == true)
            return;
        
        screen[x][y] = true;
        paint_Recursive(screen, x, y + 1);
        paint_Recursive(screen, x, y - 1);
        paint_Recursive(screen, x + 1, y);
        paint_Recursive(screen, x - 1, y);
    }
    
    // Use a queue and add a point to the queue if it is not painted yet (similar to BFS)
    // Time complexity: O(N1.N2)
    // Space complexity: O(N1.N2)
    public void paint_NonRecursive(boolean[][] screen, int x, int y)
    {
        if(x < 0 ||
           x >= screen.length ||
           y < 0 ||
           y >= screen[0].length)
            return;
        
        // Deque and ArrayDeque are faster than Queue and Stack
        Deque<ArrayElement> queue = new ArrayDeque<ArrayElement>();
        
        if(screen[x][y] == false)
            queue.add(new ArrayElement(x, y));
        
        while(!queue.isEmpty())
        {
            ArrayElement element = queue.getFirst();
            screen[element.x][element.y] = true;
            
            // right
            if(element.x + 1 < screen.length && screen[element.x + 1][element.y] == false)
                queue.add(new ArrayElement(element.x + 1, element.y));
            
            // left
            if(element.x - 1 >= 0 && screen[element.x - 1][element.y] == false)
                queue.add(new ArrayElement(element.x - 1, element.y));
            
            // top
            if(element.y + 1 < screen[0].length && screen[element.x][element.y + 1] == false)
                queue.add(new ArrayElement(element.x, element.y + 1));
            
            // down
            if(element.y - 1 >= 0 && screen[element.x][element.y - 1] == false)
                queue.add(new ArrayElement(element.x, element.y - 1));
        }
    }
}

// This class represents an array element with a row (x) and a column (y)
class ArrayElement
{
    int x;
    int y;

    public ArrayElement(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
}
