package Factory;

/**
 *
 * @author rezaamini
 */
public class Client {
    static
    {
        System.out.println("Registering products ...");
        try
        {
            Class.forName("Factory.OneProduct");
            Class.forName("Factory.TwoProduct");
        }
        catch (ClassNotFoundException any)
        {
            any.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        ProductFactory factory = ProductFactory.instance();
        
        /*
        // This approach violates open-close principle
        IProduct oneProduct = factory.createProduct("ID1");
        IProduct twoProduct = factory.createProduct("ID2");
        
        oneProduct.doSomething();
        twoProduct.doSomething();
        */
        
        IProduct one = factory.create("ID1");
        IProduct two = factory.create("ID2");
        one.doSomething();
        two.doSomething();
    }
}