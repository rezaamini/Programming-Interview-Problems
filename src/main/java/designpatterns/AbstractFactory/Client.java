
package designpatterns.AbstractFactory;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args)
    {
        Factory factory = FactoryMaker.getFactory("1");
        factory.createProductA();
        factory.createProductB();
        
        factory = FactoryMaker.getFactory("2");
        factory.createProductA();
        factory.createProductB();
    }
}
