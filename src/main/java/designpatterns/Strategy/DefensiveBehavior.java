package designpatterns.Strategy;

/**
 *
 * @author rezaamini
 */
public class DefensiveBehavior implements IBehavior {

    @Override
    public void move() {
        System.out.println("I am from DefensiveBehaior class.");
    }
    
}
