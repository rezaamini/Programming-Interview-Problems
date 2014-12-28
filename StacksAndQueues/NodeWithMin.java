/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Stacks_And_Queues;

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
