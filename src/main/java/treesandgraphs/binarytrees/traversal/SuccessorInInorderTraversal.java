package treesandgraphs.binarytrees.traversal;

import treesandgraphs.binarytrees.node.BinaryTreeNodeWithParentPointer;

/**
 * Finds the successor of a node in inorder traversal. Assume that nodes have parent pointer.
 *
 * Created by rezaamini on 5/23/17.
 */
public class SuccessorInInorderTraversal {
    // Time complexity: O(h), where h is height of the tree.
    public static <T> BinaryTreeNodeWithParentPointer<T> successor(BinaryTreeNodeWithParentPointer<T> node) {
        BinaryTreeNodeWithParentPointer<T> current = node;
        // If node has a right child, successor is the left most child of the right child
        if (current.getRight() != null) {
            current = current.getRight();
            while (current.getLeft() != null) {
                current = current.getLeft();
            }
            return current;
        }

        // Node does not have a right child
        // If node is right child of its parent, go up until current node is left child of its parent
        while (current.getParent() != null && current.getParent().getRight() == current) {
            current = current.getParent();
        }

        // Return value of null means node is the right most node in the tree
        return current.getParent();
    }
}
