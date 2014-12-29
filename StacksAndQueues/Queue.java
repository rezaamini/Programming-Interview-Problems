/*

   Implement a queue

 */

package StacksAndQueues;

/**
 *
 * @author Reza Amini
 */
public class Queue {
    Node head, tail; // The head node and the tail node of the queue

    /**
     * adds an item to the end of the queue.
     * @param d the object to be added to the end of the queue
     */
    public void enqueue(int d) {
        Node item = new Node(d);

        if (head != null) {
            tail.next = item;
            tail = item;
        }
        else {
            head = item;
            tail = head;
        }
    }

    /**
     * returns the object at the head of the queue
     * @return head of the queue
     */
    public Node dequeue() {
        if (head != null) {
            Node item = new Node(head.data);
            head = head.next;
            return item;
        }
        return null;
    }
}
