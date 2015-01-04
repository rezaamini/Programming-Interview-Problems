/*

   You are given two sorted arrays, A and B, and A has a large enough buffer 
   at the end to hold B. Write a method to merge B into A in sorted order.

 */
package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Reza Amini
 */
public class MergeSortedArrays {
    
    // This code is a part of the standard merge-sort code.
    public static int[] merge(int[] a, int[] b, int n, int m) 
    {
        int k = n + m - 1; // Index of the last element in merged array
        int i = n - 1; // Index of the last element in array a
        int j = m - 1; // Index of the last element in array b
        
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j])
                a[k--] = a[i--];
            else 
                a[k--] = b[j--];
        }
        
        // If still some of the b elements are left
        while (j >= 0)
            a[k--] = b[j--];
        
        return a;
    }
    
    public static ListNode merge(int[][] arr)
    {
        int n = arr.length;
        if(n == 0)
            return null;
        int[] pointers = new int[n]; // keep track of the last element of arrays
        // Each element needs to know from which list it is.
        // We use a Pair object and keep the list number of the element 
        // In a Pair object, 'a' is value of element, and 'b' is its list number
        PriorityQueue<Pair> heap = new PriorityQueue(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2)
            {
                return Integer.compare(p1.a, p2.a);
            }
        });
        // We use linkedlist for output because it is easy & cheap to add to it
        ListNode output = new ListNode(0);    
        ListNode tempOut = output;
        // Add the first element of all arrays
        for(int i = 0; i < n; i++)
        {
            if(arr[i].length > 0)
            {
                Pair p = new Pair(arr[i][0], i);
                heap.add(p);
                pointers[i]++; // increment the inde of each list
            }
        }
        // Repeat until all lists are finished
        while(!heap.isEmpty())
        {
            Pair p = heap.poll();
            tempOut.next = new ListNode(p.a);
            tempOut = tempOut.next;
            if(pointers[p.b] < arr[p.b].length) // if p's list is not finished
            {
                Pair newPair = new Pair(arr[p.b][pointers[p.b]], p.b);
                heap.add(newPair);
                pointers[p.b]++;
            }
        }
        return output.next;
    }
    
    public static void main(String[] args) {
        int[] a = new int[11];
        a[0] = 1; a[1] = 4; a[2] = 9; a[3] = 9; a[4] = 10; a[5] = 16;
        int[] b = {2, 3, 8, 9, 11};
        
        System.out.println(Arrays.toString((merge(a, b, 6, 5))));
        
        int[][] c = {{2, 3, 8, 9, 11}, 
                     {1, 4, 9, 9, 10, 16}, 
                     {1, 1, 1, 4, 6, 7, 8, 9, 111}};
        
        ListNode out = merge(c);
        while(out != null)
        {
            System.out.print(out.val + " ");
            out = out.next;
        }
    }
}