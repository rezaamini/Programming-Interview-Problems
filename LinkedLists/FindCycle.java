/*
   
   Given a circular linked list, implement an algorithm which returns node at
   the beginning of the loop.
   DEFINITION
   Circular linked list: A (corrupt) linked list in which a node’s next pointer
   points to an earlier node, so as to make a loop in the linked list.
   EXAMPLE
   Input: A -> B -> C -> D -> E -> C [the same C as earlier]
   Output: C
 
*/

package LinkedLists;

import StacksAndQueues.Node;

/**
 *
 * @author Reza Amini
 */
public class FindCycle {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        findLoop(n1);
    }

    /* 
     * Floyd's cycle-finding algorithm (tortoise and the hare)
     * Time complexity: O(n)
     */
    public static Node findLoop(Node head) {
        Node slow = head; // slow pointer
        Node fast = head; // fast pointer

        // Find the meeting point of the slow and fast pointer
        while(fast.next != null) {
            slow = slow.next;
            System.out.print("slow: " + slow.data + ", ");
            fast = fast.next.next;
            System.out.println("fast: " + fast.data);
            if (slow == fast)
                break;
        }

        // if there is no cycle and there is no meeting point
        if (fast.next == null)
            return null;

        // if cycle is found
        slow = head; // return the slow pointer to the head
        while(fast != slow) {
            fast = fast.next; // slow down the fast pointer to the same speed as slow pointer
            slow = slow.next;
        }
        System.out.println("Loop begining: " + slow.data);
        return slow;
    }
}
