/*
    Implement the Dijkstra shortest path algorithm.
*/

package treesandgraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Reza Amini
 */
public class DijkstraShortestPath {

    public static void main(String[] args) {
        VertexObj v0 = new VertexObj("0");
        VertexObj v1 = new VertexObj("1");
        VertexObj v2 = new VertexObj("2");
        VertexObj v3 = new VertexObj("3");
        VertexObj v4 = new VertexObj("4");

        v0.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v1, 5),
            new EdgeObj(v2, 10),
            new EdgeObj(v3, 8)});
        v1.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v0, 5),
            new EdgeObj(v2, 3),
            new EdgeObj(v4, 7)});
        v2.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v0, 10),
            new EdgeObj(v1, 3)});
        v3.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v0, 8),
            new EdgeObj(v4, 2)});
        v4.setAdjacencies(new EdgeObj[]{
            new EdgeObj(v1, 7),
            new EdgeObj(v3, 2)});
        
        VertexObj[] vertices = {v0, v1, v2, v3, v4};
        
        // First, we compute minimum paths from v0 to all nodes
        computePaths(v0);
        // Then we print the paths from v0 to all nodes
        for (VertexObj v : vertices) {
            System.out.println("Distance to " + v + ": " + v.getMinDistance());
            List<VertexObj> path = getShortestPathTo(v);
            System.out.println("Path: " + path);
        }
    }

    // Computes the minimum path from v0 to all nodes
    public static void computePaths(VertexObj source) {
        source.setMinDistance(0.0);
        PriorityQueue<VertexObj> vertexQueue = new PriorityQueue<VertexObj>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            VertexObj u = vertexQueue.poll();

            // Visit each edge exiting u
            for (EdgeObj e : u.getAdjacencies()) {
                VertexObj v = e.getTarget();
                double weight = e.getWeight();
                double distanceThroughU = u.getMinDistance() + weight;
                if (distanceThroughU < v.getMinDistance()) {
                    vertexQueue.remove(v); // to replace it with a new v
                    v.setMinDistance(distanceThroughU);
                    v.setPrevious(u);
                    vertexQueue.add(v); // v is replaced with new values
                }
            }
        }
    }

    // Returns the shortest path from v0 to the 'target' node
    public static List<VertexObj> getShortestPathTo(VertexObj target) {
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

class VertexObj implements Comparable<VertexObj> {

    private final String name;
    private EdgeObj[] adjacencies;
    private double minDistance = Double.POSITIVE_INFINITY;
    private VertexObj previous; // previous vertex in the shortest path to this vertex
    private double extraVariable;

    public VertexObj(String argName) {
        name = argName;
    }

    public String getName()
    {
        return name;
    }
    
    public EdgeObj[] getAdjacencies()
    {
        return adjacencies;
    }
    
    public void setAdjacencies(EdgeObj[] adjs)
    {
        adjacencies = adjs;
    }
    
    public double getMinDistance()
    {
        return minDistance;
    }
    
    public void setMinDistance(double minDis)
    {
        minDistance = minDis;
    }
    
    public VertexObj getPrevious()
    {
        return previous;
    }
    
    public void setPrevious(VertexObj prev)
    {
        previous = prev;
    }
    
    public String toString() {
        return name;
    }

    public double getExtraVariable()
    {
        return extraVariable;
    }
    
    public void setExtraVariable(double extra)
    {
        extraVariable = extra;
    }
    
    public int compareTo(VertexObj other) {
        return Double.compare(minDistance, other.minDistance);
    }
}

class EdgeObj {

    private final VertexObj target;
    private final double weight;
    private final double extraVariable;
    
    public EdgeObj(VertexObj argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
        extraVariable = 0;
    }
    
    public EdgeObj(VertexObj argTarget, double argWeight, double ex) {
        target = argTarget;
        weight = argWeight;
        extraVariable = ex;
    }
    
    public VertexObj getTarget()
    {
        return target;
    }

    public double getWeight()
    {
        return weight;
    }
    
    public double getExtraVariable()
    {
        return extraVariable;
    }
    
    public String toString() {
        return target.toString();
    }
}

