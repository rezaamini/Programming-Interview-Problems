/*
   
   Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a 
   given node in a binary search tree where each node has a link to its parent.
  
   in-order: Traverse left node, current node, then right
 
*/

package treesandgraphs;

/**
 *
 * @author Reza Amini
 */
public class SuccessorInBST {
    public static TreeNode successor(TreeNode t){
        if (t == null)
            return null;

        // if the node has a right node, or if the node is the root,
        // left-most node of right subtree is the successor
        if(t.right != null || t.parent == null)
            return leftMostChild(t.right);

        // if the node does not have a right node, and it is the left node of
        // its parent, the parent is the successor
        if(t.parent.left == t)
            return t.parent;

        // if the node does not have a right node, and it is the right node of
        // its parent, we go up one level as long as the current node is
        // the left node of its parent
        TreeNode p = null;
        while((p = t.parent) != null){
            if (p.left == t)
                break;

            t = p;
        }

        return p;
    }

    public static TreeNode leftMostChild(TreeNode t){
        if (t == null)
            return null;

        while(t.left != null)
            t = t.left;

        return t;
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

        System.out.println(successor(n1).getValue());
        System.out.println(successor(n2).getValue());
        System.out.println(successor(n3).getValue());
        System.out.println(successor(n7).getValue());
    }
}