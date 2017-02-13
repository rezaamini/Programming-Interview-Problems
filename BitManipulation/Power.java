package BitManipulation;

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
}
