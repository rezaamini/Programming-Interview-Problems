/*

   Develop an efficient algorithm that computes the number of shortest paths 
   between vertices s and t in an undirected graph with unit cost edges.

 */

package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Reza Amini
 */
public class NumberOfShortestPaths {

    public static void main(String[] args) {
        VertexObj v0 = new VertexObj("0");
        VertexObj v1 = new VertexObj("1");
        VertexObj v2 = new VertexObj("2");
        VertexObj v3 = new VertexObj("3");
        VertexObj v4 = new VertexObj("4");

        v0.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v1, 5),
            new EdgeObj(v2, 1),
            new EdgeObj(v3, 8)});
        v1.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v0, 5),
            new EdgeObj(v2, 2),
            new EdgeObj(v4, 7)});
        v2.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v0, 1),
            new EdgeObj(v1, 2)});
        v3.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v0, 8),
            new EdgeObj(v4, 2)});
        v4.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v1, 7),
            new EdgeObj(v3, 2)});
        
        VertexObj[] vertices = {v0, v1, v2, v3, v4};
        
        computePaths(v0);
        for (VertexObj v : vertices) 
        {
            System.out.println("Distance to " + v + ": " + v.getMinDistance());
            System.out.println("Number of paths: " + v.getExtraVariable());
            List<VertexObj> path = getShortestPathTo(v);
            System.out.println("Path: " + path);
        }
    }
    
    public static void computePaths(VertexObj source)
    {
        source.setMinDistance(0.0);
        source.setExtraVariable(1); // use the extra variable property as number of pathes to the vertex
        PriorityQueue<VertexObj> vertexQueue = new PriorityQueue<VertexObj>();
        vertexQueue.add(source);
        
        while(!vertexQueue.isEmpty())
        {
            VertexObj u = vertexQueue.poll();
            
            for(EdgeObj e: u.getAdjacencies())
            {
                VertexObj v = e.getTarget();
                double weight = e.getWeight();
                double distanceThroughU = u.getMinDistance() + weight;
                if (distanceThroughU < v.getMinDistance())
                {
                    vertexQueue.remove(v);
                    v.setMinDistance(distanceThroughU);
                    v.setExtraVariable(1);
                    v.setPrevious(u);
                    vertexQueue.add(v);
                }
                else if (distanceThroughU == v.getMinDistance())
                {
                    vertexQueue.remove(v);
                    v.setMinDistance(distanceThroughU);
                    v.setExtraVariable(v.getExtraVariable() + 1);
                    v.setPrevious(u);
                    vertexQueue.add(v);
                }
            }
        }
    }
    
    public static List<VertexObj> getShortestPathTo(VertexObj target)
    {
        List<VertexObj> path = new ArrayList<VertexObj>();
        VertexObj vertex = target;
        while(vertex != null)
        {
            path.add(vertex);
            vertex = vertex.getPrevious();
        }
        Collections.reverse(path);
        return path;
    }
}

