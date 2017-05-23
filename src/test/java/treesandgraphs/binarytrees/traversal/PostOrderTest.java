package treesandgraphs.binarytrees.traversal;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;

/**
 * Test PostOrder class.
 *
 * Created by rezaamini on 5/20/17.
 */
public class PostOrderTest {
    @Test
    public void inOrderRecursiveTraversalTest() {
        Integer[] expected = {28, 0, 271, 17, 3, 561, 6, 641, 401, 257, 1, 2, 28, 271, 6, 314};
        Assert.assertArrayEquals(expected, PostOrder.traverseRecursive(TestBinaryTrees.createTestBinaryTree())
                .toArray(new Integer[expected.length]));
    }

    @Test
    public void inOrderIterativeTraversalTest() {
        Integer[] expected = {28, 0, 271, 17, 3, 561, 6, 641, 401, 257, 1, 2, 28, 271, 6, 314};
        Assert.assertArrayEquals(expected, PostOrder.traverseIterative(TestBinaryTrees.createTestBinaryTreeWithState())
                .toArray(new Integer[expected.length]));
    }
}
