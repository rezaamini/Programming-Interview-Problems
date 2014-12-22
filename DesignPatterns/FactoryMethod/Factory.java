
package FactoryMethod;

/**
 *
 * @author rezaamini
 */
public abstract class Factory {
    public abstract IProduct factoryMethod();
    
    public void doSomething()
    {
        System.out.println("I am coming from Factory class.");
    }
}
