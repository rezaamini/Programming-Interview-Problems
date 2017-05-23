/*

   Implement a QueueUsingStack class which implements a queue using two stacks.
 
*/

package stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement a queue using stacks.
 * @author Reza Amini
 */
public class QueueUsingStack {
    // Used for enqueuing
    private Deque<Integer> enqueue = new LinkedList<>();
    // Used for dequeuing
    private Deque<Integer> dequeue = new LinkedList<>();

    // Time complexity: O(1)
    public void enqueue(Integer num) {
        enqueue.addFirst(num);
    }

    // Time complexity: best case O(1), if dequeue is not empty. Worst case, O(n), where n is the enqueue size.
    public Integer dequeue() {
        if (dequeue.isEmpty()) {
            while(!enqueue.isEmpty()) {
                dequeue.addFirst(enqueue.removeFirst());
            }
        }

        if (!dequeue.isEmpty()) {
            return dequeue.removeFirst();
        }

        return null;
    }

    public int size() {
        return enqueue.size() + dequeue.size();
    }

    // The same as dequeue, but does not remove the element from queue.
    public Integer peek() {
        if (dequeue.isEmpty()) {
            while(!enqueue.isEmpty()) {
                dequeue.addFirst(enqueue.removeFirst());
            }
        }

        if (!dequeue.isEmpty()) {
            return dequeue.peekFirst();
        }

        return null;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    @Test
    public void test() {
        QueueUsingStack queue = new QueueUsingStack();

        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(i + " is added. The queue size is " + queue.size() + ".");
            Assert.assertTrue(queue.size() == i + 1);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue() + " is removed. The queue size is " + queue.size() + ".");
        }

        Assert.assertTrue(queue.isEmpty());
    }
}
