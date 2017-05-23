package arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Write a method that takes as input a size k, and reads packets, continuously maintaining a uniform random subset of
 * size k of the read packets.
 *
 * Created by rezaamini on 3/27/17.
 */
public class SampleOnlineData {

    // Time complexity: O(n), space complexity: O(k)
    public static List<Integer> onlineRandomSample(Iterator<Integer> sequence, int k) {
        List<Integer> onlineSample = new ArrayList<>(k);
        // Add the first k numbers to the online sample
        for (int i = 0; sequence.hasNext() && i < k; i++) {
            onlineSample.add(sequence.next());
        }

        int numSeenSoFar = k;
        Random random = new Random();
        while (sequence.hasNext()) {
            Integer next = sequence.next();
            numSeenSoFar++;
            // Generate a random number in [0, numSeenSoFar]
            int randomIndex = random.nextInt(numSeenSoFar);
            // If random number is in [0, k-1], replace x with that number in online sample.
            if (randomIndex < k) {
                onlineSample.set(randomIndex, next);
            }
        }

        return onlineSample;
    }

    @Test
    public void testOnlineRandomSample() {
        int counter = 0;
        for (int i = 0; i < 100000; i++) {
            Iterator<Integer> sequence = Arrays.asList(4, 5, 6, 7, 8, 9).iterator();
            // Repeat it many times and calculate percentage of times that 4, 5, 6 are selected
            List<Integer> onlineSample = onlineRandomSample(sequence, 3);
            if (onlineSample.contains(4) && onlineSample.contains(5) && onlineSample.contains(6)) {
                counter++;
            }
        }

        // If it is uniform random, percentage should be 1/c(3,6)= 6!/(3!*3!) = 0.05
        Assert.assertEquals(0.05, counter / 100000.0, 0.001);
    }
}
