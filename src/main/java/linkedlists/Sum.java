/*
   
   You have two numbers represented by a linked list,
   where each node contains a single digit. The digits are stored in reverse
   order, such that the 1’s digit is at the head of the list.
   Write a function that adds the two numbers and returns the sum as a linked list.
   EXAMPLE
   Input: (3 -> 1 -> 5),
          (5 -> 9 -> 2)
   Output: 8 -> 0 -> 8
 
*/

package linkedlists;

import stacksandqueues.Node;

/**
 *
 * @author Reza Amini
 */
public class Sum {
    public static void main(String[] args) {
        Node num1 = new Node(9);
        num1.appendNode(8);
        num1.appendNode(5);
        System.out.println(num1);
        
        Node num2 = new Node(3);
        num2.appendNode(6);
        num2.appendNode(4);
        System.out.println(num2);
        
        System.out.println(sum(num1, num2));
        
        Node n = sum(0, num1, num2);
        System.out.println(sum(0, num1, num2));
    }

    /*
     * Recursive
     * Time complexity: O(max(n1, n2))
     */
    public static Node sum(int carry, Node n1, Node n2) {
        if (n1 == null && n2 == null)
        {
            Node output = new Node(carry);
            output.next = null;
            return output;
        }    
            
        int num = carry;
        if(n1 != null)
            num += (Integer)(n1.data);

        if (n2 != null)
            num += (Integer)(n2.data);

        Node output = new Node (num % 10);
        output.next = sum(num >= 10 ? 1 : 0,
                          n1 == null ? null : n1.next,
                          n2 == null ? null : n2.next);

        return output;
    }
    
    /*
     * Non-Recursive
     * Time complexity: O(max(n1, n2))
     */
    public static Node sum(Node n1, Node n2) 
    {
        int carry = 0;
        Node out = new Node(0);
        Node n1Copy = n1;
        Node n2Copy = n2;
        while(n1Copy != null && n2Copy != null)
        {
            int temp = (Integer)(n1Copy.data) + (Integer)(n2Copy.data) + carry;
            Node tempNode = new Node(temp % 10);
            out.appendNode(tempNode);
            carry = temp / 10;
            n1Copy = n1Copy.next;
            n2Copy = n2Copy.next;
        }
        
        while(n1Copy != null)
        {
            int temp = (Integer)(n1.data)+ carry;
            Node tempNode = new Node(temp % 10);
            out.appendNode(tempNode);
            carry = temp / 10;
            n1Copy = n1Copy.next;
        }
        
        while(n2Copy != null)
        {
            int temp = (Integer)(n2.data)+ carry;
            Node tempNode = new Node(temp % 10);
            out.appendNode(tempNode);
            carry = temp / 10;
            n2Copy = n2Copy.next;
        }
        
        if(carry > 0)
        {
            Node tempNode = new Node(carry);
            out.appendNode(tempNode);
        }
        
        return out.next;
    }
}
