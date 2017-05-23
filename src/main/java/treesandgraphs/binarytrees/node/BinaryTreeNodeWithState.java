package treesandgraphs.binarytrees.node;

import lombok.Getter;
import lombok.Setter;
import treesandgraphs.State;

/**
 * Represents a binary tree node with a property showing its visit state.
 *
 * Created by rezaamini on 5/20/17.
 */
public class BinaryTreeNodeWithState<T> {
    @Getter @Setter private T data;
    @Getter @Setter private BinaryTreeNodeWithState left;
    @Getter @Setter private BinaryTreeNodeWithState right;
    @Getter @Setter private State state;

    public BinaryTreeNodeWithState(T data) {
        this.data = data;
        this.state = State.NOT_VISITED;
    }

    public BinaryTreeNodeWithState(T data, State state) {
        this.data = data;
        this.state = state;
    }
}
