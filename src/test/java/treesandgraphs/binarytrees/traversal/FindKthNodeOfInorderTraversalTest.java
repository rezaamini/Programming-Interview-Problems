package treesandgraphs.binarytrees.traversal;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;
import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Tests {@link FindKthNodeOfInorderTraversal} class.
 *
 * Created by rezaamini on 5/23/17.
 */
public class FindKthNodeOfInorderTraversalTest {
    @Test
    public void findKthNodeOfInorderTraversal() throws Exception {
        BinaryTreeNode<Integer> tree = TestBinaryTrees.createTestBinaryTree();
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 1).getData() == 28);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 2).getData() == 271);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 3).getData() == 0);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 4).getData() == 6);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 5).getData() == 561);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 6).getData() == 17);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 7).getData() == 3);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 8).getData() == 314);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 9).getData() == 2);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 10).getData() == 401);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 11).getData() == 641);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 12).getData() == 1);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 13).getData() == 257);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 14).getData() == 6);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 15).getData() == 271);
        Assert.assertTrue(FindKthNodeOfInorderTraversal.findKthNodeOfInorderTraversal(tree, 16).getData() == 28);
    }

}