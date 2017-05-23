/*

   Write a program to sort a stack in ascending order.
   You should not make any assumptions about how the stack is implemented. 
   The following are the only functions that should be used to write this
   program: push | pop | peek | isEmpty.
 
*/

package stacksandqueues;

import java.util.Random;

/**
 *
 * @author Reza Amini
 */
public class SortStack 
{

    // Time complexity: O(N^2)
    // Space complexity: O(N)
    public static Stack sort(Stack stack)
    {
        Stack buffer = new Stack();

        while(!stack.isEmpty())
        {
            int temp = (Integer)(stack.pop().data);

            while(!buffer.isEmpty() && (Integer)(buffer.peek().data) < temp)
                stack.push((Integer)(buffer.pop().data));

            buffer.push(temp);
        }

        return buffer;
    }
    
    public static void main(String[] args)
    {
        Stack stack = new Stack();
        Random r = new Random();
        for(int i = 1; i < 11; i++){
            int item = r.nextInt(10);
            stack.push(item);
            System.out.print(item + "\t");
        }

        System.out.println();
        stack = sort(stack);

        while(!stack.isEmpty())
            System.out.print((Integer)(stack.pop().data) + "\t");

        System.out.println();
    }
}