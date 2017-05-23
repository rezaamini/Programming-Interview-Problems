package treesandgraphs.binarytrees.traversal;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;

/**
 * Tests InOrder traversal.
 *
 * Created by rezaamini on 5/20/17.
 */
public class InOrderTest {

    @Test
    public void inOrderRecursiveTraversalTest() {
        Integer[] expected = {28, 271, 0, 6, 561, 17, 3, 314, 2, 401, 641, 1, 257, 6, 271, 28};
        Assert.assertArrayEquals(expected, InOrder.traverseRecursive(TestBinaryTrees.createTestBinaryTree())
                .toArray(new Integer[expected.length]));
    }

    @Test
    public void inOrderIterativeTraversalTest() {
        Integer[] expected = {28, 271, 0, 6, 561, 17, 3, 314, 2, 401, 641, 1, 257, 6, 271, 28};
        Assert.assertArrayEquals(expected, InOrder.traverseIterative(TestBinaryTrees.createTestBinaryTreeWithState())
                .toArray(new Integer[expected.length]));
    }
}
