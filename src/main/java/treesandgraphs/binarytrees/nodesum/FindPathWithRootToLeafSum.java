package treesandgraphs.binarytrees.nodesum;

import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Finds a root to leaf path with specified sum.
 *
 * Created by rezaamini on 5/23/17.
 */
public class FindPathWithRootToLeafSum {
    // Time complexity: O(n), where n is number of nodes in the tree.
    // Space complexity: O(h), where h is height of the tree.
    public static boolean hasPathWithSum(BinaryTreeNode<Integer> tree, int targetSum) {
        return hasPathWithSum(tree, 0, targetSum);
    }

    private static boolean hasPathWithSum(BinaryTreeNode<Integer> tree, int partialSum, int targetSum) {
        if (tree == null) {
            return false;
        }

        partialSum += tree.getData();

        if (tree.getLeft() == null && tree.getRight() == null) {
            return partialSum == targetSum;
        }

        return hasPathWithSum(tree.getLeft(), partialSum, targetSum)
                || hasPathWithSum(tree.getRight(), partialSum, targetSum);
    }
}
