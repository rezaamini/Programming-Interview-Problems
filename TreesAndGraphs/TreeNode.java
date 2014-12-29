/*

    Implement a tree node

*/
package TreesAndGraphs;

/**
 *
 * @author Reza Amini
 */
public class TreeNode {
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    public State state;
    private int value;

    public TreeNode(int v){
        value = v;
        state = State.Unvisited;
    }

    public int getValue(){
        return value;
    }
}

enum State{
    Unvisited, Visited, Visiting;
}