package stacksandqueues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement a stack with max API.
 *
 * Created by rezaamini on 5/16/17.
 */
public class StackWithMax {
    // Time complexity: O(1) amortized time complexity for push, pop, and max
    private Deque<ElementWithCacheMax> elementsWithCacheMaxes = new LinkedList<>();

    public boolean isEmpty() {
        return elementsWithCacheMaxes.isEmpty();
    }

    public void push(Integer num) {
        elementsWithCacheMaxes.addFirst(new ElementWithCacheMax(num, isEmpty() ? num : Math.max(num, max())));
    }

    public Integer pop() {
        return isEmpty() ? null : elementsWithCacheMaxes.removeFirst().element;
    }

    public Integer max() {
        return isEmpty() ? null : elementsWithCacheMaxes.peekFirst().max;
    }
}

class ElementWithCacheMax {
    public Integer element;
    public Integer max;

    ElementWithCacheMax(Integer element, Integer max) {
        this.element = element;
        this.max = max;
    }
}
