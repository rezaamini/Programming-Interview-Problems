/*
 You have an unlimited stream of integers presented to you. You can only call a 
 get function on this stream to retrieve and remove the first element from the 
 stream. Write an algorithm that can give you the top k largest integers at any 
 point. If the stream contains duplicates, they should appear as duplicates in 
 your output too.
 */
package TreesAndGraphs;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 *
 * @author rezaamini
 */
public class TopK
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(topK(6, new IntegerStream())));
    }
    
    public static int[] topK(int k, IntegerStream stream)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        while(!stream.isEmpty())
        {
            int num = stream.read();
            if(heap.size() < k)
                heap.add(num);
            else if(num > heap.peek())
            {
                heap.remove();
                heap.add(num);
            }
        }
        
        int[] result = new int[k];
        int n = heap.size();
        for(int i = 0; i < n; i++)
            result[i] = heap.remove();
        
        return result;
    }
}
