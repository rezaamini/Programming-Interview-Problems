package treesandgraphs.binarytrees.balance;

import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Checks if a binary tree is symmetric. A binary tree is symmetric if you can draw a vertical line through the root and
 * then the left subtree is the mirror image of the right subtree.
 *
 * Created by rezaamini on 5/20/17.
 */
public class CheckSymmetric {
    // Time complexity: O(n), where n is number of nodes in the tree.
    // Space complexity: O(h), where h is height of the tree.
    public static <T> boolean isSymmetric(BinaryTreeNode<T> tree) {
        return tree == null || isSymmetric(tree.getLeft(), tree.getRight());
    }

    private static <T> boolean isSymmetric(BinaryTreeNode<T> leftSubTree, BinaryTreeNode<T> rightSubTree) {
        // Leaf node
        if (leftSubTree == null && rightSubTree == null) {
            return true;
        }

        if (leftSubTree != null && rightSubTree != null) {
            // One's right is equal to other's left and vice versa
            return (leftSubTree.getData().equals(rightSubTree.getData()))
                    && isSymmetric(leftSubTree.getLeft(), rightSubTree.getRight())
                    && isSymmetric(leftSubTree.getRight(), rightSubTree.getLeft());
        }

        // One is null, the other is not null
        return false;
    }
}
