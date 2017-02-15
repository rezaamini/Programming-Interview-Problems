package ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a method that multiplies two arrays of digits that represent two decimal numbers.
 *
 * Created by rezaamini on 2/14/17.
 */
public class MultiplyDecimalArrays {
    // Time complexity: O(nm), where n and m are sizes of input lists
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        int sign = num1.get(0) > 0 ^ num2.get(0) > 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        // Perform the multiplication
        for (int i = num1.size() - 1; i >= 0; i--) {
            for (int j = num2.size() - 1; j >= 0; j--) {
                result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }
        }

        // Remove leading zeroes
        int firstZeroIndex = 0;
        while (firstZeroIndex < result.size() && result.get(firstZeroIndex) == 0) {
            firstZeroIndex++;
        }

        result = result.subList(firstZeroIndex, result.size());
        if (result.isEmpty()) {
            return Arrays.asList(0);
        }

        // Update the sign
        result.set(0, result.get(0) * sign);

        return result;
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(Arrays.asList(1, 2, 1), multiply(Arrays.asList(1, 1), Arrays.asList(1, 1)));
        Assert.assertEquals(Arrays.asList(5, 3, 3, 2, 1, 1, 4), multiply(Arrays.asList(1, 2, 3, 4), Arrays.asList(4, 3, 2, 1)));
        Assert.assertEquals(Arrays.asList(9, 8, 0, 1), multiply(Arrays.asList(9, 9), Arrays.asList(9, 9)));
        Assert.assertEquals(Arrays.asList(1, 2), multiply(Arrays.asList(4), Arrays.asList(3)));
    }
}
