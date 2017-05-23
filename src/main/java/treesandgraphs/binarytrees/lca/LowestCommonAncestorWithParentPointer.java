package treesandgraphs.binarytrees.lca;

import treesandgraphs.binarytrees.node.BinaryTreeNodeWithParentPointer;

/**
 * Finds lowest common ancestor of two nodes that have parent pointers in a binary tree.
 *
 * Created by rezaamini on 5/21/17.
 */
public class LowestCommonAncestorWithParentPointer {
    // Time complexity: O(h), where h is height of the tree. Space complexity: O(1).
    public static <T>BinaryTreeNodeWithParentPointer<T> lca(BinaryTreeNodeWithParentPointer<T> node1,
                                                            BinaryTreeNodeWithParentPointer<T> node2) {
        int depth1 = getDepth(node1);
        int depth2 = getDepth(node2);

        // Make depth2 the deeper node to simplify the code
        if (depth1 > depth2) {
            BinaryTreeNodeWithParentPointer<T> temp = node1;
            node1 = node2;
            node2 = temp;
        }

        // Ascend from the deeper node until they are in the same depth
        int diff = Math.abs(depth2 - depth1);
        while (diff > 0) {
            node2 = node2.getParent();
            diff--;
        }

        // Ascend both nodes at the same time until LCA is found
        while (node1 != node2) {
            node1 = node1.getParent();
            node2 = node2.getParent();
        }

        return node2;
    }

    private static <T> int getDepth(BinaryTreeNodeWithParentPointer<T> node) {
        int depth = -1;
        BinaryTreeNodeWithParentPointer<T> current = node;
        while(current != null) {
            current = current.getParent();
            depth++;
        }

        return depth;
    }
}
