package stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implement a queue using stacks, and enable the queue to give max of the queue.
 *
 * Created by rezaamini on 5/16/17.
 */
public class QueueUsingStackWithMax {
    // Time complexity: O(1) amortized time complexity for enqueue, dequeue, and max
    private StackWithMax enqueue = new StackWithMax();
    private StackWithMax dequeue = new StackWithMax();

    public void enqueue(Integer num) {
        enqueue.push(num);
    }

    public Integer dequeue() {
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }

        if (!dequeue.isEmpty()) {
            return dequeue.pop();
        }

        return null;
    }

    public Integer max() {
        if (!enqueue.isEmpty()) {
            return dequeue.isEmpty() ? enqueue.max() : Math.max(enqueue.max(), dequeue.max());
        }

        if (!dequeue.isEmpty()) {
            return dequeue.max();
        }

        return null;
    }

    @Test
    public void testEnqueue() {
        QueueUsingStackWithMax queueWithMax = new QueueUsingStackWithMax();
        // Enqueue
        queueWithMax.enqueue(4); // {4}
        Assert.assertTrue(queueWithMax.max() == 4);
        queueWithMax.enqueue(4); // {4, 4}
        Assert.assertTrue(queueWithMax.max() == 4);
        queueWithMax.enqueue(2); // {2, 4, 4}
        Assert.assertTrue(queueWithMax.max() == 4);
        queueWithMax.enqueue(1); // {1, 2, 4, 4}
        Assert.assertTrue(queueWithMax.max() == 4);
        queueWithMax.enqueue(0); // {0, 1, 2, 4, 4}
        Assert.assertTrue(queueWithMax.max() == 4);
        queueWithMax.enqueue(2); // {2, 0, 1, 2, 4, 4}
        Assert.assertTrue(queueWithMax.max() == 4);
        queueWithMax.enqueue(3); // {3, 2, 0, 1, 2, 4, 4}
        Assert.assertTrue(queueWithMax.max() == 4);

        // Dequeue
        Assert.assertTrue(queueWithMax.max() == 4);
        queueWithMax.dequeue(); // {3, 2, 0, 1, 2, 4}
        Assert.assertTrue(queueWithMax.max() == 4);
        queueWithMax.dequeue(); // {3, 2, 0, 1, 2}
        Assert.assertTrue(queueWithMax.max() == 3);
        queueWithMax.dequeue(); // {3, 2, 0, 1}
        Assert.assertTrue(queueWithMax.max() == 3);
        queueWithMax.dequeue(); // {3, 2, 0}
        Assert.assertTrue(queueWithMax.max() == 3);
        queueWithMax.dequeue(); // {3, 2}
        Assert.assertTrue(queueWithMax.max() == 3);
        queueWithMax.dequeue(); // {3}
        Assert.assertTrue(queueWithMax.max() == 3);
        queueWithMax.dequeue(); // {}
        Assert.assertTrue(queueWithMax.max() == null);
    }
}
