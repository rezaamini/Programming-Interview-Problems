package BitManipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write an add method that does not use add operation.
 *
 * Created by rezaamini on 2/9/17.
 */
public class Add {
    // Time complexity: O(n), where n is the number of bits in numbers.
    public static long add(long a, long b) {
        long tempA = a;
        long tempB = b;
        long mask = 1;
        long carryIn = 0;
        long sum = 0;

        while(tempA != 0 || tempB != 0) {
            long maskedA = a & mask;
            long maskedB = b & mask;
            long carryOut = (maskedA & maskedB) | (maskedA & carryIn) | (maskedB & carryIn);
            sum |= (maskedA ^ maskedB ^ carryIn);

            carryIn = carryOut << 1;
            mask <<= 1;
            tempA >>>= 1;
            tempB >>>= 1;
        }

        return sum | carryIn;
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(27L, add(13L, 14L));
        Assert.assertEquals(1L, add(1L, 0L));
        Assert.assertEquals(0L, add(0L, 0L));
        Assert.assertEquals(2L, add(1L, 1L));
        Assert.assertEquals(12L, add(4L, 8L));
    }
}
