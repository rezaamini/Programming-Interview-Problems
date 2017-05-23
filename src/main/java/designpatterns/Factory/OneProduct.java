
package designpatterns.Factory;

/**
 *
 * @author rezaamini
 */
public class OneProduct implements IProduct {
    
    static 
    {
        System.out.println("Registering OneProduct ...");
        ProductFactory.instance().registerProduct("ID1", new OneProduct());
    }
    
    public OneProduct create()
    {
        return new OneProduct();
    }
    
    public void doSomething()
    {
        System.out.println("I am coming from OneProduct class.");
    }
}
