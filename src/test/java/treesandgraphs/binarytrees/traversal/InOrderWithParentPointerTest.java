package treesandgraphs.binarytrees.traversal;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;
import treesandgraphs.binarytrees.node.BinaryTreeNodeWithParentPointer;

/**
 * Tests {@link InOrderWithParentPointer} class.
 *
 * Created by rezaamini on 5/24/17.
 */
public class InOrderWithParentPointerTest {
    @Test
    public void traverseTest() throws Exception {
        BinaryTreeNodeWithParentPointer<Integer> tree = TestBinaryTrees.createTestBinaryTreeWithParentPointer();
        Integer[] expected = {28, 271, 0, 6, 561, 17, 3, 314, 2, 401, 641, 1, 257, 6, 271, 28};
        Assert.assertArrayEquals(expected, InOrderWithParentPointer.traverse(tree)
                .toArray(new Integer[expected.length]));
    }

}