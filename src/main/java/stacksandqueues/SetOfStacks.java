/*

   Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
   Therefore, in real life, we would likely start a new stack when the previous
   stack exceeds some threshold. Implement a data structure SetOfStacks that
   mimics this. SetOfStacks should be composed of several stacks, and should
   create a new stack once the previous one exceeds capacity. SetOfStacks.push()
   and SetOfStacks.pop() should behave identically to a single stack (that is,
   pop() should return the same values as it would if there were just a single stack).
  
   FOLLOW UP
   Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 
*/

package stacksandqueues;

import java.util.ArrayList;

/**
 *
 * @author Reza Amini
 */
public class SetOfStacks {
    public ArrayList<Stack> setOfStack; // I use the Stack class provided in my src.stacksandqueues package
    public int stackThreshold;
    public int counter;

    public SetOfStacks(int st) {
        this.setOfStack = new ArrayList<Stack>();
        this.stackThreshold = st;
        this.counter = 0;
    }

    public Stack getLastStack() {
        Stack lastStack = setOfStack.get(setOfStack.size() - 1);

        return lastStack;
    }

    public Node pop() {
        Node item = null;
        if (!setOfStack.isEmpty()) { // Stack is not empty
            Stack lastStack = getLastStack();
            item = lastStack.pop();
            counter--;
            if (counter % stackThreshold == 0)
                setOfStack.remove(lastStack);
        }
        
        return item;
    }

    public void push(int d) {
        if (counter % stackThreshold == 0) {// Last stack is full
            setOfStack.add(new Stack());
        }

        Stack lastStack = getLastStack();
        lastStack.push(d);
        counter++;
    }

    public boolean isEmpthy() {
        return (counter == 0);
    }

    public Node popAt(int index) {
        Node item = null;
        Stack stack = setOfStack.get(index);
        if (!stack.isEmpty() && stack != null) { // Stack is not empty
            item = stack.pop();
            counter--;
            if (stack.isEmpty())
                setOfStack.remove(stack);
        }

        return item;
    }
}

class SetOfStacks_Tester {
    public static void main(String[] args) {
        SetOfStacks setOfStack = new SetOfStacks(5);

        for (int i = 0 ; i < 23 ; i++) {
            setOfStack.push(i);
        }

        System.out.println("Number of stacks in the list: " + 
                setOfStack.setOfStack.size());

        for (int i = 0 ; i < 23 ; i++) {
            System.out.println(setOfStack.popAt(0));
        }
    }
}
