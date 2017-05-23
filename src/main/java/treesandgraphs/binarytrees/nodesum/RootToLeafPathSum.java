package treesandgraphs.binarytrees.nodesum;

import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Calculate sum of all root to leaf paths in a binary tree. Consider a binary tree in which each node contains a binary
 * digit. A root-to-leaf path can be associated with a binary number—the MSB is at the root. Design an algorithm to
 * compute the sum of the binary numbers represented by the root-to-leaf paths.

 *
 * Created by rezaamini on 5/22/17.
 */
public class RootToLeafPathSum {

    // Time complexity: O(n), where n is number of nodes in the tree.
    // Space complexity: O(h), where h is height of the tree.
    public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
        return sumRootToLeaf(tree, 0);
    }

    private static int sumRootToLeaf(BinaryTreeNode<Integer> tree, int partialPathSum) {
        if (tree == null) {
            return 0;
        }

        partialPathSum = partialPathSum * 2 + tree.getData();

        if (tree.getLeft() == null && tree.getRight() == null) {
            return partialPathSum;
        }

        return sumRootToLeaf(tree.getLeft(), partialPathSum) + sumRootToLeaf(tree.getRight(), partialPathSum);
    }
}
