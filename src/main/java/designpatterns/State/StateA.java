
package designpatterns.State;

/**
 *
 * @author rezaamini
 */
public class StateA implements State
{
    public void doSomething(Context context)
    {
        System.out.println("I am coming from StateA class.");
        context.setState(this);
    }
    
    public String toString()
    {
        return "StateA";
    }
}
