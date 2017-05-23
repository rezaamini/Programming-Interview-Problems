package stacksandqueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a queue with max API.
 * Created by rezaamini on 5/16/17.
 */
public class QueueWithMax<T extends Comparable<T>> {
    private Queue<T> queue = new LinkedList<>();
    private Deque<T> maxStack = new LinkedList<>();

    public void enqueue(T element) {
        queue.add(element);

        while (!maxStack.isEmpty()) {
            if (maxStack.peekLast().compareTo(element) >= 0) {
                break;
            }
            maxStack.removeLast();
        }

        maxStack.addLast(element);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            return null;
        }

        T element = queue.remove();
        if (element.equals(maxStack.peekFirst())) {
            maxStack.removeFirst();
        }

        return element;
    }

    public T max() {
        if (maxStack.isEmpty()) {
            return null;
        }

        return maxStack.peekFirst();
    }

    @Test
    public void testEnqueue() {
        QueueWithMax<Integer> qwm = new QueueWithMax<>();
        // Enqueue
        qwm.enqueue(4); // {4}
        Assert.assertTrue(qwm.max() == 4);
        qwm.enqueue(4); // {4, 4}
        Assert.assertTrue(qwm.max() == 4);
        qwm.enqueue(2); // {2, 4, 4}
        Assert.assertTrue(qwm.max() == 4);
        qwm.enqueue(1); // {1, 2, 4, 4}
        Assert.assertTrue(qwm.max() == 4);
        qwm.enqueue(0); // {0, 1, 2, 4, 4}
        Assert.assertTrue(qwm.max() == 4);
        qwm.enqueue(2); // {2, 0, 1, 2, 4, 4}
        Assert.assertTrue(qwm.max() == 4);
        qwm.enqueue(3); // {3, 2, 0, 1, 2, 4, 4}
        Assert.assertTrue(qwm.max() == 4);

        // Dequeue
        Assert.assertTrue(qwm.max() == 4);
        qwm.dequeue(); // {3, 2, 0, 1, 2, 4}
        Assert.assertTrue(qwm.max() == 4);
        qwm.dequeue(); // {3, 2, 0, 1, 2}
        Assert.assertTrue(qwm.max() == 3);
        qwm.dequeue(); // {3, 2, 0, 1}
        Assert.assertTrue(qwm.max() == 3);
        qwm.dequeue(); // {3, 2, 0}
        Assert.assertTrue(qwm.max() == 3);
        qwm.dequeue(); // {3, 2}
        Assert.assertTrue(qwm.max() == 3);
        qwm.dequeue(); // {3}
        Assert.assertTrue(qwm.max() == 3);
        qwm.dequeue(); // {}
        Assert.assertTrue(qwm.max() == null);
    }
}
