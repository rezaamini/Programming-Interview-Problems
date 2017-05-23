package bitmanipulation;


import org.junit.Assert;
import org.junit.Test;

/**
 * Parity of a binary word is 1 if number of 1s in the word is odd; otherwise, it is 0.
 *
 * Created by rezaamini on 2/7/17.
 */
public class Parity {
    // Time complexity: O(log n), where n is number of bits in number
    public static short parity(long num) {
        // parity of an n bit number is equal to parity of XOR of the first and second n/2 bits
        // Because long is 64 bits, we divide it into 2 parts of 32 bits and XOR them
        num ^= num >>> 32;
        // Keep doing that again and again until there is only one digit left
        num ^= num >>> 16;
        num ^= num >>> 8;
        num ^= num >>> 4;
        num ^= num >>> 2;
        num ^= num >>> 1;

        // Check the parity of the least significant bit
        return (short)(num & 0x1);
    }

    @Test
    public void testParity() {
        Assert.assertEquals(1, parity(76L));
        Assert.assertEquals(0, parity(78L));
    }
}
