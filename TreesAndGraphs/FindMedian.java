/*
 * Can you retrieve the median in O(1) at any given point?
 */
package TreesAndGraphs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author rezaamini
 */
public class FindMedian
{
    public static int findMedian(IntegerStream stream)
    {
        Queue<Integer> larger = new PriorityQueue<>();
        MaxHeap smaller = new MaxHeap();
        
        while(!stream.isEmpty())
        {
            int num = stream.read();
            if(!larger.isEmpty() && num > larger.peek())
                larger.add(num);
            else 
                smaller.insert(num);
            
            if(smaller.getSize() > larger.size() + 1)
            {
                int temp = smaller.extractMax();
                larger.add(temp);
            }
            else if (larger.size() > smaller.getSize())
            {
                int temp = larger.poll();
                smaller.insert(temp);
            }
        }
        
        return smaller.peekMax();
    }
    
    public static void main(String[] args)
    {
        System.out.println(findMedian(new IntegerStream()));
    }
}
