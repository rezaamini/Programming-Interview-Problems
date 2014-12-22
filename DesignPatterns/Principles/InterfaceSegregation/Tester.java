
package Principles.InterfaceSegregation;

/**
 *
 * @author rezaamini
 */
public class Tester {
    public static void main(String[] args)
    {
        Client c = new Client();
        c.setWorker(new Robot());
        c.work();
        
        c.setWorker(new FastWorker());
        c.work();
        
        c.setWorker(new SlowWorker());
        c.work();
    }
}
