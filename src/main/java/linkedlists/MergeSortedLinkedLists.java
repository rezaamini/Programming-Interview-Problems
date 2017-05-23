/*

 Given two sorted linkedlists, merge them.
 
*/

package linkedlists;

/**
 *
 * @author Reza Amini
 */
public class MergeSortedLinkedLists
{
    public static void main(String[] args)
    {
        Node list1 = new Node(2);
        list1.next = new Node(3);
        list1.next.next = new Node(8);
        
        Node list2 = new Node(4);
        list2.next = new Node(5);
        list2.next.next = new Node(7);
        list2.next.next.next = new Node(9);
        list2.next.next.next.next = new Node(10);
        
        printNode(merge(list1, list2));
    }
    
    public static Node merge(Node list1, Node list2)
    {
        // the important point is defining a dummy node not to lose the begining of the result linked list
        Node dummy = new Node(0); 
        Node result = dummy;
        while(list1 != null && list2 != null)
        {
            if(list1.value <= list2.value)
            {
                result.next = list1;
                list1 = list1.next;
            }
            else 
            {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        
        if(list1 != null)
            result.next = list1;
        if(list2 != null)
            result.next = list2;
        
        return dummy.next;
    }
    
    public static void printNode(Node list)
    {
        while(list != null)
        {
            System.out.print(list.value + ", ");
            list = list.next;
        }
        
        System.out.println("\b\b");
    }
}

class Node
{
    int value;
    Node next;
    
    public Node(int value)
    {
        this.value = value;
        this.next = null;
    }
}
