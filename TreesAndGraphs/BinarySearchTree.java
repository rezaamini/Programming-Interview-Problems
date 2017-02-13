/*
 
 Implement a binary search tree.
 
*/

package TreesAndGraphs;

/**
 *
 * @author Reza Amini
 */
public class BinarySearchTree
{
    int value;
    BinarySearchTree left;
    BinarySearchTree right;
    State state;

    private enum State
    {
        VISITED, UNVISITED, VISITING;
    }
    
    public BinarySearchTree(int value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
        this.state = State.UNVISITED;
    }
    
    public BinarySearchTree search(BinarySearchTree root, int x)
    {
        if(root == null)
            return null;
        
        if(root.value == x)
            return root;
        else if(root.value < x)
            return search(root.right, x);
        else 
            return search(root.left, x);
    }
    
    // Insert a node with value x to a node named "node" with parent named "parent"
    public void insert(BinarySearchTree node, BinarySearchTree parent, int x)
    {
        if(node == null)
        {
            if(parent == null)
                throw new IllegalStateException();
            if(parent.value > x)
                parent.left = new BinarySearchTree(x);
            else
                parent.right = new BinarySearchTree(x);
        }
        else if (node.value == x) // if we are dealing with duplicates
        {
            BinarySearchTree left = node.left;
            node.left = new BinarySearchTree(x);
            node.left.left = left;
        }
        else if (node.value > x)
        {
            insert(node.left, node, x);
        }
        else
        {
            insert(node.right, node, x);
        }
    }
    
    public BinarySearchTree delete(BinarySearchTree node, int x)
    {
        if(node == null)
            return null;
        if(node.value == x)
            return delete(node, null);
        else if (node.left != null && node.left.value == x)
            return delete(node.left, node);
        else if (node.right != null && node.right.value == x)
            return delete(node.right, node);
        else if (node.value > x)
            return delete(node.left, x);
        else
            return delete(node.right, x);
    }
    
    public BinarySearchTree delete(BinarySearchTree node, BinarySearchTree parent)
    {
        if(node.left == null && node.right == null)
        {
            if(parent == null)
                return null;
            if(parent.left == node)
                parent.left = null;
            else // parent.right == node
                parent.right = null;
            return parent;
        }
        else if (node.left == null)
        {
            if(parent == null)
                return node.right;
            if(parent.left == node)
                parent.left = node.right;
            else // parent.right == node 
                parent.right = node.right;
            return parent;
        }
        else if (node.right == null)
        {
            if(parent == null)
                return node.left;
            if(parent.left == node)
                parent.left = node.left;
            else // parent.right == node
                parent.right = node.left;
            return parent;
        }
        else 
        {
            BinarySearchTree leftMost = node.right;
            BinarySearchTree leftMostParent = node;
            while(leftMost.left != null)
            {
                leftMostParent = leftMost;
                leftMost = leftMost.left;
            }
            if(leftMost.right != null)
                leftMostParent.left = leftMost.right;
            else 
                leftMostParent.left = null;
            
            if(parent == null)
            {
                leftMost.left = node.left;
                leftMost.right = node.right;
                return leftMost;
            }
            
            if(parent.left == node)
                parent.left = leftMost;
            else
                parent.right = leftMost;
            return parent;
        }
    }
    
}
