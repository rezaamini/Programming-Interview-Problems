/*

   In the classic problem of the Towers of Hanoi, you have 3 rods and N disks
   of different sizes which can slide onto any tower. The puzzle starts with
   disks sorted in ascending order of size from top to bottom (e.g., each disk
   sits on top of an larger one). You have the following constraints:
   (A) Only one disk can be moved at a time.
   (B) A disk is slid off the top of one rod onto the next rod.
   (C) A disk can only be placed on top of a larger disk.
   Write a program to move the disks from the first rod to the last using Stacks.
 
*/
package StacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author Reza Amini
 */
public class TowerOfHanoi {
    @Test
    public void testTowerOfHanoi() {
        // Create towers
        int n = 10;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        // Populate the first tower
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        // Move disks from first tower to the third tower
        towers[0].moveTo(n, towers[2], towers[1]);

        for (int i = 0; i < n - 2; i++) {
            Assert.assertTrue(towers[2].disks.get(i) > towers[2].disks.get(i + 1));
        }
    }

    public static void tower(int numberOfDisks, int source, int auxiliary, int destination) {
        if (numberOfDisks == 0) {
            return;
        }

        tower(numberOfDisks - 1, source, destination, auxiliary);
        System.out.println("Move from " + source + " to " + destination);
        tower(numberOfDisks - 1, auxiliary, source, destination);
    }

    @Test
    public void testTower() {
        tower(4, 1, 2, 3);
    }
}

class Tower {
    Stack<Integer> disks;
    int index;

    public Tower(int i) {
        disks = new Stack<>();
        index = i;
    }

    public void add(int d) {
        if (disks.isEmpty() || disks.peek() > d) {
            disks.push(d);
        }
    }

    public void moveTopTo(Tower des) {
        if (!disks.isEmpty()) {
            int top = disks.pop();
            des.add(top);
        }
    }

    // Moves n disks to the destination tower utilizing a tower as buffer
    // Use recursion
    // Time complexity: O(n)
    public void moveTo(int n, Tower des, Tower buf) {
        if (n > 0) {
            moveTo(n - 1, buf, des);
            moveTopTo(des);
            buf.moveTo(n - 1, des, this);
        }
    }
}
