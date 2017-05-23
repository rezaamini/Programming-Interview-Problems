package bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write a method that reverses digits of an integer number.
 *
 * Created by rezaamini on 2/12/17.
 */
public class Reverse {
    // Time complexity: O(n)
    public static int reverse(int a) {
        int result = 0;
        int remaining = Math.abs(a);
        while (remaining != 0) {
            result = result * 10 + remaining % 10;
            remaining /= 10;
        }
        return a < 0 ? -result : result;
    }

    @Test
    public void testReverse() {
        Assert.assertEquals(12345, reverse(54321));
        Assert.assertEquals(1, reverse(1));
        Assert.assertEquals(0, reverse(0));
        Assert.assertEquals(-12345, reverse(-54321));
        Assert.assertEquals(-1, reverse(-1));
    }
}
