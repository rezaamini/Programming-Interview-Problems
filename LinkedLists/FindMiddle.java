/*
 Write an algorithm to find the middle of a linked list. If the list is 
 even-sized, the middle is the node that is closer to the beginning.
 */
package LinkedLists;

/**
 *
 * @author rezaamini
 */
public class FindMiddle<T>
{
    public LinkedListNode<T> findMiddle(LinkedListNode<T> head)
    {
        if(head == null)
            return null;
            
        LinkedListNode<T> slow = head;
        LinkedListNode<T> fast = head;
        
        while(fast != null)
        {
            fast = fast.next;
            if(fast == null || fast.next == null)
                return slow;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
