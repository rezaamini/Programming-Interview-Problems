package treesandgraphs.binarytrees.nodesum;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;
import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Tests FindPathWithRootToLeafSum class.
 *
 * Created by rezaamini on 5/23/17.
 */
public class FindPathWithRootToLeafSumTest {
    @Test
    public void hasPathWithSum() throws Exception {
        BinaryTreeNode<Integer> tree = TestBinaryTrees.createTestBinaryTree();
        Assert.assertTrue(FindPathWithRootToLeafSum.hasPathWithSum(tree, 580));
        Assert.assertFalse(FindPathWithRootToLeafSum.hasPathWithSum(tree, 23));
    }

}