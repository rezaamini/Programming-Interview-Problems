/*

    Find common ancestor.

 */
package TreesAndGraphs;

/**
 *
 * @author Reza Amini
 */
public class FindCommonAncestor_2
{
    public static int find(TreeNode root, TreeNode n1, TreeNode n2, NodeOut out)
    {
        if(root == null)
            return 0;
        int sum = 0;
        if(n1.value == root.value)
            sum++;
        if(n2.value == root.value)
            sum++;
        if(root.left != null)
        {
            int left = find(root.left, n1, n2, out);
            sum += left;
        }
        if(root.right != null)
        {
            int right = find(root.right, n1, n2, out);
            sum += right;
        }
        if(sum == 2 && out.node == null)
            out.node = root;
        return sum;
    }
    
    public static void main(String[] args)
    {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        
        n1.left = n2;
        n1.right = n3;
        
        n2.left = n4;
        n2.right = n5;
        
        n3.right = n6;
        n5.right = n7;
        
        n6.left = n8;
        NodeOut out = new NodeOut();
        find(n1, n7, n4, out);
        System.out.println(out.node.value);
    }
}

class NodeOut
{
    TreeNode node;
    public NodeOut()
    {
        node = null;
    }
}