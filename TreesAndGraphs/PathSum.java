/*

   You are given a binary tree in which each node contains a value. Design an 
   algorithm to print all paths which sum up to that value. Note that it can be 
   any path in the tree - it does not have to start at the root. 

 */

package TreesAndGraphs;

import java.util.ArrayList;

/**
 *
 * @author Reza Amini
 */
public class PathSum {

    /*
     * Time complexity: O(n.log n)
     * If a node is at level r, we do r amount of work (that's in the looking 
     * "up" step). We can take a guess at O(n.log n) (n nodes, doing an average 
     * of log n amount of work on each step).
     */
    public static void findSum(TreeNode head, int sum,
            ArrayList<Integer> buffer, int currentLevel){
        if(head == null)
            return;

        int temp = sum;
        buffer.add(head.getValue());
        for(int i = currentLevel; i >-1; i--){
            temp -= buffer.get(i);
            if (temp == 0)
                print(buffer, i, currentLevel);
        }

        ArrayList<Integer> copy1 = (ArrayList<Integer>)buffer.clone();
        ArrayList<Integer> copy2 = (ArrayList<Integer>)buffer.clone();
        findSum(head.left, sum, copy1, currentLevel + 1);
        findSum(head.right, sum, copy2, currentLevel + 1);
    }

    public static void print(ArrayList<Integer> buffer, int level, int i){
        for(int j = level; j <= i; j++){
            System.out.print(buffer.get(j) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(-2);
        TreeNode n8 = new TreeNode(5);
        TreeNode n9 = new TreeNode(4);
        TreeNode n10 = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(9);
        TreeNode n13 = new TreeNode(8);
        TreeNode n14 = new TreeNode(1);
        TreeNode n15 = new TreeNode(5);
        
        n1.left = n2;
        n1.right = n3;
        n1.parent = null;

        n2.left = n4;
        n2.right = n5;
        n2.parent = n1;

        n3.left = n6;
        n3.right = n7;
        n3.parent = n1;

        n4.left = n8;
        n4.right = n9;
        n4.parent = n2;

        n5.left = n10;
        n5.right = n11;
        n5.parent = n2;

        n6.left = n12;
        n6.right = n13;
        n6.parent = n3;

        n7.left = n14;
        n7.right = n15;
        n7.parent = n3;

        n8.parent = n4;
        n9.parent = n4;

        n10.parent = n5;
        n11.parent = n5;

        n12.parent = n6;
        n13.parent = n6;

        n14.parent = n7;
        n15.parent = n7;
        
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        findSum(n1, 11, buffer, 0);
    }
}
