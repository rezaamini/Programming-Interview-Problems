package designpatterns.AbstractFactory;

/**
 *
 * @author rezaamini
 */
public class FactoryMaker {
    // We use SIngleton pattern here
    private static Factory factory;
    public static Factory getFactory(String factoryType)
    {
        if(factoryType.equals("1"))
            factory = new OneFactory();
        else if(factoryType.equals("2"))
            factory = new TwoFactory();
        else
            factory = null;
        return factory;
    }
}
