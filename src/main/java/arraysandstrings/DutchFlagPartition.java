package arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a method that partitions a list of colors to smaller, equal, and larger that a given pivot.
 *
 * Created by rezaamini on 2/14/17.
 */
public class DutchFlagPartition {
    public static enum Color {
        RED, WHITE, BLUE
    }

    // Time complexity: O(n), Space complexity: O(1)
    public static void dutchFlagPartition(int pivotIndex, List<Color> list) {
        if (list.size() <= pivotIndex) {
            return;
        }

        Color pivot = list.get(pivotIndex);
        int smallPointer = 0;
        int equalPointer = 0;
        int largePointer = list.size() - 1;

        while (equalPointer < largePointer) {
            if (list.get(equalPointer).ordinal() < pivot.ordinal()) {
                Collections.swap(list, equalPointer++, smallPointer++);
            } else if (list.get(equalPointer).ordinal() == pivot.ordinal()) {
                equalPointer++;
            } else { // list.get(equalPointer).ordinal() > pivot.ordinal()
                Collections.swap(list, equalPointer, largePointer--);
            }
        }
    }

    @Test
    public void testDutchFlagPartition() {
        Color[] list = {Color.WHITE, Color.BLUE, Color.RED, Color.BLUE, Color.RED, Color.WHITE, Color.WHITE, Color.BLUE, Color.RED};
        int pivotIndex = 0;
        Color[] expected = {Color.RED, Color.RED, Color.RED, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE};
        dutchFlagPartition(pivotIndex, Arrays.asList(list));
        Assert.assertArrayEquals(expected, list);
    }
}
