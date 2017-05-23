
package designpatterns.FactoryMethod;

/**
 *
 * @author rezaamini
 */
public class TwoFactory extends Factory {
    public IProduct factoryMethod()
    {
        return new TwoProduct();
    }
    
    @Override
    public void doSomething()
    {
        System.out.println("I am coming from TwoFactory class.");
    }
}
