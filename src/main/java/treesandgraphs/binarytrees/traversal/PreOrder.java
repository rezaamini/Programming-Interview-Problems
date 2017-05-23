package treesandgraphs.binarytrees.traversal;

import treesandgraphs.binarytrees.node.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Traverses a binary tree in pre-order manner (root, left, right).
 *
 * Created by rezaamini on 5/20/17.
 */
public class PreOrder {

    public static <T> List<T> traverseRecursive(BinaryTreeNode<T> tree) {
        List<T> result = new LinkedList<>();
        traverseRecursive(tree, result);
        return result;
    }

    private static <T> void traverseRecursive(BinaryTreeNode<T> tree, List<T> result) {
        if (tree == null) {
            return;
        }

        result.add(tree.getData());
        traverseRecursive(tree.getLeft(), result);
        traverseRecursive(tree.getRight(), result);
    }

    public static <T> List<T> traverseIterative(BinaryTreeNode<T> tree) {
        Deque<BinaryTreeNode<T>> stack = new LinkedList<>();
        List<T> result = new LinkedList<>();
        stack.push(tree);

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> current = stack.pop();
            if (current != null) {
                result.add(current.getData());
                stack.push(current.getRight());
                stack.push(current.getLeft());
            }
        }

        return result;
    }
}
