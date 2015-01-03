/*

   Consider a black and white digitized image of a maze - white pixels represent
   open areas and black spaces are walls. There are two special pixels: one is 
   designated the entrance and the other is the exit. 
   
   Given a two-dimensional matrix of black and white entries representing a maze 
   with designated entrance and exit points, find a path from the entrance to 
   the exit, if one exists.

 */

package TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Reza Amini
 */
public class Maze {
    // Model the maze as an undirected graph. Each vertex corresponds to a white 
    // pixel. We will index the vertices based on the coordinates of the 
    // corresponding pixel; so, vertex (i, j) corresponds to the matrix entry 
    // (i, j). Edges model adjacent pixels; so Vi,j is connected to vertices 
    // Vi+1,j, Vi,j+1, Vi-1,j, and Vi,j-1, assuming these vertices exist- vertex
    // Va,b does not exist if the corresponding pixel is black or the 
    // coordinates (a, b) lie outside the image.
    // Now, run a DFS starting from the vertex corresponding to the entrance. If 
    // at some point, we discover the exit vertex in the DFS, then there exists 
    // a path from the entrance to the exit. If we implement recursive DFS then 
    // the path would consist of all the vertices in the call stack 
    // corresponding to previous recursive calls to the DFS routine. This 
    // problem can also be solved using BFS from the entrance vertex on the same 
    // graph model. The BFS tree has the property that the computed path will be 
    // a shortest path from the entrance. 
    
    public static void main(String[] args)
    {
        Vertex[] vertices = {new Vertex("0", "W"), new Vertex("1", "W"), 
            new Vertex("2", "W"), new Vertex("3", "W"), new Vertex("4", "B"), 
            new Vertex("5", "W"), new Vertex("6", "B"), new Vertex("7", "B"), 
            new Vertex("8", "B"), new Vertex("9", "W"), new Vertex("10", "W"), 
            new Vertex("11", "W"), new Vertex("12", "B"), new Vertex("13", "B"), 
            new Vertex("14", "B"), new Vertex("15", "W")};

        int[][] adjMatrix = {
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        };

        Graph graph = new Graph(vertices, adjMatrix);
        graph.dfs(vertices[10], vertices[2]);
    }  
}

class Vertex
{
    String label;
    String type;
    boolean isVisited;
    
    public Vertex(String label, String type)
    {
        this.label = label;
        this.type = type;
        this.isVisited = false;
    }
}

class Graph
{
    Vertex[] vertices;
    int[][] adjMatrix;
    
    
    public Graph(Vertex[] vertices, int[][] adjMatrix)
    {
        this.vertices = vertices;
        this.adjMatrix = adjMatrix;
    }
    
    public void printVertex(Vertex v)
    {
        System.out.println(v.label);
    }
    
    // Finds the next unvisited white adjacent of v
    public int getOneAdjacentUnvisitedVertex(Vertex v)
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
        // Find next unvisited white adjacent of v
        for (int j = 0; j < adjMatrix[index].length; j++)
        {
            if (adjMatrix[index][j] == 1 && 
                    !vertices[j].isVisited && vertices[j].type.equals("W"))
                return j;
        }
        
        return -1;
    }
    
    public void dfs(Vertex from, Vertex to)
    {
        // Find the vertex index in vertices
        int fromIndex = -1;
        int toIndex = -1;
        for(int i = 0; i < vertices.length; i++)
        {
            if (vertices[i].label.equals(from.label))
                fromIndex = i;
            if (vertices[i].label.equals(to.label))
                toIndex = i;
            if(fromIndex > -1 && toIndex > -1)
                break;
        }
        Deque<Vertex> stack = new ArrayDeque();
        vertices[fromIndex].isVisited = true;
        stack.push(vertices[fromIndex]);
        
        while(!stack.isEmpty())
        {
            int v = getOneAdjacentUnvisitedVertex(stack.peek());
            if (v == -1)
                stack.pop();
            else 
            {
                vertices[v].isVisited = true;
                stack.push(vertices[v]);
                if(vertices[v].label.equals(vertices[toIndex].label))
                    break;
            }
        }
        
        // What remains in the stack is the result path
        if(stack.peek().label.equals(vertices[toIndex].label))
        {
            while(!stack.isEmpty())
                printVertex(stack.pop());
        }
    }
}