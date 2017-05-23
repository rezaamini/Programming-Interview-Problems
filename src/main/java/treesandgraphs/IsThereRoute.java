/*

   Given a directed graph, design an algorithm to find out whether there is
   a route between two nodes.
 
*/

package treesandgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Reza Amini
 */
public class IsThereRoute {
    // For tree
    // Perform a DFS traversal from 'start'. If you reach 'end', there is a rout.
    public static boolean search(TreeNode start, TreeNode end)
    {
        if(start == null)
            return false;
        
        if(end == null)
            return true;
        
        if(start.equals(end))
            return true;
        
        if(start.left == null && start.right == null)
            return false;
        
        Stack<TreeNode> stack = new Stack();
        stack.push(start);
        while(!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            if(temp.equals(end))
                return true;
            if(temp.left != null)
                stack.push(temp.left);
            if(temp.right != null)
                stack.push(temp.right);
        }  
        return false;
    }
    
    // For graph, we change the state of each node to 'VISITED' when it is seen.
    // Perform a DFS traversal from 'start'. If you reach 'end', there is a rout.
    public static boolean search(GraphNode start, GraphNode end)
    {
        if(start == null)
            return false;
        
        if(end == null)
            return true;
        
        if(start.equals(end))
            return true;
        
        if(start.adjacents.isEmpty())
            return false;
        
        Stack<GraphNode> stack = new Stack();
        stack.push(start);
        while(!stack.isEmpty())
        {
            GraphNode temp = stack.pop();
            temp.state = State.VISITED;
            if(temp.equals(end))
                return true;
            for(int i = 0 ; i < temp.adjacents.size(); i++)
            {
                GraphNode adj = (GraphNode)(temp.adjacents.get(i));
                if(adj.state != State.VISITED)
                    stack.push(adj);
            }
        }  
        return false;
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

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n5.left = n8;
        n5.right = n9;

        n7.left = n10;

        System.out.println(search(n1, n9));
        
        GraphNode gn1 = new GraphNode(1);
        GraphNode gn2 = new GraphNode(2);
        GraphNode gn3 = new GraphNode(3);
        GraphNode gn4 = new GraphNode(4);
        
        List<GraphNode> gn1Adj = new ArrayList();
        gn1Adj.add(gn2);
        gn1Adj.add(gn3);
        gn1.adjacents = gn1Adj;
        
        List<GraphNode> gn2Adj = new ArrayList();
        gn2Adj.add(gn3);
        gn2Adj.add(gn4);
        gn2.adjacents = gn2Adj;
        
        List<GraphNode> gn3Adj = new ArrayList();
        gn3Adj.add(gn1);
        gn3Adj.add(gn4);
        gn3.adjacents = gn3Adj;
        
        List<GraphNode> gn4Adj = new ArrayList();
        gn4.adjacents = gn4Adj;
        
        System.out.println(search(gn4, gn1));
        System.out.println(search(gn3, gn2));
        System.out.println(search(gn2, gn3));
    }
}

