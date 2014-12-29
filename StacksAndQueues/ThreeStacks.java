/*
   
   Describe how you could use a single array to implement three stacks.
 
*/

package StacksAndQueues;

import java.util.ArrayList;

/**
 *
 * @author Reza Amini
 */

// In this approach the space allocation of the stacks are static.
// Every stack gets 1/3 of the total space of the array.
public class ThreeStacks 
{
    int stackSize = 100; // the size of each stack in the array
    int[] threeStack = new int[3 * stackSize];
    int[] stackPointers = {0, 0, 0};

    public int pop(int stackNum) 
    {
        int pointer = stackPointers[stackNum] + stackNum * stackSize ;
        if (!isEmpty(stackNum)) 
        {
            int item = threeStack[pointer];
            stackPointers[stackNum]--;
            threeStack[pointer] = 0; // not important
            return item;
        }
        else 
            return 0; // assuming the empty cells contain 0
    }

    public void push(int stackNum, int data) 
    {
        int pointer = stackPointers[stackNum] + stackNum * stackSize ;
        if (!isFull(stackNum)) 
        {
            stackPointers[stackNum]++;
            threeStack[pointer + 1] = data;
        }
    }

    public int peek(int stackNum) 
    {
        int pointer = stackPointers[stackNum] + stackNum * stackSize ;
        if (!isEmpty(stackNum)) 
        {
            int item = threeStack[pointer];
            return item;
        }
        else
            return 0;
    }

    public boolean isEmpty(int stackNum) 
    {
        return (stackPointers[stackNum] == stackNum * stackSize);
    }

    public boolean isFull(int stackNum) 
    {
        return (stackPointers[stackNum] == stackSize);
    }
}

// In this approach the space allocation is dynamic. So, every stack can grow 
// as long as the array is not full yet.
// The only problem is that we are increasing the space complexity.
class ThreeStacks_approach2 
{
    int stackSize = 100;
    int[] stackPointers = {-1, -1, -1};
    StackNode[] threeStack = new StackNode[stackSize * 3];
    ArrayList freeIndex = new ArrayList(); // Free indeces in the array

    public ThreeStacks_approach2() 
    {
        for (int i = 0 ; i < stackSize*3 ; i++) 
            freeIndex.add(i);
    }

    class StackNode 
    {
        public int prevoius;
        public int value;
        public StackNode(int p, int v) 
        {
            prevoius = p;
            value = v;
        }
    }

    public void push(int stackNum, int v) 
    {
        int lastIndex = stackPointers[stackNum];
        if (freeIndex.size() > 0) 
        {
            stackPointers[stackNum] = (Integer)freeIndex.remove(0);
            threeStack[stackPointers[stackNum]] = new StackNode(lastIndex, v);
        }
    }

    public int pop(int stackNum) {
        int lastIndex = stackPointers[stackNum];
        if (lastIndex >= 0) {
            int value = threeStack[lastIndex].value;
            stackPointers[stackNum] = threeStack[lastIndex].prevoius;
            threeStack[lastIndex] = null;
            freeIndex.add(lastIndex);
            return value;
        }
        return 0;
    }

    public int peek(int stackNum) {
        return threeStack[stackPointers[stackNum]].value;
    }

    public boolean isEmpty(int stackNum) {
        return (stackPointers[stackNum] == -1);
    }

    public boolean isFull(int stackNum) {
        return (freeIndex.size() == stackSize * 3);
    }
}

class ThreeStacks_Tester {
    public static void main(String[] args) {
        ThreeStacks_approach2 threeStack = new ThreeStacks_approach2();

        // Pushing elemets inside the stacks
        threeStack.push(0, 1);
        threeStack.push(0, 2);
        threeStack.push(0, 3);
        
        threeStack.push(1, 1);
        threeStack.push(1, 2);
        threeStack.push(1, 3);
        
        threeStack.push(2, 1);
        threeStack.push(2, 2);
        threeStack.push(2, 3);

        // Peeking elements
        System.out.println("Peek stack 0:" + threeStack.peek(0));
        System.out.println("Peek stack 1:" + threeStack.peek(1));
        System.out.println("Peek stack 2:" + threeStack.peek(1));

        // Poping elements
        System.out.println("Pop stack 0:" + threeStack.pop(0));
        System.out.println("Pop stack 1:" + threeStack.pop(1));
        System.out.println("Pop stack 1:" + threeStack.pop(1));
        System.out.println("Pop stack 2:" + threeStack.pop(2));
        System.out.println("Pop stack 2:" + threeStack.pop(2));
        System.out.println("Pop stack 2:" + threeStack.pop(2));

        // Poping elements when the stack is empty
        System.out.println("Pop stack 2:" + threeStack.pop(2));
    }
}
