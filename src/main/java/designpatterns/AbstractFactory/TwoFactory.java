package designpatterns.AbstractFactory;

/**
 *
 * @author rezaamini
 */
public class TwoFactory extends Factory {

    @Override
    public ProductA createProductA() {
        return new ProductA2("ProductA2");
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2("ProductB2");
    }
    
}
