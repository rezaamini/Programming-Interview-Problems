/*

   Implement a stack

 */

package stacksandqueues;

/**
 *
 * @author Reza Amini
 */
public class Stack {
    Node top;
    private int size;

    public Node pop() {
        if (top != null) {
            Node item = new Node(top.data);
            top = top.next;
            size--;
            return item;
        }
        return null;
    }

    public void push(int d) {
        Node item = new Node(d);
        item.next = top;
        top = item;
        size++;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public Node peek() {
        if (top != null) {
            Node item = new Node(top.data);
            return item;
        }
        return null;
    }

    public int size(){
        return size;
    }
}
