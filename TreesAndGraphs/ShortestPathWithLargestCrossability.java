/*

   You are given a map with a set of cities connected by roads of known lengths.
   A storm has made some roads uncrossable. For each road, you know the 
   probability of the road being uncrossable. A given path consisting of a set 
   of roads is considered uncrossable if any of the roads in the path is 
   uncrossable.
   
   Find a path between a given pair of cities that is the minimum length path 
   amongst all the paths for which the probability of being crossable is greater 
   than 0.9.

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
public class ShortestPathWithLargestCrossability {
    public static void main(String[] args) {
        VertexObj v0 = new VertexObj("0");
        VertexObj v1 = new VertexObj("1");
        VertexObj v2 = new VertexObj("2");
        VertexObj v3 = new VertexObj("3");
        VertexObj v4 = new VertexObj("4");

        v0.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v1, 5, 0.94),
            new EdgeObj(v2, 1, 0.91),
            new EdgeObj(v3, 8, 0.8)});
        v1.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v0, 5, 0.94),
            new EdgeObj(v2, 2, 0.99),
            new EdgeObj(v4, 7, 0.8)});
        v2.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v0, 1, 0.91),
            new EdgeObj(v1, 2, 0.99)});
        v3.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v0, 8, 0.8),
            new EdgeObj(v4, 2, 0)});
        v4.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v1, 7, 0.8),
            new EdgeObj(v3, 2, 0)});
        
        VertexObj[] vertices = {v0, v1, v2, v3, v4};
        
        computePaths(v0);
        for (VertexObj v : vertices) {
            System.out.println("Distance to " + v + ": " + v.getMinDistance());
            System.out.println("Crossability: " + v.getExtraVariable());
            List<VertexObj> path = getShortestPathTo(v);
            if (path.get(path.size() - 1).getExtraVariable() > 0.9)
                System.out.println("Path: " + path);
            else 
                System.out.println("Path: No 90% crossable pass!");
        }
    }
    
    public static void computePaths(VertexObj source)
    {
        source.setMinDistance(0.0);
        source.setExtraVariable(1); // use the extra variable property as the probability of road to be crossable
        PriorityQueue<VertexObj> vertexQueue = new PriorityQueue<VertexObj>();
        vertexQueue.add(source);
        
        while(!vertexQueue.isEmpty())
        {
            VertexObj u = vertexQueue.poll();
            
            for(EdgeObj e: u.getAdjacencies())
            {
                if (e.getExtraVariable() != 0)
                {
                    VertexObj v = e.getTarget();
                    double weight = e.getWeight();
                    double distanceThroughU = u.getMinDistance() + weight;
                    double acrossability = e.getExtraVariable() * u.getExtraVariable();
                    if (distanceThroughU < v.getMinDistance())
                    {
                        vertexQueue.remove(v);
                        v.setMinDistance(distanceThroughU);
                        v.setExtraVariable(acrossability);
                        v.setPrevious(u);
                        vertexQueue.add(v);
                    }
                }
            }
        }
    }
    
    public static List<VertexObj> getShortestPathTo(
        VertexObj target)
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

