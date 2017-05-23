package treesandgraphs.binarytrees.lca;

import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Compute the Lowest Common Ancestor (LCA). Any two nodes in a binary tree have a common ancestor, namely the root.
 * The lowest common ancestor (LCA) of any two nodes in a binary tree is the node furthest from the root that is an
 * ancestor of both nodes.
 *
 * Created by rezaamini on 5/21/17.
 */
public class LowestCommonAncestor<T> {
    private static class LcaStatus<T> {
        int numNodes; // Number of descendant target nodes
        BinaryTreeNode<T> ancestor;

        public LcaStatus(int numNodes, BinaryTreeNode<T> ancestor) {
            this.numNodes = numNodes;
            this.ancestor = ancestor;
        }
    }

    // Time complexity: O(n), where n is number of node in the tree.
    // Space complexity: O(h), where h is height of the tree.
    public static <T> BinaryTreeNode<T> lca(BinaryTreeNode<T> tree, BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        return computeLca(tree, node1, node2).ancestor;
    }

    public static <T> LcaStatus<T> computeLca(BinaryTreeNode<T> tree, BinaryTreeNode<T> node1,
                                              BinaryTreeNode<T> node2) {
        if (tree == null) {
            return new LcaStatus(0, null);
        }

        LcaStatus<T> leftStatus = computeLca(tree.getLeft(), node1, node2);
        if (leftStatus.numNodes == 2) {
            return leftStatus;
        }

        LcaStatus<T> rightResult = computeLca(tree.getRight(), node1, node2);
        if (rightResult.numNodes == 2) {
            return rightResult;
        }

        int numNodes = leftStatus.numNodes + rightResult.numNodes + (tree == node1 ? 1 : 0) + (tree == node2 ? 1 : 0);
        return new LcaStatus(numNodes, (numNodes == 2 ? tree : null));
    }
}
