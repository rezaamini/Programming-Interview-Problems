
package FactoryMethod;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args)
    {
        Factory factory = new OneFactory();
        factory.doSomething();
        
        IProduct p1 = factory.factoryMethod();
        p1.doSomething();
        
        factory = new TwoFactory();
        factory.doSomething();
        IProduct p2 = factory.factoryMethod();
        p2.doSomething();
    }
}
