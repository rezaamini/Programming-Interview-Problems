package treesandgraphs.binarytrees.traversal;

import treesandgraphs.binarytrees.node.BinaryTreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an inorder traversal sequence and a preorder traversal sequence of a binary tree write a program to reconstruct
 * the tree. Assume each node has a unique key.
 *
 * Created by rezaamini on 5/24/17.
 */
public class ReconstructBinaryTreeFromTraversalData {
    // Time complexity: O(n), where n is size of the tree.
    // Space complexity: O(n)
    public static <T> BinaryTreeNode<T> binaryTreeFromPreorderAndInorder(List<T> preorder, List<T> inorder) {
        Map<T, Integer> nodeToInorderIndex = new HashMap<>();

        // Populate the map
        for (int i = 0; i < inorder.size(); i++) {
            nodeToInorderIndex.put(inorder.get(i), i);
        }

        return binaryTreeFromPreorderAndInorder(preorder, 0, preorder.size(), inorder, 0, inorder.size(),
                nodeToInorderIndex);
    }

    // Builds the subtree with preorder.subList(preorderStart, preorderEnd) & inorder.subList(inorderStart, inorderEnd)
    private static <T> BinaryTreeNode<T> binaryTreeFromPreorderAndInorder(List<T> preorder, int preorderStart,
                                                                          int preorderEnd, List<T> inorder,
                                                                          int inorderStart, int inorderEnd,
                                                                          Map<T, Integer> nodeToInorderIndex) {
        if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }

        int rootIndex = nodeToInorderIndex.get(preorder.get(preorderStart));
        int leftSubtreeSize = rootIndex - inorderStart;

        // Get root data
        T rootData = preorder.get(preorderStart);

        // Build left subtree
        int newPreorderStart = preorderStart + 1;
        int newPreorderEnd = newPreorderStart + leftSubtreeSize;
        BinaryTreeNode<T> leftSubtree = binaryTreeFromPreorderAndInorder(preorder, newPreorderStart, newPreorderEnd,
                inorder, inorderStart, inorderEnd, nodeToInorderIndex);
        // Build right subtree
        BinaryTreeNode<T> rightSubtree = binaryTreeFromPreorderAndInorder(preorder, newPreorderEnd, preorderEnd,
                inorder, rootIndex + 1, inorderEnd, nodeToInorderIndex);

        // Build tree
        return new BinaryTreeNode<>(rootData, leftSubtree, rightSubtree);
    }
}
