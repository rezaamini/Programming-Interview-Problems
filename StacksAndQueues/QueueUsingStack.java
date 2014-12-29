/*

   Implement a QueueUsingStack class which implements a queue using two stacks.
 
*/

package StacksAndQueues;

/**
  * @author Reza Amini
 */
public class QueueUsingStack 
{
    // I use the Stack class provided in my StacksAndQueues package
    Stack stack1;
    Stack stack2;

    public QueueUsingStack()
    {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void add(int data)
    {
        stack1.push(data);
    }

    public int size()
    {
        return stack1.size() + stack2.size();
    }

    /* 
     * We use stack2 as the buffer. At the remove time, we pop all
     * elements in stack1 and put them in stack2. In this way the order of
     * elements is reversed. However, if back-to-back pops happen, we don't need
     * to move elements back to stack1 again. So, we keep elements in stack2
     * after the first pop.
     */
    public Node remove()
    {
        if (!stack2.isEmpty())
            return stack2.pop();

        while(!stack1.isEmpty())
                stack2.push((Integer)(stack1.pop().data));

        return stack2.pop();
    }

    // Works the same as pop
    public Node peek()
    {
        if (!stack2.isEmpty())
            return stack2.peek();

        while(!stack1.isEmpty())
                stack2.push((Integer)(stack1.pop().data));

        return stack2.peek();
    }

    public boolean isEmpty()
    {
        return (size() == 0);
    }
}

class QueueUsingStack_Tester
{
    public static void main(String[] args)
    {
        QueueUsingStack queue = new QueueUsingStack();

        for(int i = 1; i < 11; i++)
        {
            queue.add(i);
            System.out.println(i +
                    " is added. The queue size is " + queue.size() + ".");
        }

        while(!queue.isEmpty())
            System.out.println(queue.remove().data +
                    " is removed. The queue size is " + queue.size() + ".");
    }
}
