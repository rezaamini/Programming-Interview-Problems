/*

 Implement a linked list.
 
*/

package linkedlists;

/**
 *
 * @author Reza Amini
 */
public class BasicLinkedList<T>
{
    private LinkedListNode<T> head;
    
    // Constructor
    public BasicLinkedList(LinkedListNode<T> head)
    {
        this.head = head;    
    }
    
    public int length()
    {
        int length = 0;
        LinkedListNode<T> temp = head;
        while(temp != null)
        {
            length++;
            temp = temp.next;
        }
        return length;
    }
    
    public LinkedListNode<T> searchValue(T value)
    {
        if(head == null)
            return null;
        
        LinkedListNode<T> temp = head;
        while(temp != null)
        {
            if(temp.value.equals(value))
                return temp;
            temp = temp.next;
        }
        return null;
    }
    
    public LinkedListNode<T> getNodeAtIndex(int index)
    {
        if(head == null || index < 0)
            return null;
        
        LinkedListNode<T> temp = head;
        int counter = 0;
        while(counter < index)
        {
            temp = temp.next;
            if(temp == null)
                return null;
            counter++;
        }
        return temp;
    }
    
    public LinkedListNode<T> insertAtIndex(int index, LinkedListNode<T> node)
    {
        if(head == null)
            return null;
        
        if(index == 0)
        {
            node.next = head;
            head = node;
            return node;
        }
        
        LinkedListNode<T> before = getNodeAtIndex(index - 1);
        if(before == null)
            return head;
        LinkedListNode<T> after = before.next;
        before.next = node;
        if(node != null)
            node.next = after;
        return head;
    }
    
    public LinkedListNode<T> deleteNode(T value)
    {
        if(head == null)
            return null;
        
        if(head.value == value)
        {
            head = head.next;
            return head;
        }
        
        LinkedListNode<T> temp = head;
        while(temp.next != null && !temp.next.value.equals(value))
        {
            temp = temp.next;
        }
        if(temp.next == null)
            return head;
        temp.next = temp.next.next;
        return head;
    }
    
    public boolean equals(LinkedListNode<T> other)
    {
        LinkedListNode<T> temp = head;
        LinkedListNode<T> otherTemp = other;
        
        while(temp != null && otherTemp != null)
        {
            if(!temp.value.equals(otherTemp.value))
                return false;
            temp = temp.next;
            otherTemp = otherTemp.next;
        }
        
        if(temp == null && otherTemp == null)
            return true;
        return false;
    }
    
    public LinkedListNode<T> copy()
    {
        if(head == null)
            return null;
        
        LinkedListNode<T> newHead = new LinkedListNode(head.value);
        LinkedListNode<T> temp = head;
        LinkedListNode<T> newHeadTemp = newHead;
        temp = temp.next;
        while(temp != null)
        {
            newHeadTemp.next = new LinkedListNode(temp.value);
            newHeadTemp = newHeadTemp.next;
            temp = temp.next;
        }
        return newHead;
    }
}

