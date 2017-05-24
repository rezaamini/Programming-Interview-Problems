package treesandgraphs.binarytrees.traversal;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;
import treesandgraphs.binarytrees.node.BinaryTreeNode;

import java.util.Arrays;

/**
 * Tests {@link ReconstructBinaryTreeFromTraversalData} class.
 *
 * Created by rezaamini on 5/24/17.
 */
public class ReconstructBinaryTreeFromTraversalDataTest {
    @Test
    public void binaryTreeFromPreorderAndInorder() throws Exception {
        BinaryTreeNode<Integer> expected = TestBinaryTrees.createTestBinaryTreeWithUniqueNodes();
        Integer[] preorder = {314, 6, 271, 28, 0, 561, 3, 17, 7, 2, 1, 401, 641, 257, 272, 29};
        Integer[] inorder = {28, 271, 0, 6, 561, 17, 3, 314, 2, 401, 641, 1, 257, 7, 272, 29};

        Assert.assertEquals(expected, ReconstructBinaryTreeFromTraversalData
                .binaryTreeFromPreorderAndInorder(Arrays.asList(preorder), Arrays.asList(inorder)));
    }

}