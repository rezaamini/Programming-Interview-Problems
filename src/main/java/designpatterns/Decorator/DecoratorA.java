
package designpatterns.Decorator;

/**
 *
 * @author rezaamini
 */
public class DecoratorA extends Decorator
{
    public DecoratorA(Component component)
    {
        super(component);
    }
    
    public void doSomething()
    {
        component.doSomething();
        doA();
    }
    
    public void doA()
    {
        System.out.println("I am coming from DecoratorA class.");
    }
}
