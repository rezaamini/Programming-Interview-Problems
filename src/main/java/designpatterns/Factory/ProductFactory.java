package designpatterns.Factory;

import java.util.HashMap;

/**
 *
 * @author rezaamini
 */
public class ProductFactory 
{
    // First approach superts open-close principle
    // Singleton
    private static ProductFactory factory = new ProductFactory();
    private ProductFactory(){}
    public static ProductFactory instance()
    {
        return factory;
    }
    
    private HashMap registeredProducts = new HashMap();
    public void registerProduct(String id, IProduct product)
    {
        registeredProducts.put(id, product);
    }
    
    public IProduct create(String id)
    {
        IProduct product = (IProduct)registeredProducts.get(id);
        return product.create();
    }
    
    
    // Second approach which is violating open-close princile
    public IProduct createProduct(String productID)
    {
        if(productID.equals("ID1"))
            return new OneProduct();
        if(productID.equals("ID2"))
            return new TwoProduct();
        return null;
    }
}
