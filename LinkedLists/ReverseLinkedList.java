/*
 * Implement an algorithm that reverses a linked list.
 */
package LinkedLists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 *
 * @author rezaamini
 */
public class ReverseLinkedList
{
    // Time complexity: O(N), Space complexity: O(N)
    public static LinkedListNode<Integer> reverse_stack(LinkedListNode<Integer> linkedList)
    {
        if (linkedList == null)
            return null;
        
        //Stack<LinkedListNode<Integer>> stack = new Stack<>();
        Deque<LinkedListNode<Integer>> stack = new ArrayDeque<>(); // ArrayDeque is faster than Stack and Queue 
        LinkedListNode<Integer> temp = linkedList;
        while(temp != null)
        {
            stack.push(temp);
            temp = temp.next;
        }
        
        LinkedListNode<Integer> output = stack.pop();
        temp = output;
        while(!stack.isEmpty())
        {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return output;
    }
    
    // Time complexity: O(N), Space complexity: O(N)
    public static LinkedListNode<Integer> reverse_recursive(LinkedListNode<Integer> linkedList)
    {
        if(linkedList == null)
            return null;
        ArrayList<LinkedListNode<Integer>> newHead = new ArrayList<>();
        reverse_recursive(linkedList, newHead);
        return newHead.get(0);
    }
    
    // This method returns the tail of the reversed linkedlist
    private static LinkedListNode<Integer> reverse_recursive(
            LinkedListNode<Integer> linkedList, ArrayList<LinkedListNode<Integer>> newHead)
    {
        if(linkedList.next == null)
        {
            newHead.add(linkedList); // Save the new Head
            return linkedList;
        }
        
        LinkedListNode<Integer> nextReversed = reverse_recursive(linkedList.next, newHead);
        nextReversed.next = linkedList;
        linkedList.next = null;
        return linkedList;
    }
    
    // Time complexity: O(N), Space complexity: O(1)
    public static LinkedListNode<Integer> reverse_pointers(LinkedListNode<Integer> linkedList)
    {
        // zero element
        if(linkedList == null)
            return null;
        // one element
        if(linkedList.next == null)
            return linkedList;
        
        // two elements
        if(linkedList.next.next == null)
        {
            LinkedListNode<Integer> head = linkedList.next;
            head.next = linkedList;
            linkedList.next = null;
            return head;
        }
        
        LinkedListNode<Integer> first = null;
        LinkedListNode<Integer> second = linkedList;
        LinkedListNode<Integer> third = linkedList.next;
        
        while(second != null)
        {
            second.next = first;
            first = second;
            second = third;
            if(third != null)
                third = third.next;
        }
        
        return first;
    }
        
    public static void main(String[] args)
    {
        // Single node case
        LinkedListNode<Integer> n0 = new LinkedListNode(0);
        //System.out.println(reverse_stack(n0));
        //System.out.println(reverse_recursive(n0));
        System.out.println(reverse_pointers(n0));
        
        // Multi-node case
        LinkedListNode<Integer> n1 = new LinkedListNode(1);
        LinkedListNode<Integer> n2 = new LinkedListNode(2);
        LinkedListNode<Integer> n3 = new LinkedListNode(3);
        LinkedListNode<Integer> n4 = new LinkedListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //System.out.println(reverse_stack(n1));
        //System.out.println(reverse_recursive(n1));
        System.out.println(reverse_pointers(n1));
    }
}
