
package FactoryMethod;

/**
 *
 * @author rezaamini
 */
public class OneFactory extends Factory {
    @Override
    public IProduct factoryMethod()
    {
        return new OneProduct();
    }
    
    @Override
    public void doSomething()
    {
        System.out.println("I am coming from OneFactory class.");
    }
}
