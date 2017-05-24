package treesandgraphs.binarytrees.traversal;

import treesandgraphs.binarytrees.node.BinaryTreeNodeWithParentPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Traverses a binary tree with parent pointers in O(1) space complexity.
 *
 * Created by rezaamini on 5/24/17.
 */
public class InOrderWithParentPointer {
    // Time complexity: O(n), where n is size of the tree.
    // Space complexity: O(1).
    public static <T> List<T> traverse(BinaryTreeNodeWithParentPointer<T> tree) {
        BinaryTreeNodeWithParentPointer<T> previous = null;
        BinaryTreeNodeWithParentPointer<T> current = tree;
        List<T> result = new ArrayList<>();

        while (current != null) {
            BinaryTreeNodeWithParentPointer<T> next;
            // If coming down from previous
            if (current.getParent() == previous) {
                // If there is a left node, go more down to left
                if (current.getLeft() != null) {
                    next = current.getLeft();
                } else {
                    result.add(current.getData());
                    // Done with left and current. Go to right, if there is a right node, otherwise, go up.
                    next = current.getRight() != null ? current.getRight() : current.getParent();
                }
            } else if (current.getLeft() == previous) { // Coming back left child
                result.add(current.getData());
                // Done with left and current. GO to right, if there is a right node, otherwise, go up.
                next = current.getRight() != null ? current.getRight() : current.getParent();
            } else { // Coming back from right child (Done with both children)
                next = current.getParent();
            }

            previous = current;
            current = next;
        }

        return result;
    }
}
