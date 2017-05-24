package treesandgraphs.binarytrees.node;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a binary tree node.
 *
 * Created by rezaamini on 5/20/17.
 */
@EqualsAndHashCode
public class BinaryTreeNode<T> {

    @Getter @Setter private T data;
    @Getter @Setter private BinaryTreeNode<T> left;
    @Getter @Setter private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this(data);
        this.left = left;
        this.right = right;
    }

    public int getSize() {
        int leftSize = left == null ? 0 : left.getSize();
        int rightSize = right == null ? 0 : right.getSize();

        return 1 + leftSize + rightSize;
    }
}
