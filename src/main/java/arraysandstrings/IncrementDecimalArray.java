package arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a method that takes as input an array of digits encoding a decimal number D and updates the array to represent
 * D + 1. For example {1, 2, 9} -> {1, 3, 0} and {9, 9} -> {1, 0, 0}
 *
 * Created by rezaamini on 2/14/17.
 */
public class IncrementDecimalArray {
    // Time complexity: O(n), Space complexity: O(1)
    public static List<Integer> plusOne(List<Integer> number) {
        int lsd = number.size() - 1;
        number.set(lsd, number.get(lsd) + 1);

        // Take care of possible carries
        for (int i = lsd; i > 0 && number.get(i) == 10; i--) {
            number.set(i, 0);
            number.set(i - 1, number.get(i - 1) + 1);
        }

        // Insert a one to the MSD
        if (number.get(0) == 10) {
            number.set(0, 0);
            number.add(0, 1);
        }

        return number;
    }

    @Test
    public void testPlusOne() {
        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(9);
        Assert.assertEquals(Arrays.asList(1, 3, 0), plusOne(number));

        number = new ArrayList<>();
        number.add(9);
        number.add(9);
        Assert.assertEquals(Arrays.asList(1, 0, 0), plusOne(number));

        number = new ArrayList<>();
        number.add(0);
        Assert.assertEquals(Arrays.asList(1), plusOne(number));

        number = new ArrayList<>();
        number.add(1);
        number.add(2);
        Assert.assertEquals(Arrays.asList(1, 3), plusOne(number));

    }
}
