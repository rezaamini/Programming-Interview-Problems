package bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write a method that calculates x to the power of y.
 *
 * Created by rezaamini on 2/12/17.
 */
public class Power {
    // Time complexity: O(n)
    public static double power(double x, int y) {
        double result = 1.0;
        long power = y;

        // Takes care of negative powers
        if (y < 0) {
            power = -power;
            x = 1.0 / x;
        }

        while (power != 0) {
            // If power is odd, result = x * x^(power/2) * x^(power/2)
            // If power is even, result = x^(power/2) * x^(power/2)
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }

        return result;
    }

    @Test
    public void testPower() {
        Assert.assertEquals(32, power(2, 5), 0.0001);
        Assert.assertEquals(9, power(3, 2), 0.0001);
        Assert.assertEquals(27, power(3, 3), 0.0001);
        Assert.assertEquals(1, power(1, 0), 0.0001);
        Assert.assertEquals(0.008, power(5, -3), 0.0001);
    }
}
