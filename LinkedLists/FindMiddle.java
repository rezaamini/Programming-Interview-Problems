/*

  Write an algorithm to find the middle of a linked list. If the list is 
  even-sized, the middle is the node that is closer to the beginning.
 
*/

package LinkedLists;

/**
 *
 * @author Reza Amini
 */
public class FindMiddle<T>
{
    // Use two pointers: a fast and a slow pointer. The fast pointer's speed is twice the slow one.
    // When the fast pointer reaches the end on the linkedlist, the slow one is in the middle.
    // Time complexity: O(N)
    // Space complexity: O(1)
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
