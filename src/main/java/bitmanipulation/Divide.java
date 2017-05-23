package bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write a method that divides two long numbers without division operation.
 *
 * Created by rezaamini on 2/12/17.
 */
public class Divide {
    // Time complexity: O(n), where n is the number of bits in numbers
    public static long divide(long x, long y) {
        long result = 0;
        int k = 32;
        long yk = y << k; // yk = y * 2^k
        while (x >= y) {
            // Find the largest power of 2 where y * 2^k is smaller than x
            while (yk > x ) {
                yk >>>= 1;
                k--;
            }

            result += 1L << k;
            x -= yk;
        }

        return result;
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(5, divide(25, 5));
        Assert.assertEquals(25, divide(25, 1));
        Assert.assertEquals(2, divide(2, 1));
        Assert.assertEquals(1, divide(1, 1));
        Assert.assertEquals(0, divide(5, 100));
    }
}
