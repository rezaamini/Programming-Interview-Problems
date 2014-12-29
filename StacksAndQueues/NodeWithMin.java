/*
   
   Implement a stack node that has an extra property which keeps the stack min.
   
 */

package StacksAndQueues;

/**
 *
 * @author Reza
 */
class NodeWithMin {
    NodeWithMin next = null;
    int data;
    int min;

    public NodeWithMin(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        NodeWithMin n = this;
        StringBuilder output = new StringBuilder();
        while(n != null) {
            output.append(" ");
            output.append(n.data);
            n = n.next;
        }

        return new String(output);
    }
}
