/*
    Imagine you have an array of time intervals:
    [ (1,5), (3,7), (8, 12), (11, 15), (14, 19), (30, 34) ]
    Write an algorithm that merges the overlapping intervals without using any 
    extra memory: [ (1,7), (8, 19), (30, 34) ]
*/

package ArraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Reza Amini
 */
public class MergeOverlapingTimes
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        // Get number of intervals
        int n = scan.nextInt();
        Pair[] pairs = new Pair[n];
        // Get the pairs and populate the array
        for(int i = 0; i < n; i++)
        {
            int start = scan.nextInt();
            int end = scan.nextInt();
            pairs[i] = new Pair(start, end);
        }
        
        int last = merge(pairs);
        for(int i = 0 ; i <= last; i++)
            System.out.println(pairs[i]);
    }
    
    // Merges the pairs and returns the index of last element in the merged list
    public static int merge(Pair[] pairs)
    {
        int n = pairs.length;
        // Sort the intervals based on their starting times
        Arrays.sort(pairs, new PairComparator());
        
        int nextPosition = 0; // Index of next merged interval
        int currentStart = pairs[0].start;
        int currentEnd = pairs[0].end;
        for(int i = 1 ; i < n; i++)
        {
            if(pairs[i].start <= currentEnd)
            {
                // Merge intervals 
                currentEnd = Math.max(pairs[i].end, currentEnd);
            }
            else
            {
                pairs[nextPosition] = new Pair(currentStart, currentEnd);
                nextPosition++;
                currentStart = pairs[i].start;
                currentEnd = pairs[i].end;
            }
        }
        // Make sure the last element is writen to the array
        if(pairs[nextPosition - 1].start != currentStart &&
                pairs[nextPosition - 1].end != currentEnd)
            pairs[nextPosition] = new Pair(currentStart, currentEnd);
        
        return nextPosition;
    }
}

// This class represents a pair of times (start, end)
class Pair
{
    int start;
    int end;
    
    public Pair(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
    
    public String toString()
    {
        return start + ", " + end;
    }
}

// Comparator class is used for sorting the pairs
class PairComparator implements Comparator
{
    public int compare(Object o1, Object o2)
    {
        Pair p1 = (Pair)o1;
        Pair p2 = (Pair)o2;
        return Integer.compare(p1.start, p2.start);
    }
    
}
