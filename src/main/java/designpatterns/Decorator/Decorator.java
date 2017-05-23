
package designpatterns.Decorator;

/**
 *
 * @author rezaamini
 */
public class Decorator implements Component
{
    protected Component component;
    
    public Decorator(Component component)
    {
        this.component = component;
    }
    
    @Override
    public void doSomething()
    {
        component.doSomething();
    }
}
