/*
 Imagine a linked list that has duplicate items. Write an algorithm to remove 
 duplicates without using any extra space or changing the data structure.
 */
package LinkedLists;

/**
 *
 * @author rezaamini
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
                    runner.next = runner.next.next;
                runner = runner.next;
            }
            current = current.next;
        }
        return head;
    }
}
