package arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a method that computes the next permutation of a given array in a dictionary roder.
 *
 * Created by rezaamini on 2/28/17.
 */
public class ComputeNextPermutation {

    // (1) Find k such that p[k] < p[k + 1] and entries after index k appear in decreasing order.
    // (2) Find the smallest p[l] such that p[l] > p[k].
    // (3) Swap p[l] and p[k].
    // (4) Reverse the sequence after position k.
    // Time complexity: O(n), space complexity: O(1)
    public static List<Integer> nextPermutation(List<Integer> list) {
        // First step
        int k = list.size() - 2;
        while (k >= 0 && list.get(k) >= list.get(k + 1)) {
            k--;
        }

        if (k == -1) {
            // There is no next permutation
            return Collections.emptyList();
        }

        // Second and third steps
        for (int i = list.size() - 1; i > k; i--) {
            if (list.get(i) > list.get(k)) {
                Collections.swap(list, i, k);
                break;
            }
        }

        // Fourth step
        Collections.reverse(list.subList(k + 1, list.size()));
        return list;
    }

    @Test
    public void testNextPermutation() {
        List<Integer> list = Arrays.asList(6, 2, 1, 5, 4, 3, 0);
        Assert.assertEquals(Arrays.asList(6, 2, 3, 0, 1, 4, 5), nextPermutation(list));
    }
}
