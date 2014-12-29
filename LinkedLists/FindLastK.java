/*

   Implement an algorithm to find the nth to last element of a linked list.
 
*/

package LinkedLists;

/**
 *
 * @author Reza Amini
 */
public class FindLastK {
    public static void main(String[] args) {
        Node node = new Node(0);
        for (int i = 1 ; i < 10 ; i++) {
            node.appendNode(i);
        }

        System.out.println(FindLastN(node, 3));
    }

    // Time complexity: O(n)
    public static Node FindLastN(Node node, int n) {
        if (node == null || n < 1)
            return null;
        
        Node current = node;
        for (int i = 0 ; i < n - 1 ; i++) {
            if (node.next == null)
                return null;

            current = current.next;
        }

        Node nth = node;
        
        while(current.next != null)
        {
            current = current.next;
            nth = nth.next;
        }
        
        return nth;
    }
}
