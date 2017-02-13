package BitManipulation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a method that generates a uniform random integer between a and b inclusive, assuming that a method is available
 * that provides a uniform-random 0 or 1.
 *
 * Created by rezaamini on 2/12/17.
 */
public class UniformRandom {
    // Use a random 0-1 generator to generate individual bits of the numbers between a and b.
    // If (b - a + 1) >= generated number, create all the bits again.

    // Probability that more than k tries are needed is less than or equal to 1/2^k.
    // Number of tries: O(1)
    // Each try calls the 0-1 random generator log(b - a + 1) times
    // Time complexity: O(log(b - a + 1)).
    public static int uniformRandom(int lowerBound, int upperBound) {
        int length = upperBound - lowerBound + 1;
        int result;
        do {
            result = 0;
            for (int i = 0; (1 << i) < length; i++) {
                result = (result << 1) | zeroOneRandom();
            }
        } while(result >= length);

        return result + lowerBound;
    }

    /**
     * We can assume this method is already given to us.
     */
    public static int zeroOneRandom() {
        Random random = new Random();
        return random.nextInt(2);
    }

    @Test
    public void testRandom() {
        int a = 5;
        int b = 14;
        int[] randoms = new int[b - a + 1];
        Arrays.fill(randoms, 0);

        for (int i = 0; i < 1000000; i++) {
            int random = uniformRandom(a, b);
            randoms[random - a]++;
        }

        for (int i = 0; i < randoms.length; i++) {
            Assert.assertTrue((randoms[i] / 1000000) - 0.1 < 0.001);
        }
    }
}
