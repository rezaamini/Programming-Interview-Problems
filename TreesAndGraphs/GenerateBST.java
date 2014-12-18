/*
 * Given an array, generate the most balanced binary search tree for that array.
 */
package TreesAndGraphs;

import java.util.Arrays;

/**
 *
 * @author rezaamini
 */
public class GenerateBST
{
    public TreeNode generateBSTFromArray(int[] input)
    {
        Arrays.sort(input);
        return generateBST_Recursive(input, 0, input.length - 1);
    }
    
    public TreeNode generateBST_Recursive(int[] input, int start, int end)
    {
        if(start == end)
            return new TreeNode(input[start]);
        
        if(start > end || start < 0 || end >= input.length)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(input[mid]);
        node.left = generateBST_Recursive(input, start, mid - 1);            
        node.right = generateBST_Recursive(input, mid + 1, end);
        return node;
    }
}

class TreeNode
{
    TreeNode left;
    TreeNode right;
    int value;
    
    public TreeNode(int value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}