/*

 Imagine a linked list that has duplicate items. Write an algorithm to remove 
 duplicates without using any extra space or changing the data structure.

*/
package LinkedLists;

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
    public static LinkedListNode<T> removeDuplicates(Node node){
        if(head == null)
            return null;
        
        if(head.next == null)
            return head;
            
        HashSet<T> table = new HashSet();
        LinkedListNode<T> head = node;
        LinkedListNode<T> previous = null;

        while(node != null) {
            if (table.contains(node.value))
                previous.next = node.next;
            else {
                table.add(node.value);
                previous = node;
            }
            node = node.next;
        }
        
        return head;
    }
}

class LinkedListNode<T>
{
    T value;
    LinkedListNode<T> next;
    
    public LinkedListNode(T value)
    {
        this.value = value;
    }
    
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        LinkedListNode<T> temp = this;
        while(temp != null)
        {
            out.append(temp.value).append(" ");
            temp = temp.next;
        }
        out.setLength(out.length() - 1);
        return out.toString();
    }
}
