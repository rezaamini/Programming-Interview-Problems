/*
 Imagine that you have a directed graph. This graph is connected so you any 
 reach any node of your choosing from any other node. Write an algorithm to copy 
 this graph.
 */
package TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author rezaamini
 */
public class CopyGraph
{
    public GraphNode<Integer> copyGraph(GraphNode<Integer> graph)
    {
        Set<GraphNode<Integer>> visitedNodes = new HashSet<>();
        Map<GraphNode<Integer>,GraphNode<Integer>> copiedNodes = new HashMap<>();
        Queue<GraphNode<Integer>> queue = new ArrayDeque<>();
        
        queue.add(graph);
        GraphNode<Integer> copiedGraph = null;
        while(!queue.isEmpty())
        {
            GraphNode<Integer> node = queue.poll();
            GraphNode<Integer> copy = copyNode(node, copiedNodes);
            if(copiedGraph == null)
                copiedGraph = copy;
            
            visitedNodes.add(node);
            for(GraphNode adj: node.adjacents)
            {
                if(!visitedNodes.contains(adj))
                    queue.add(adj);
            }
        }
        return copiedGraph;
    }

    private GraphNode<Integer> copyNode(GraphNode<Integer> node, 
            Map<GraphNode<Integer>, GraphNode<Integer>> copiedNodes)
    {
        if(!copiedNodes.containsKey(node))
            copiedNodes.put(node, new GraphNode(node.value));
        
        GraphNode<Integer> copy = copiedNodes.get(node);
        for(GraphNode<Integer> adj: node.adjacents)
        {
            if(!copiedNodes.containsKey(adj))
                copiedNodes.put(adj, new GraphNode(adj.value));
            
            GraphNode<Integer> adjCopy = copiedNodes.get(adj);
            if(copy.adjacents == null)
                copy.adjacents = new ArrayList<>();
            copy.adjacents.add(adjCopy);
        }
        return copy;
    }
}

class CopyGraphTester
{
    public static void main(String[] args)
    {
        CopyGraph cg = new CopyGraph();
        
        GraphNode<Integer> a = new GraphNode(1);  
        GraphNode<Integer> b = new GraphNode(2);
        GraphNode<Integer> c = new GraphNode(3);
        GraphNode<Integer> d = new GraphNode(4);
        GraphNode<Integer> e = new GraphNode(5);
        
        a.adjacents = new ArrayList<>();
        a.adjacents.add(b);
        b.adjacents = new ArrayList<>();
        b.adjacents.add(a);
        b.adjacents.add(c);
        c.adjacents = new ArrayList<>();
        c.adjacents.add(d);
        d.adjacents = new ArrayList<>();
        d.adjacents.add(b);
        d.adjacents.add(e);
        e.adjacents = new ArrayList<>();
        e.adjacents.add(a);  
        
        GraphNode copy = cg.copyGraph(a);
        System.out.println();
    }
}

