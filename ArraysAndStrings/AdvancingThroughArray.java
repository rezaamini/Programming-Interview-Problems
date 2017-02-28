package ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Write a method that takes an array of n integers, where A[i] denotes the maximum you can advance from index i, and
 * returns whether it is possible to advance to the last index starting from the beginning of the array.
 *
 * Created by rezaamini on 2/14/17.
 */
public class AdvancingThroughArray {
    // Time complexity: O(n)
    public boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int farthestReachable = 0;

        for (int i = 0; i <= farthestReachable && farthestReachable < maxAdvanceSteps.size() - 1; i++) {
            farthestReachable = Math.max(farthestReachable, i + maxAdvanceSteps.get(i));
        }

        return farthestReachable >= maxAdvanceSteps.size() - 1;
    }

    @Test
    public void testCanReachEnd() {
        Assert.assertTrue(canReachEnd(Arrays.asList(2, 4, 1, 1, 0, 2, 3)));
        Assert.assertTrue(canReachEnd(Arrays.asList(3, 3, 1, 0, 2, 0, 1)));
        Assert.assertFalse(canReachEnd(Arrays.asList(3, 2, 0, 0, 2, 0, 1)));
    }
}
