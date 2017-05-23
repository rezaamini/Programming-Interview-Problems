package treesandgraphs.binarytrees.traversal;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;

/**
 * Tests PreOrder class.
 *
 * Created by rezaamini on 5/20/17.
 */
public class PreOrderTest {

    @Test
    public void inOrderRecursiveTraversalTest() {
        Integer[] expected = {314, 6, 271, 28, 0, 561, 3, 17, 6, 2, 1, 401, 641, 257, 271, 28};
        Assert.assertArrayEquals(expected, PreOrder.traverseRecursive(TestBinaryTrees.createTestBinaryTree())
                .toArray(new Integer[expected.length]));
    }

    @Test
    public void inOrderIterativeTraversalTest() {
        Integer[] expected = {314, 6, 271, 28, 0, 561, 3, 17, 6, 2, 1, 401, 641, 257, 271, 28};
        Assert.assertArrayEquals(expected, PreOrder.traverseIterative(TestBinaryTrees.createTestBinaryTree())
                .toArray(new Integer[expected.length]));
    }
}
