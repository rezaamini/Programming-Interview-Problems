/*

   Design an algorithm and write code to find the first common ancestor of two 
   nodes in a binary tree. Avoid storing additional nodes in a data structure.
  
   NOTE: This is not necessarily a binary search tree.
 
*/

package treesandgraphs;

/**
 *
 * @author Reza Amini
 */
public class CommonAncestor {
    // Finds common ancestor of 'p' and 'q' assuming 'root' as the root of the tree
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
            return null;

        if(p == q && p == root)
            return root;
        
        if (p == q && (root.left == q || root.right == q))
            return root;

        int nodesOnLeft = covers(root.left, p, q);
        if (nodesOnLeft == 0) // both nodes on on right of root
        {
            if (root.right == p || root.right == q)
                return root;  
            else
                return commonAncestor(root.right, p, q);
        }
        else if (nodesOnLeft == 1) // one node is on left and other is on right of root
            return root;
        else // both nodes are on left of root
        {
            if (root.left == p || root.left == q)
                return root; 
            else
                return commonAncestor(root.left, p, q);
        }
    }
    
    // Counts how many of the p and q are under the 'root' subtree
    public static int covers(TreeNode root, TreeNode p, TreeNode q){
        int counter = 0;
        if (root == null)
            return 0;
        if (root == p || root == q)
            counter++;
        if (p == q && root == p)
            counter++;
        if (counter == 2)
            return counter;
        counter += covers(root.right, p, q);
        if (counter == 2)
            return counter;
        counter += covers(root.left, p, q);
        return counter;
    }
    
    // If p and q are both on the left of the node, branch left to look for the 
    // common ancestor. When p and q are not on the same side, we must have
    // found the common ancestor.
    public static TreeNode commonAncestor_ver2(TreeNode root, TreeNode p, TreeNode q){
        if(p == q && p == root)
            return root;
        if (covers_ver2(root.right, p) && covers_ver2(root.right, q))
        {
            if(p == q && root.right == p)
                return root;
            else if(root.right == p || root.right == q)
                return root;
            return commonAncestor_ver2(root.right, p, q);
        }
        if (covers_ver2(root.left, p) && covers_ver2(root.left, q))
        {
            if(p == q && root.left == p)
                return root;
            else if(root.left == p || root.left == q)
                return root;
            return commonAncestor_ver2(root.left, p, q);
        }
        return root;
    }

    // This method tells us if both p and q nodes are under root node. 
    // It touches every child node, so every single node in the tree must be 
    // touched at least once, and many nodes are touched multiple times.
    // So the complexity is higher than the previous solution.
    
    public static boolean covers_ver2(TreeNode root, TreeNode p){
        if (root == null)
            return false;
        if (root == p)
            return true;
        return covers_ver2(root.right, p) || covers_ver2(root.left, p);
    }
    
    public static int find(TreeNode root, TreeNode n1, TreeNode n2, NodeOut out)
    {
        if(root == null)
            return 0;
        int sum = 0;
        if(n1.getValue() == root.getValue())
            sum++;
        if(n2.getValue() == root.getValue())
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
    
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);

        n8.left = n4;
        n8.right = n12;
        n8.parent = null;

        n4.left = n2;
        n4.right = n6;
        n4.parent = n8;

        n2.left = n1;
        n2.right = n3;
        n2.parent = n4;

        n6.left = n5;
        n6.right = n7;
        n6.parent = n4;

        n1.parent = n2;
        n3.parent = n2;

        n5.parent = n6;
        n7.parent = n6;

        n12.left = n10;
        n12.right = n14;
        n12.parent = n8;

        n10.left = n9;
        n10.right = n11;
        n10.parent = n12;

        n14.left = n13;
        n14.right = n15;
        n14.parent = n12;

        n9.parent = n10;
        n11.parent = n10;

        n13.parent = n14;
        n15.parent = n14;

        System.out.println(commonAncestor(n8, n4, n4).getValue());
        System.out.println(commonAncestor(n8, n4, n12).getValue());
        System.out.println(commonAncestor(n8, n8, n4).getValue());
        System.out.println(commonAncestor(n8, n8, n8));
        System.out.println(commonAncestor(n8, n4, n2).getValue());
        System.out.println(commonAncestor(n8, n2, n1).getValue());
        System.out.println(commonAncestor(n8, n2, n6).getValue());
        System.out.println(commonAncestor(n8, n2, n10).getValue());
        
        System.out.println("------");
        
        System.out.println(commonAncestor_ver2(n8, n4, n4).getValue());
        System.out.println(commonAncestor_ver2(n8, n4, n12).getValue());
        System.out.println(commonAncestor_ver2(n8, n8, n4).getValue());
        System.out.println(commonAncestor_ver2(n8, n8, n8));
        System.out.println(commonAncestor_ver2(n8, n4, n2).getValue());
        System.out.println(commonAncestor_ver2(n8, n2, n1).getValue());
        System.out.println(commonAncestor_ver2(n8, n2, n6).getValue());
        System.out.println(commonAncestor_ver2(n8, n2, n10).getValue());
        
        System.out.println("------");
        
        NodeOut out = new NodeOut();
        find(n8, n4, n4, out);
        System.out.println(out.node.getValue());
        out = new NodeOut();
        find(n8, n4, n12, out);
        System.out.println(out.node.getValue());
        out = new NodeOut();
        find(n8, n8, n4, out);
        System.out.println(out.node.getValue());
        out = new NodeOut();
        find(n8, n8, n8, out);
        System.out.println(out.node.getValue());
        out = new NodeOut();
        find(n8, n4, n2, out);
        System.out.println(out.node.getValue());
        out = new NodeOut();
        find(n8, n2, n1, out);
        System.out.println(out.node.getValue());
        out = new NodeOut();
        find(n8, n2, n6, out);
        System.out.println(out.node.getValue());
        out = new NodeOut();
        find(n8, n2, n10, out);
        System.out.println(out.node.getValue());
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