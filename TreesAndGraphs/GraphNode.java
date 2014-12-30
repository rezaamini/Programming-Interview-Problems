/*
 
    Implement a graph node.

*/
package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reza Amini
 */
public class GraphNode<T>
{
    List<GraphNode> adjacents;
    State state;
    T value;

    public GraphNode(T v){
        value = v;
        adjacents = new ArrayList();
        state = State.Unvisited;
    }
    
    public GraphNode(T v, ArrayList adj){
        value = v;
        adjacents = adj;
        state = State.Unvisited;
    }
    
    public boolean equals(GraphNode node)
    {
        int n = node.adjacents.size();
        if(n != this.adjacents.size())
            return false;
        for(int i = 0; i < n; i++)
            if(!this.adjacents.contains(node.adjacents.get(i)))
                return false;
        return (value == node.value); 
    }
}
