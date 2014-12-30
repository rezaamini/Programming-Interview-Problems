/*

   Implement a function to check if a tree is balanced.
   For the purposes of this question, a balanced tree is defined to be a tree
   such that no two leaf nodes differ in distance from the root by more than one.
 
*/

package TreesAndGraphs;

/**
 * @author Reza Amini
 */
public class IsTreeBalanced {
    public static int maxDepth(TreeNode root){
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }

    public static int minDepth(TreeNode root){
        if (root == null)
            return 0;

        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }

    public static boolean isBalanced(TreeNode root){
        return (maxDepth(root) - minDepth(root) <= 1);
    }
}
