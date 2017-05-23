package treesandgraphs.binarytrees.traversal;

import treesandgraphs.State;
import treesandgraphs.binarytrees.node.BinaryTreeNode;
import treesandgraphs.binarytrees.node.BinaryTreeNodeWithState;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Traverses a binary tree in post-order manner (left, right, root).
 *
 * Created by rezaamini on 5/20/17.
 */
public class PostOrder {
    public static <T> List<T> traverseRecursive(BinaryTreeNode<T> tree) {
        List<T> result = new LinkedList<>();
        traverseRecursive(tree, result);
        return result;
    }

    private static <T> void traverseRecursive(BinaryTreeNode<T> tree, List<T> result) {
        if (tree == null) {
            return;
        }

        traverseRecursive(tree.getLeft(), result);
        traverseRecursive(tree.getRight(), result);
        result.add(tree.getData());
    }

    public static <T> List<T> traverseIterative(BinaryTreeNodeWithState<T> tree) {
        Deque<BinaryTreeNodeWithState<T>> stack = new LinkedList<>();
        List<T> result = new LinkedList<>();
        stack.push(tree);

        while(!stack.isEmpty()) {
            BinaryTreeNodeWithState<T> current = stack.pop();
            if (current != null) {
                if (current.getState() == State.VISITED) {
                    result.add(current.getData());
                } else {
                    current.setState(State.VISITED);
                    stack.push(current);
                    stack.push(current.getRight());
                    stack.push(current.getLeft());
                }
            }
        }

        return result;
    }
}
