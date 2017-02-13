/*
 You are given a two dimensional matrix representing a maze. Element (i, j), 
 i-th row and j-th column of this matrix has one of the values of ROAD, WALL, or 
 TREASURE. 
 Cell A and B are adjacent if cell B is on the immediate left, right, top, or 
 bottom of cell A. 
 Write an algorithm that generates a graph where the nodes are walkable cells 
 from this matrix. There is an edge between two nodes if they are neighbors.
 Your algorithm should return the first node from top left that is not null.
 */
package TreesAndGraphs;

import java.util.*;

/**
 *
 * @author rezaamini
 */
public class GenerateGraph
{
    private enum CellType
    {
        ROAD, WALL, TREASURE;
    }

    public GraphNode<CellType> generateGraph(CellType[][] inputs)
    {
        int rowSize = inputs.length;
        
        if(rowSize == 0)
            return null;
        
        Map<Integer, GraphNode<CellType>> nodes = new HashMap<>();
        GraphNode<CellType> firstNode = null;
        int colSize = inputs[0].length;
        
        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                if(inputs[i][j] == CellType.WALL)
                    continue;
                int location = location(i, j, rowSize);
                if(!nodes.containsKey(location))
                {
                    GraphNode<CellType> node = new GraphNode<CellType>(inputs[i][j]);
                    nodes.put(location, node);
                }
                
                GraphNode<CellType> mainNode = nodes.get(location);
                if(firstNode == null)
                    firstNode = mainNode;
                
                // right
                if(j + 1 < colSize && inputs[i][j + 1] != CellType.WALL)
                {
                    int right = location(i, j + 1, rowSize);
                    if(!nodes.containsKey(right))
                    {
                        GraphNode<CellType> node = new GraphNode<CellType>(inputs[i][j + 1]);
                        nodes.put(right, node);
                    }
                    GraphNode<CellType> rightNode = nodes.get(right);
                    mainNode.adjacents.add(rightNode);
                }
                
                // left
                if(j - 1 >= 0 && inputs[i][j - 1] != CellType.WALL)
                {
                    int left = location(i, j - 1, rowSize);
                    if(!nodes.containsKey(left))
                    {
                        GraphNode<CellType> node = new GraphNode<CellType>(inputs[i][j - 1]);
                        nodes.put(left, node);
                    }
                    GraphNode<CellType> leftNode = nodes.get(left);
                    mainNode.adjacents.add(leftNode);
                }
                
                // up
                if(i - 1 >= 0 && inputs[i - 1][j] != CellType.WALL)
                {
                    int up = location(i - 1, j, rowSize);
                    if(!nodes.containsKey(up))
                    {
                        GraphNode<CellType> node = new GraphNode<CellType>(inputs[i - 1][j]);
                        nodes.put(up, node);
                    }
                    GraphNode<CellType> upNode = nodes.get(up);
                    mainNode.adjacents.add(upNode);
                }
                
                // down
                if(i + 1 < rowSize && inputs[i + 1][j] != CellType.WALL)
                {
                    int down = location(i + 1, j, rowSize);
                    if(!nodes.containsKey(down))
                    {
                        GraphNode<CellType> node = new GraphNode<CellType>(inputs[i + 1][j]);
                        nodes.put(down, node);
                    }
                    GraphNode<CellType> downNode = nodes.get(down);
                    mainNode.adjacents.add(downNode);
                }
            }
        }
        return firstNode;
    }
    
    public GraphNode<CellType> findTreasureDFS(CellType[][] inputs)
    {
        GraphNode<CellType> startNode = generateGraph(inputs);
        if(startNode == null)
            return null;
        Set<GraphNode<CellType>> visitedNodes = new HashSet<>();
        return findTreasureDFS_Recursive(startNode, visitedNodes);
    }
    
    // Instead of doing the DFS recursively, we can use Stack
    // Complexity: O(N + E)
    public GraphNode<CellType> findTreasureDFS_Recursive(
        GraphNode<CellType> startNode, Set<GraphNode<CellType>> visitedNodes)
    {
        visitedNodes.add(startNode);
        if(startNode.value == CellType.TREASURE)
            return startNode;
        for(GraphNode<CellType> adj: startNode.adjacents)
        {
            if(!visitedNodes.contains(adj))
            {
                GraphNode<CellType> answer = findTreasureDFS_Recursive(adj, visitedNodes);
                if(answer != null)
                    return answer;
            }
        }
        return null;
    }
    
    // Complexity: O(N + E)
    public GraphNode<CellType> findTreasureBFS(CellType[][] inputs)            
    {
        GraphNode<CellType> startNode = generateGraph(inputs);
        if(startNode == null)
            return null;
        Set<GraphNode<CellType>> visitedNodes = new HashSet<>();
        Queue<GraphNode<CellType>> queue = new ArrayDeque<>();
        queue.add(startNode);
        while(!queue.isEmpty())
        {
            GraphNode<CellType> node = queue.poll();
            if(!visitedNodes.contains(node))
            {
                visitedNodes.add(node);
                if(node.value == CellType.TREASURE)
                    return node;
                for(GraphNode<CellType> adj: node.adjacents)
                    queue.add(adj);
            }
        }
        return null;
    }
    
    private int location(int x, int y, int rowSize)
    {
        return x * rowSize + y;
    }
}