/*
 - Left child of node at index i is at index 2 * i + 1.
 - Right child of node at index i is at index 2 * i + 2
 - Parent of node at index i is at index ( i – 1 ) / 2
 - If the index falls outside the bounds of the array for either the left child, 
right child, or the parent node, then that node is null.

*/
package TreesAndGraphs;

import java.util.ArrayList;

/**
 *
 * @author rezaamini
 */
public class MaxHeap
{
    ArrayList<Integer> heap;
    
    public MaxHeap()
    {
        heap = new ArrayList<Integer>();
    }
    
    // O(log n)
    public void insert(int node)
    {
        heap.add(node);
        int nodeIndex = heap.size() - 1;
        Integer parent = getParent(nodeIndex);
        while(parent != null && node > parent)
        {
            // swap
            int parentIndex = (nodeIndex - 1) / 2;
            int temp = heap.get(nodeIndex);
            heap.set(nodeIndex, parent);
            heap.set(parentIndex, temp);
            nodeIndex = parentIndex;
            parent = getParent(nodeIndex);
        }
    }
    
    // O(log n)
    public int extractMax()
    {
        return extractMax(0);
    }
    
    public Integer extractMax(int nodeIndex)
    {
        Integer node = heap.get(nodeIndex);
        Integer leftNode = null;
        Integer rightNode = null;
        if(2 * nodeIndex + 1 < heap.size())
            leftNode = heap.get(2 * nodeIndex + 1);
        if(2 * nodeIndex + 2 < heap.size())
            rightNode = heap.get(2 * nodeIndex + 2);
        
        if(leftNode == null && rightNode == null)
        {
            Integer n = heap.remove(nodeIndex);
            return n;
        }
        else if(leftNode == null || (rightNode != null && rightNode > leftNode))
        {
            Integer newNode = extractMax(2 * nodeIndex + 2);
            heap.set(nodeIndex, newNode);
        }
        else if(rightNode == null || (leftNode != null && leftNode >= rightNode))
        {
            Integer newNode = extractMax(2 * nodeIndex + 1);
            heap.set(nodeIndex, newNode);
        }
        
        return node;
    }
    
    // O(1)
    public int peekMax()
    {
        return heap.get(0);
    }
    
    public Integer getParent(int index)
    {
        int parentIndex = (index - 1) / 2;
        if(parentIndex < 0 || parentIndex >= heap.size())
            return null;
        return heap.get(parentIndex);
    }
    
    public int getSize()
    {
        return heap.size();
    }
}

class MaxHeapTester
{
    public static void main(String[] args)
    {
        MaxHeap heap = new MaxHeap();
        IntegerStream stream = new IntegerStream();
        while(!stream.isEmpty())
            heap.insert(stream.read());
        while(heap.getSize() > 0)
            System.out.println(heap.extractMax());
    }
}
