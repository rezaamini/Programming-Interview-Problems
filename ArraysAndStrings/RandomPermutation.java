package ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a positive integer number, return a random permutation of numbers in [0, n-1].
 *
 * Created by rezaamini on 3/27/17.
 */
public class RandomPermutation {
    // Time complexity: O(n), space complexity: O(n)
    public static List<Integer> randomPermutation(int n) {
        List<Integer> permutation = new ArrayList<>(n);
        // Fill the permutation with numbers 0 to n-1
        for(int i = 0; i < n; i++) {
            permutation.add(i);
        }
        // Get an offline random sample of size n from it
        SampleOfflineData.randomSampling(permutation.size(), permutation);
        return permutation;
    }

    @Test
    public void testRandomPermutation() {
        List<Integer> targetPermutation = Arrays.asList(0, 1, 2, 3, 4, 5);
        // Repeat it many times and calculate percentage of times that permutation is {0, 1, 2, 3, 4, 5}
        int counter = 0;
        for (int i = 0; i < 10000; i++) {
            List<Integer> randomPermutation = randomPermutation(6);
            if (targetPermutation.equals(randomPermutation)) {
                counter++;
            }
        }

        // If it is uniform random, percentage should be 1/6! = 0.001389
        Assert.assertEquals(0.00139, counter / 10000.0, 0.001);
    }
}
