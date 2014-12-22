
package State;

/**
 *
 * @author rezaamini
 */
public class StateB implements State
{
    public void doSomething(Context context)
    {
        System.out.println("I am coming from StateB class.");
        context.setState(this);
    }
    
    public String toString()
    {
        return "StateB";
    }
}
