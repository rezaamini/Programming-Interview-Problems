package StackAndQueue;


import java.util.Stack;

/*
 * Create a stack such that the minimum element of all the elements seen so far 
 * can be retrieved in constant time O(1). 
 */
/**
 *
 * @author Reza Amini
 */
public class MinStack
{
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public void push(int value)
    {
        if(minStack.isEmpty() || value < minStack.peek())
        {
            stack.push(value);
            minStack.push(value);
        }
        else
            stack.push(value);
    }
    
    public int pop()
    {
        if(stack.peek() == minStack.peek())
            minStack.pop();
        return stack.pop();
    }
    
    public int getMin()
    {
        return minStack.peek();
    }
}
