
package designpatterns.Decorator;

/**
 *
 * @author rezaamini
 */
public class DecoratorB extends Decorator
{
    public DecoratorB(Component component)
    {
        super(component);
    }
    
    public void doSomething()
    {
        component.doSomething();
        doB();
    }
    
    public void doB()
    {
        System.out.println("I am coming from DecoratorB class.");
    }
}
