
package designpatterns.Principles.InterfaceSegregation;

/**
 *
 * @author rezaamini
 */
public class FastWorker implements IWorkable, IFeedable // or IWorker
{
    @Override
    public void work()
    {
        System.out.println("I am coming from FastWorker class, work() method.");
    }
    
    @Override
    public void eat()
    {
        System.out.println("I am coming from FastWorker class, eat() method.");
    }
}
