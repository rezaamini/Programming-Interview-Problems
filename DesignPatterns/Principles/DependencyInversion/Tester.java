
package Principles.DependencyInversion;

/**
 *
 * @author rezaamini
 */
public class Tester {
    public static void main(String[] args)
    {
        Client c = new Client();
        c.setWorker(new FastWorker());
        c.work();
        
        c.setWorker(new SlowWorker());
        c.work();
    }
}
