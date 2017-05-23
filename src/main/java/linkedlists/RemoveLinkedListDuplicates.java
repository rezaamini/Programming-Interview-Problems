/*

 Imagine a linked list that has duplicate items. Write an algorithm to remove 
 duplicates without using any extra space or changing the data structure.

*/
package linkedlists;

import java.util.HashSet;

/**
 *
 * @author Reza Amini
 */
public class RemoveLinkedListDuplicates<T>
{
    // Time complexity: O(N^2)
    public LinkedListNode<T> removeDuplicates(LinkedListNode<T> head)
    {
        if(head == null)
            return null;
        
        if(head.next == null)
            return head;
        
        LinkedListNode<T> current = head;
        while(current != null)
        {
            LinkedListNode<T> runner = current;
            while(runner != null && runner.next != null)
            {
                if(current.value.equals(runner.next.value))
                    runner.next = runner.next.next; // this line will take the runner one step forward itself
                else
                    runner = runner.next;
            }
            current = current.next;
        }
        return head;
    }
    
    // Using an extra buffer
    // Time complexity: O(N), space complexity: O(N)
    public LinkedListNode<T> removeDuplicates2(LinkedListNode<T> head){
        if(head == null)
            return null;
        
        if(head.next == null)
            return head;
            
        HashSet<T> table = new HashSet();
        LinkedListNode<T> current = head;
        LinkedListNode<T> previous = null;

        while(current != null) {
            if (table.contains(current.value))
                previous.next = current.next;
            else {
                table.add(current.value);
                previous = current;
            }
            current = current.next;
        }
        
        return head;
    }
}
