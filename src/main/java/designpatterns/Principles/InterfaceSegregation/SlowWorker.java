
package designpatterns.Principles.InterfaceSegregation;

/**
 *
 * @author rezaamini
 */
public class SlowWorker implements IWorkable, IFeedable
{
    @Override
    public void work()
    {
        System.out.println("I am coming from SlowWorker class, work() method.");
    }
    
    @Override
    public void eat()
    {
        System.out.println("I am coming from SlowWorker class, eat() method.");
    }
}
