
package designpatterns.Factory;

/**
 *
 * @author rezaamini
 */
public class TwoProduct implements IProduct {
    
    static 
    {
        System.out.println("Registering TwoProduct ...");
        ProductFactory.instance().registerProduct("ID2", new TwoProduct());
    }
    
    public TwoProduct create()
    {
        return new TwoProduct();
    }
    
    public void doSomething()
    {
        System.out.println("I am coming from TwoProduct class.");
    }
}