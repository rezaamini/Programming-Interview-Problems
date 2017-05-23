/*

   Implement a stack node.
   
*/

package stacksandqueues;

public class Node<T> {
    public Node next = null;
    public T data;

    public Node (T d) {
        data = d;
    }

    public Node() {

    }
    
    public void appendNode(T d) {
        Node end = new Node(d);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    @Override
    public String toString() {
        Node n = this;
        StringBuilder output = new StringBuilder();
        while(n != null) {
            output.append(" ");
            output.append(n.data);
            n = n.next;
        }

        return new String(output);
    }
}
