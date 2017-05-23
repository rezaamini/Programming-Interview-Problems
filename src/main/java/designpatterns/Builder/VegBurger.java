
package designpatterns.Builder;

/**
 *
 * @author rezaamini
 */
public class VegBurger extends Burger
{

    @Override
    public String name() {
        return "Vegie Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
    
}
