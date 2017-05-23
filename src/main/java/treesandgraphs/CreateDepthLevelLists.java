/*

   Given a binary search tree, design an algorithm which creates a linked list
   of all the nodes at each depth (e.g., if you have a tree with depth D, you’ll
   have D linked lists).

*/
package treesandgraphs;

import java.util.LinkedList;
import java.util.ArrayList;


/**
 *
 * @author Reza Amini
 */
public class CreateDepthLevelLists {
    // We perform the same approach as in BFS, however, instead of using queue, 
    // we use list of nodes in previous depth level
    public static ArrayList<LinkedList<TreeNode>> createDepthLevelLists(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        int level = 0;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        result.add(level, list);

        while(true){
            list = new LinkedList<TreeNode>();
            for(int i = 0; i < result.get(level).size(); i++) 
            {
                TreeNode node = result.get(level).get(i);
                if (node != null)
                {
                    if (node.left != null)
                        list.add(node.left);
                    if (node.right != null)
                        list.add(node.right);
                }
            }

            if(list.size() > 0)
                result.add(++level, list);
            else
                break;
        }

        return result;
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

        n5.left = n2;
        n5.right = n7;

        n2.left = n1;
        n2.right = n3;

        n7.left = n6;
        n7.right = n8;

        n3.right = n4;

        n8.right = n9;

        ArrayList<LinkedList<TreeNode>> result = createDepthLevelLists(n5);

        for (int level = 0; level < result.size(); level++){
            for(int i = 0; i < result.get(level).size(); i++) {
                    System.out.print(result.get(level).get(i).getValue() + ", ");
            }
            System.out.println();
        }
    }
}