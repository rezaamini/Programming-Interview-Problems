package bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Swap ith and jth bit of a long number.
 * \
 * Created by rezaamini on 2/7/17.
 */
public class SwapBits {
    // Time complexity: O(1)
    public static long swapBits(long num, int i, int j) {
        // Check if ith and jth bits are different
        if (((num >>> i) & 1) != ((num >>> j) & 1)) {
            long mask = (1L << i) | (1L << j); // Set ith and jth positions of mask
            // Flip (revert) the ith and jth bits: 0->1 and 1->0
            num ^= mask;
        }

        return num;
    }

    @Test
    public void testSwapBits() {
        Assert.assertEquals(swapBits(42, 2, 3), 38); // 42 = 101010 -> 38 = 100110
        Assert.assertEquals(swapBits(50, 2, 3), 50); // 50 = 101110 -> 50 = 101110
    }
}
