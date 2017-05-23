package treesandgraphs.binarytrees.balance;

import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Checks if a binary tree is height-balanced. A binary tree is said to be height-balanced if for each node in the tree,
 * the difference in the height of its left and right subtrees is at most one.
 *
 * Created by rezaamini on 5/20/17.
 */
public class CheckHeightBalanced {

    private static class BalanceStatusWithHeight {
        boolean balanced;
        int height;

        public BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    // Time complexity: O(n), where n is number of nodes in tree.
    // Space complexity: O(h), where h is height of the tree.
    public static <T> boolean isHeightBalanced(BinaryTreeNode<T> tree) {
        return checkHeightBalanced(tree).balanced;
    }

    public static <T> BalanceStatusWithHeight checkHeightBalanced(BinaryTreeNode<T> tree) {
        if (tree == null) {
            return new BalanceStatusWithHeight(true, -1);
        }

        BalanceStatusWithHeight leftBalanceStatus = checkHeightBalanced(tree.getLeft());
        if (!leftBalanceStatus.balanced) {
            return leftBalanceStatus;
        }

        BalanceStatusWithHeight rightBalanceStatus = checkHeightBalanced(tree.getRight());
        if (!rightBalanceStatus.balanced) {
            return rightBalanceStatus;
        }

        boolean isBalanced = Math.abs(leftBalanceStatus.height - rightBalanceStatus.height) <= 1;
        int height = Math.max(leftBalanceStatus.height, rightBalanceStatus.height) + 1;
        return new BalanceStatusWithHeight(isBalanced, height);
    }
}
