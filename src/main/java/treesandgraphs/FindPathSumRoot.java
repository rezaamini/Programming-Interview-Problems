/*
 Imagine a binary tree in which each node contains an integer value. A path is a 
 continuous set of nodes in the tree that are all connected to each other.
 Write an algorithm that prints out all the paths, which start from the root and 
 sum up to a given value S.
 */
package treesandgraphs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rezaamini
 */
public class FindPathSumRoot
{
    public static List<List<TreeNode>> findPathSumRoot(int sum, TreeNode root)
    {
        List<List<TreeNode>> result = new ArrayList<>();
        
        if(root.value == sum)
        {
            List<TreeNode> path = new ArrayList<>();
            path.add(root);
            result.add(path);
        }
        
        if(root.left != null)
        {
            List<List<TreeNode>> leftResult = findPathSumRoot(sum - root.value, root.left);
            for(List<TreeNode> list: leftResult)
                list.add(root);
            result.addAll(leftResult);
        }
        
        if(root.right != null)
        {
            List<List<TreeNode>> rightResult = findPathSumRoot(sum - root.value, root.right);
            for(List<TreeNode> list: rightResult)
                list.add(root);
            result.addAll(rightResult);
        }
        
        return result;
    }
    
    // Now imagine that the paths can not only be started from the root but from 
    // any node in the tree. How would you solve this problem?
    
    // The simplest solution is to traverse the tree and run the above algorithm 
    // on each node. Since there are n nodes and the cost of the algorithm is 
    // O(n), this will lead us to O(n2). But this is a waste of time.
    
    
    // Average time O(n.log n), Maximum time O(n^2)
    public static List<List<TreeNode>> findPathSumAnyNode(int sum, TreeNode root)
    {
        List<List<TreeNode>> result = new ArrayList<>();
        List<TreeNode> parents = new ArrayList<>();
        findPathSumAnyNode(sum, root, result, parents);
        return result;
    }
    
    private static void findPathSumAnyNode(int sum, TreeNode root, 
            List<List<TreeNode>> result, List<TreeNode> parents)
    {
        if(root.value == sum)
        {
            List<TreeNode> single = new ArrayList<>();
            single.add(root);
            result.add(single);
        }
        
        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        int currentSum = root.value;
        for(TreeNode node: parents)
        {
            path.add(node);
            currentSum += node.value;
            if(currentSum == sum)
            {
                List<TreeNode> currentPath = new ArrayList<>();
                currentPath.addAll(path);
                result.add(currentPath);
            }
        }
        
        if(root.left != null)
        {
            parents.add(0, root);
            findPathSumAnyNode(sum, root.left, result, parents);
            parents.remove(0);
        }
        
        if(root.right != null)
        {
            parents.add(0, root);
            findPathSumAnyNode(sum, root.right, result, parents);
            parents.remove(0);
        }
    }
    
    public static void main(String[] args)
    {
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(10);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.right = n7;
        n6.left = n8;
        n7.left = n9;
        
        List<List<TreeNode>> result = findPathSumAnyNode(12, n1);
        for(List path: result)
        {
            for(Object n: path)
                System.out.print(((TreeNode)n).value + " ");
            System.out.println();
        }
    }
}
