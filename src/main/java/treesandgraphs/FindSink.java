/*
 * Find the universal sink node in a graph, given a adjacency matrix
 */
package treesandgraphs;

/**
 *
 * @author Reza Amini
 */
public class FindSink
{
    // if node i is sink, all elements in row i are 0
    // if node i is sink, all elements in column i are 1, except a[i][i] = 0.
    // Time complexity: O(|V|)
    public int findSink(int[][] adj)
    {
        int i = 0;
        int j = 0;
        while(i < adj.length && j < adj[0].length)
        {
            if(adj[i][j] == 1)
                j++;
            else 
                i++;
        }
        if(i == adj.length)
            return -1;
        else 
        {
            // check the i'th row
            for(int k = 0; k < adj[i].length; k++)
                if(adj[i][k] == 1)
                    return -1;
        }
        return i; // the i'th node is the sink
    }
}
