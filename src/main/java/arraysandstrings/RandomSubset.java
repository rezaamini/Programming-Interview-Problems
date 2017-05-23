package arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Write a method that takes as input a positive integer n and a size k < n, and returns a size-k subset of
 * {0,1, 2,..., n - 1).
 *
 * Created by rezaamini on 3/28/17.
 */
public class RandomSubset {

    public static List<Integer> randomSubset(int n, int k) {
        Map<Integer, Integer> randomElements = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            // Generate a random number in [i, n - 1]
            int randomIndex = i + random.nextInt(n - i);
            Integer pointer1 = randomElements.get(randomIndex);
            Integer pointer2 = randomElements.get(i);

            if (pointer1 == null && pointer2 == null) {
                randomElements.put(i, randomIndex);
                randomElements.put(randomIndex, i);
            } else if (pointer1 == null && pointer2 != null) {
                randomElements.put(randomIndex, pointer2);
                randomElements.put(i, randomIndex);
            } else if (pointer1 != null && pointer2 == null) {
                randomElements.put(i, pointer1);
                randomElements.put(randomIndex, i);
            } else {
                randomElements.put(i, pointer1);
                randomElements.put(randomIndex, pointer2);
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(randomElements.get(i));
        }

        return result;
    }

    @Test
    public void testRandomSubset() {
        // Repeat it many times and calculate percentage of times that subset is {0, 1, 2}
        int counter = 0;
        for (int i = 0; i < 100000; i++) {
            List<Integer> randomSubset = randomSubset(6, 3);
            if (randomSubset.contains(0) && randomSubset.contains(1) && randomSubset.contains(2)) {
                counter++;
            }
        }

        // If it is uniform random, percentage should be c(6, 3) = 6!/(3!*3!) = 0.05
        Assert.assertEquals(0.05, counter / 100000.0, 0.001);
    }
}
