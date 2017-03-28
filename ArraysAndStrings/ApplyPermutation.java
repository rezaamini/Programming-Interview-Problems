/*

You have two arrays, A and P of size n. Array A, contains arbitrary elements and 
P has all the indexes of A, arranged in an arbitrary order:
A = { a, b, c, d, e, f }
P = { 3, 0, 1, 2, 5, 4 }
We call P a permutation array for A. Applying P to A causes each element of A to 
be mapped to a new position indicated by the value of the corresponding P index.
In the example above, ‘a’ will be mapped to position 3 and ‘b’ to position 0:
P(A) = { b, c, d, a, f, e }
Write an algorithm that can apply a permutation to an array. You cannot use 
additional memory to copy elements of the array but you may use additional 
memory for book keeping purposes.

*/

package ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Write a method that applies a given permutation to an array of positive integers, or characters.
 *
 * Created by rezaamini on 2/26/17.
 */
public class ApplyPermutation
{
    // Time complexity: O(n), space complexity: O(1)
    public static void applyPermutation(List<Integer> permutation, List<Integer> list) {
        if (!isPermutationValid(permutation, list.size())) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < list.size(); i++) {
            int next = i;
            // Check if element at position i is already moved
            while (permutation.get(next) >= 0) {
                Collections.swap(list, i, permutation.get(next));
                int temp = permutation.get(next);
                // Subtract permutation.size() from entries to make sure they become negative
                permutation.set(next, permutation.get(next) - permutation.size());
                next = temp;
            }
        }
    }

    // If we can not use negating the numbers for marking them, we can use O(n) array for marks
    // Time complexity: O(n), space complexity: O(n)
    public static void applyPermutation2(List<Integer> permutation, List<Integer> list) {
        if (!isPermutationValid(permutation, list.size())) {
            throw new IllegalArgumentException();
        }

        boolean[] isDone = new boolean[list.size()];

        for (int i = 0; i < list.size(); i++) {
            int next = i;
            while (!isDone[next]) {
                Collections.swap(list, i, permutation.get(next));
                isDone[permutation.get(next)] = true;
                next = permutation.get(next);
            }
        }
    }

    // If we don't use either of above ways for marking the permuted elements, time complexity increases to O(n^2)
    // We go from left to right and apply the cycle, only if the current position is the leftmost position in cycle
    // Time complexity: O(n^2), space complexity: O(1)
    public static void applyPermutation3(List<Integer> permutation, List<Integer> list) {
        if (!isPermutationValid(permutation, list.size())) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < list.size(); i++) {
            boolean isMin = true;
            int j = permutation.get(i);

            // Find the leftmost element of the cycle
            while (j != i) {
                if (j < i) {
                    isMin = false;
                    break;
                }

                j = permutation.get(j);
            }

            if (isMin) {
                cyclicPermutation(i, permutation, list);
            }
        }
    }

    private static void cyclicPermutation(int start, List<Integer> permutation, List<Integer> list) {
        int i = start;
        int temp = list.get(start);

        do {
            int nextI = permutation.get(i);
            int nextTemp = list.get(nextI);
            list.set(nextI, temp);
            i = nextI;
            temp = nextTemp;
        } while (i != start);
    }

    // Sort P along with A.
    // Time complexity: O(n log n), space complexity: O(1)
    public static void applyPermutation4(List<Integer> permutation, List<Integer> list) {
        if (!isPermutationValid(permutation, list.size())) {
            throw new IllegalArgumentException();
        }

        // Assume that both arrays have valid numbers or check them like above method
        quickSort(list, permutation, 0, permutation.size() - 1);
    }

    // Use quick sort to sort a list along with another list
    // (i.e., as we are sorting permutation list, we do the same swaps on actual list)
    private static void quickSort(List<Integer> list, List<Integer> permutation, int start, int end) {
        int i = start;
        int j = end;
        int pivot = permutation.get(start + (end - start) / 2);
        while (i <= j) {
            while(permutation.get(i) < pivot) {
                i++;
            }
            
            while(permutation.get(j) > pivot) {
                j--;
            }

            if (i <= j) {
                Collections.swap(permutation, i, j);
                Collections.swap(list, i, j);
                i++;
                j--;
            }
        }

        if (start < j) {
            quickSort(list, permutation, start, j);
        }

        if (i < end) {
            quickSort(list, permutation, i, end);
        }
    }

    // Checks validity of the permutation
    private static boolean isPermutationValid(List<Integer> permutation, int listSize) {
        // Check if permutation array is available
        if (listSize != permutation.size()) {
            return false;
        }

        // Check if permutation array is valid
        Set<Integer> duplicateChecker = new HashSet<>();
        for (int i = 0; i < permutation.size(); i++) {
            if (permutation.get(i) < 0 || permutation.get(i) >= listSize) {
                return false;
            }

            if (!duplicateChecker.contains(permutation.get(i))) {
                duplicateChecker.add(permutation.get(i));
            } else {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testApplyPermutation() {
        List<Integer> list = Arrays.asList(5, 7, 1, 2, 8, 9);
        applyPermutation(Arrays.asList(4, 1, 2, 0, 5, 3), list);
        Assert.assertEquals(Arrays.asList(2, 7, 1, 9, 5, 8), list);
    }

    @Test
    public void testApplyPermutation2() {
        List<Integer> list = Arrays.asList(5, 7, 1, 2, 8, 9);
        applyPermutation2(Arrays.asList(4, 1, 2, 0, 5, 3), list);
        Assert.assertEquals(Arrays.asList(2, 7, 1, 9, 5, 8), list);
    }

    @Test
    public void testApplyPermutation3() {
        List<Integer> list = Arrays.asList(5, 7, 1, 2, 8, 9);
        applyPermutation3(Arrays.asList(4, 1, 2, 0, 5, 3), list);
        Assert.assertEquals(Arrays.asList(2, 7, 1, 9, 5, 8), list);
    }

    @Test
    public void testApplyPermutation4() {
        List<Integer> list = Arrays.asList(5, 7, 1, 2, 8, 9);
        applyPermutation4(Arrays.asList(4, 1, 2, 0, 5, 3), list);
        Assert.assertEquals(Arrays.asList(2, 7, 1, 9, 5, 8), list);
    }
}