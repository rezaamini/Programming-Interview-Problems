package treesandgraphs.binarytrees.node;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;

/**
 * Tests the {@link BinaryTreeNode} class.
 *
 * Created by rezaamini on 5/23/17.
 */
public class BinaryTreeNodeTest {
    @Test
    public void getSize() throws Exception {
        BinaryTreeNode<Integer> tree = TestBinaryTrees.createTestBinaryTree();
        Assert.assertEquals(16, tree.getSize());
    }

}