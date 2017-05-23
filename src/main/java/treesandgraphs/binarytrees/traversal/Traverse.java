/*

    Implement different tree traversals:
    in-order, pre-order, post-order, BFS, DFS

*/
package treesandgraphs.binarytrees.traversal;

import treesandgraphs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Reza Amini
 */
public class Traverse {
    
    // BFS: print all nodes from left to right in each tree depth
    public static void BFS(TreeNode node)
    {
        if(node == null)
            return;
        if(node.left == null && node.right == null)
        {
            System.out.println(node.getValue());
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            System.out.print(temp.getValue() + " ");
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }
    
    // DFS: similar to pre-order
    public static void DFS(TreeNode node)
    {
        if(node == null)
            return;
        if(node.left == null && node.right == null)
        {
            System.out.println(node.getValue());
            return;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(node);
        while(!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            System.out.print(temp.getValue() + " ");
            if(temp.right != null)
                stack.add(temp.right);
            if(temp.left != null)
                stack.add(temp.left);
        }
    }
    
    public static void main(String[] args)
    {
        TreeNode n1 = new TreeNode(35);
        TreeNode n2 = new TreeNode(19);
        TreeNode n3 = new TreeNode(45);
        TreeNode n4 = new TreeNode(27);
        TreeNode n5 = new TreeNode(40);
        TreeNode n6 = new TreeNode(23);
        TreeNode n7 = new TreeNode(38);
        TreeNode n8 = new TreeNode(22);
        TreeNode n9 = new TreeNode(26);
        TreeNode n10 = new TreeNode(1);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(6);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(4);
        TreeNode n15 = new TreeNode(10);
        TreeNode n16 = new TreeNode(21);
        TreeNode n17 = new TreeNode(7);
        
        n1.left = n2; n1.right = n3;
        n2.right = n4;
        n3.left = n5; 
        n4.left = n6; 
        n5.left = n7;
        n6.left = n8; n6.right = n9;
        n8.left = n10;
        n10.right = n11;
        n11.left = n12; n11.right = n13;
        n12.left = n14; n12.right = n15;
        n13.right = n16;
        n15.left = n17;
        
        BFS(n1);
        System.out.println();
        //BFS_NonRecursive(n1);
        //System.out.println();
        DFS(n1);
        System.out.println();
        //DFS_NonRecursive(n1);
        //System.out.println();
    }
}
