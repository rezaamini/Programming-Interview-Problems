/*

   Implement an algorithm to delete a node in the middle of a single linked list,
   given only access to that node.
   EXAMPLE
   Input: the node ‘c’ from the linked list a->b->c->d->e
   Result: nothing is returned, but the new linked list looks like a->b->d->e
 
*/

package linkedlists;

import stacksandqueues.Node;

/**
 *
 * @author Reza Amini
 */
public class RemoveNode {
    public static void main(String[] args) {
        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        
        System.out.println(a);
        if( removeNode(c))
            System.out.println(a);
    }

    /*
     * Copy the contents of the next node to this node and remove the next node.
     * If the node is the last node, it can not be removed.
     */
    public static boolean removeNode(Node n) {
        if (n == null)
            return false;
        
        Node next = n.next;
        n.next = next.next;
        n.data = next.data;
        
        return true;
    }

}

