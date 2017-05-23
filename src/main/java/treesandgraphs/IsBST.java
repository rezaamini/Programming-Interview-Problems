/*
 * come up with an algorithm that checks whether a tree is a binary search tree.
 */
package treesandgraphs;

/**
 *
 * @author rezaamini
 */
public class IsBST
{
    public boolean isBST(TreeNode root)
    {
        TreeNode lastVisited = new TreeNode(Integer.MIN_VALUE);
        return isBST(root, lastVisited);
    }
    
    public boolean isBST(TreeNode root, TreeNode lastVisited)
    {
        if(root.left == null && root.right == null)
        {
            if(root.value >= lastVisited.value)
            {
                lastVisited.value = root.value;
                return true;
            }
            else
                return false;
        }
        else if(root.left != null)
        {
            boolean isBST = isBST(root.left, lastVisited);
            if(!isBST || root.value < lastVisited.value)
                return false;
        }
        
        if(root.value >= lastVisited.value)
        {
            lastVisited.value = root.value;
            if(root.right != null)
            {
                boolean isBST = isBST(root.right, lastVisited);
                return isBST;
            }
            return true;
        }
        return false;
    }       
}
