/*

    Implement a tree node

*/
package treesandgraphs;

/**
 *
 * @author Reza Amini
 */
public class TreeNode {
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    public State state;
    public int value;

    public TreeNode(int v){
        value = v;
        state = State.NOT_VISITED;
    }

    public int getValue(){
        return value;
    }
}

