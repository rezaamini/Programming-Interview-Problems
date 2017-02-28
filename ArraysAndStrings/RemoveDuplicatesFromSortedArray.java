package ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Write a method that removes duplicates from a sorted array.
 *
 * Created by rezaamini on 2/26/17.
 */
public class RemoveDuplicatesFromSortedArray {
    // Returns size of the result array.
    // Time complexity: O(n), space complexity: O(1)
    public static int removeDuplicates(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        int writeIndex = 1;
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(writeIndex - 1).equals(list.get(i))) {
                list.set(writeIndex++, list.get(i));
            }
        }

        return writeIndex++;
    }

    @Test
    public void testRemoveDuplicated() {
        List<Integer> list = Arrays.asList(1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 6, 7, 7, 8, 8);
        Assert.assertEquals(8, removeDuplicates(list));
    }
}
