
package Principles.DependencyInversion;

/**
 *
 * @author rezaamini
 */
public class FastWorker implements IWorker{
    public void work()
    {
        System.out.println("I am coming from FastWorker class.");
    }
}
