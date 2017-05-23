package treesandgraphs.binarytrees.node;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a binary tree node.
 *
 * Created by rezaamini on 5/20/17.
 */
public class BinaryTreeNode<T> {

    @Getter @Setter private T data;
    @Getter @Setter private BinaryTreeNode<T> left;
    @Getter @Setter private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
