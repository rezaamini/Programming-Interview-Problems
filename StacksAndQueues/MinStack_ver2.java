package Stacks_And_Queues;

import java.util.Stack;

/**
 *
 * @author Reza Amini
 */
public class MinStack_ver2 extends Stack<MinNode>
{
    public void push(int value)
    {
        int min = Math.min(value, min());
        MinNode n = new MinNode(value, min);
        push(n);
    }
    
    public int min()
    {
        if(this.isEmpty())
            return Integer.MAX_VALUE;
        else
            return peek().min;
    }
}

class MinNode
{
    int value;
    int min;
    MinNode next;
    
    public MinNode(int value, int min)
    {
        this.value = value;
        this.min = min;
    }
}

class Tester {
    public static void main(String[] args) {
        MinStack_ver2 stack = new MinStack_ver2();

        // Pushing elemets inside the stacks
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peeking elements
        System.out.println("Peek stack: " + stack.peek().value);

        // Get the minimum
        System.out.println("Stack min: " + stack.min());

        // Poping elements
        System.out.println("Pop stack: " + stack.pop().value);
        System.out.println("Pop stack: " + stack.pop().value);
        System.out.println("Pop stack: " + stack.pop().value);

    }
}