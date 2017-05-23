/*
 
   How would you efficiently return an array A[0, ..., h], where h is the height 
   of the tree and A[i] is the head of a linked list of all the nodes in the 
   tree that are at height i?

 */

package treesandgraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * @author Reza Amini
 */
public class TreeHeightHeads {
    // If you traverse the binary tree in BFS order, then you are guaranteed to 
    // hit all the nodes at the same depth consecutively. So, you can build the 
    // linked list of all the nodes as you discover them in BFS order. While 
    // traversing the tree, we also need to know when we move from nodes of 
    // depth k to nodes of depth k+1. This can be easily achieved by keeping 
    // track of the depth when inserting nodes in the queue.
    
    public static void main(String[] args)
    {
        VertexWithHeight[] vertices = {new VertexWithHeight("0"), 
            new VertexWithHeight("1"), 
            new VertexWithHeight("2"), 
            new VertexWithHeight("3"), 
            new VertexWithHeight("4"),
            new VertexWithHeight("5"), 
            new VertexWithHeight("6"), 
            new VertexWithHeight("7"),
            new VertexWithHeight("8"), 
            new VertexWithHeight("9"), 
            new VertexWithHeight("10")};

        int[][] adjMatrix = {
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}};

        GraphWithHeight graph = new GraphWithHeight(vertices, adjMatrix);
        ArrayList<LinkedList<VertexWithHeight>> heads = graph.bfs(vertices[0]);
        for(LinkedList<VertexWithHeight> head: heads)
        {
            Iterator itr = head.iterator();
            while(itr.hasNext())
                System.out.print(itr.next() + " ");
            System.out.println();
        }
    }
}

class VertexWithHeight 
{
    String label;
    boolean isVisited;
    int height;
    
    public VertexWithHeight(String label)
    {
        this.label = label;
        this.isVisited = false;
        this.height = -1;
    }
    
    public String toString()
    {
        return this.label;
    }
}

class GraphWithHeight
{
    VertexWithHeight[] vertices;
    int[][] adjMatrix;
    
    public GraphWithHeight(VertexWithHeight[] vertices, int[][] adjMatrix) {
        this.vertices = vertices;
        this.adjMatrix = adjMatrix;
    }
    
    public ArrayList<LinkedList<VertexWithHeight>> bfs(VertexWithHeight v)
    {
        int height = 0;
        ArrayList<LinkedList<VertexWithHeight>> heightHeads = new ArrayList();
        v.isVisited = true;
        v.height = 0;
        LinkedList<VertexWithHeight> heightHead = new LinkedList();
        heightHead.add(v);
        heightHeads.add(heightHead); 
        Queue<VertexWithHeight> q = new LinkedList();
        q.add(v);
        while(!q.isEmpty())
        {
            VertexWithHeight w = q.poll();
            ArrayList<VertexWithHeight> adjacents = getAdjacents(w);
            if (adjacents.size() > 0 && adjacents.get(0).height > height)
            {
                LinkedList<VertexWithHeight> head = new LinkedList();
                heightHeads.add(head);
                height++;
            }
            for (VertexWithHeight vwh: adjacents)
            {
                vwh.isVisited = true;
                heightHeads.get(height).add(vwh);
                q.add(vwh);
            }
        }
        
        return heightHeads;
    }
    
    public ArrayList<VertexWithHeight> getAdjacents(VertexWithHeight v)
    {
        // Find the vertex index in vertices
        int index = -1;
        for(int i = 0; i < vertices.length; i++)
        {
            if (vertices[i].label.equals(v.label))
            {
                index = i;
                break;
            }
        }
        
        ArrayList<VertexWithHeight> adjacents = new ArrayList(); 
        for (int j = 0; j < adjMatrix[index].length; j++)
            if (adjMatrix[index][j] == 1 && !vertices[j].isVisited)
            {
                vertices[j].height = v.height + 1; // update the heights
                adjacents.add(vertices[j]);
            }
        return adjacents;
    }
}

