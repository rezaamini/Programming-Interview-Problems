package designpatterns.AbstractFactory;

/**
 *
 * @author rezaamini
 */
public class OneFactory extends Factory {

    @Override
    public ProductA createProductA() {
        return new ProductA1("ProductA1");
    }

    @Override
    public ProductB createProductB() {
        return new ProductB1("ProductB1");
    }
    
}
