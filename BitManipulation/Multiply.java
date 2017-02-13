package BitManipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write a multiply method that multiplies two long numbers without using add and multiply operators.
 *
 * Created by rezaamini on 2/9/17.
 */
public class Multiply {
    // Time complexity: O(n^2), where n is the number of bits in numbers.
    public static long multiply(long a, long b) {
        long result = 0;
        while (a != 0) {
            // Check if first bit of a is 1
            if ((a & 1) != 0) {
                result = Add.add(result, b);
            }

            a >>>= 1;
            b <<= 1; // Multiply b to 2^k, where k is the current bit position
        }

        return result;
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(12L, multiply(3L, 4L));
        Assert.assertEquals(10L, multiply(10L, 1L));
        Assert.assertEquals(0L, multiply(11L, 0L));
        Assert.assertEquals(1L, multiply(1L, 1L));
        Assert.assertEquals(4L, multiply(2L, 2L));
    }

}
