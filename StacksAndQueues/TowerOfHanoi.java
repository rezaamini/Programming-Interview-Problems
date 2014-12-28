/*

   Implement tower of Hanoi problem.
   # of towers = 3
   # of disks in each tower = 5

*/
package Stacks_And_Queues;

import java.util.Stack;

/**
 *
 * @author Reza Amini
 */
public class TowerOfHanoi {
    public static void main(String[] args)
    {
        // Create towers
        int n = 5;
        Tower[] towers = new Tower[3];
        for(int i = 0; i < 3; i++)
            towers[i] = new Tower(i);
        // Populate the first tower
        for(int i = n - 1; i >= 0; i--)    
            towers[0].add(i);
        // Move disks from first tower to the third tower
        towers[0].moveTo(n, towers[2], towers[1]);
    }
}

class Tower
{
    Stack<Integer> disks;
    int index;
    
    public Tower(int i)
    {
        disks = new Stack<Integer>();
        index = i;
    }
    
    public void add(int d)
    {
        if(disks.isEmpty() || disks.peek() > d)
        {
            disks.push(d);
        }
    }
    
    public void moveTopTo(Tower des)
    {
        if(!disks.isEmpty())
        {
            int top = disks.pop();
            des.add(top);
        }
    }
    
    // Moves n disks to the destination tower utilizing a tower as buffer
    // Use recursion
    public void moveTo(int n, Tower des, Tower buf)
    {
        if (n > 0)
        {
            moveTo(n - 1, buf, des);
            moveTopTo(des);
            buf.moveTo(n - 1, des, this);
        }
    }
}
