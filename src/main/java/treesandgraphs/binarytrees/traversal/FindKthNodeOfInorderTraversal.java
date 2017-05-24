package treesandgraphs.binarytrees.traversal;

import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Computes the K'th node in an inorder traversal.
 *
 * Created by rezaamini on 5/23/17.
 */
public class FindKthNodeOfInorderTraversal {
    // Time complexity: O(h), where h is number of nodes in the tree.
    // Space complexity: O(h), due to getSize recursion.
    public static <T>BinaryTreeNode<T> findKthNodeOfInorderTraversal(BinaryTreeNode<T> tree, int k) {
        BinaryTreeNode<T> current = tree;

        while (current != null) {
            int leftSize = (current.getLeft() == null) ? 0 : current.getLeft().getSize();

            if (leftSize + 1 < k) { // k'th node is in the right sub-tree
                current = current.getRight();
                k -= (leftSize + 1);
            } else if (leftSize == k - 1) { // k'th node is the current node
                return current;
            } else { // k'th node is in the left sub-tree
                current = current.getLeft();
            }
        }
        // k is not between 1 and tree size
        return null;
    }
}
