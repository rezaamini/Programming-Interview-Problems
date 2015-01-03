/*

   You have two very large binary trees: T1, with millions of nodes, and T2 with 
   hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.

 */

package TreesAndGraphs;

/**
 *
 * @author Reza Amini
 */

/* 
   We could create a string representing the inorder and preorder traversals.
   If T2's preorder traversal is a substring of T1's preorder traversal,
   and T2's inorder traversal is a substring of T1's inorder traversal,
   then T2 is a substring of T1. We can check this using a suffix tree.
   However, we may hit memory limitations because suffix trees are extremely 
   memory intensive. 

   Alternative Approach: The treeMatch procedure visits each node in the 
   small tree at most once and is called no more than once per node of the 
   large tree. Worst case runtime is at most O(n * m), where n and m are the 
   sizes of trees T1 and T2, respectively. Worst case happens when all the nodes
   have same vales, so for all of them matchTree should be called. If k is the
   number of occurrences of T2's root in T1, the worst case runtime can be
   characterized as O(n + k * m).
*/

public class IsSubTree {
    public static boolean containsTree(TreeNode t1, TreeNode t2){
        if (t2 == null)
            return true; // null tree is subtree of all trees
        else
            return subTree(t1, t2);
    }

    public static boolean subTree(TreeNode t1, TreeNode t2){
        if (t1 == null)
            return false;
        if (t1.getValue() == t2.getValue()){
            if (matchTree(t1, t2))
                return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    public static boolean matchTree(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.getValue() != t2.getValue())
            return false;
        return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }
    
    public static StringBuilder generatePreorder(TreeNode t){
        StringBuilder output = new StringBuilder();
        if (t == null)
            return new StringBuilder("");

        output.append( " " ).append(t.getValue());
        output.append(generatePreorder(t.left));
        output.append(generatePreorder(t.right));

        return output;
    }

    public static StringBuilder generateInorder(TreeNode t){
        StringBuilder output = new StringBuilder();
        if (t == null)
            return new StringBuilder("");
        
        output.append(generateInorder(t.left));
        output.append( " " ).append(t.getValue());
        output.append(generateInorder(t.right));
        
        return output;
    }

    public static boolean containsTree_ver2(TreeNode t1, TreeNode t2){
        return generateInorder(t1).indexOf(generateInorder(t2).toString()) >= 0 &&
               generatePreorder(t1).indexOf(generatePreorder(t2).toString()) >= 0;
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

        System.out.println(containsTree(n8, n7));

        System.out.println(containsTree_ver2(n8, n7));
    }
}

