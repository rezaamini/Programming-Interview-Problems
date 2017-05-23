
package designpatterns.Principles.DependencyInversion;

/**
 *
 * @author rezaamini
 */
public class Client {
    IWorker worker;
    
    public void setWorker(IWorker w)
    {
        worker = w;
    }
    
    public void work()
    {
        worker.work();
    }
}
