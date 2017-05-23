package arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Write a method that takes as input an array of distinct elements and a size, and returns a subset of the given size
 * of the array elements. All subsets should be equally likely. Return the result in input array itself.
 *
 * Created by rezaamini on 2/28/17.
 */
public class SampleOfflineData {
    public static void randomSampling(int k, List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            Collections.swap(list, i, random.nextInt(list.size() - i));
        }
    }

    @Test
    public void testRandomSampling() {
        List<Integer> list = Arrays.asList(4, 5, 6, 7, 8, 9);
        // Repeat it many times and calculate percentage of times that 4, 5, 6 come in the beginning
        int counter = 0;
        for (int i = 0; i < 10000; i++) {
            randomSampling(3, list);
            if (list.get(0) == 4 && list.get(1) == 5 && list.get(2) == 6) {
                counter++;
            }
        }

        // If it is uniform random, percentage should be (1/6)*(1/5)*(1/4) = 0.0083333
        Assert.assertEquals(0.008, counter / 10000.0, 0.001);
    }
}
