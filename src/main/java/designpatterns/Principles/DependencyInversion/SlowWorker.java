
package designpatterns.Principles.DependencyInversion;

/**
 *
 * @author rezaamini
 */
public class SlowWorker implements IWorker{
    public void work()
    {
        System.out.println("I am coming from SlowWorker class.");
    }
}
