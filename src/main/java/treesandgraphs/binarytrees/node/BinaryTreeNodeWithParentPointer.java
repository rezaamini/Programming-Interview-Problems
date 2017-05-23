package treesandgraphs.binarytrees.node;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a binary tree node with parent pointer.
 *
 * Created by rezaamini on 5/21/17.
 */
public class BinaryTreeNodeWithParentPointer<T> {
    @Getter @Setter private T data;
    @Getter @Setter private BinaryTreeNodeWithParentPointer<T> left;
    @Getter @Setter private BinaryTreeNodeWithParentPointer<T> right;
    @Getter @Setter private BinaryTreeNodeWithParentPointer<T> parent;

    public BinaryTreeNodeWithParentPointer(T data) {
        this.data = data;
    }
}
