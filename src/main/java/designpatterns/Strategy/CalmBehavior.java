package designpatterns.Strategy;

/**
 *
 * @author rezaamini
 */
public class CalmBehavior implements IBehavior {

    @Override
    public void move() {
        System.out.println("I am from CalmBehaior class.");
    }
    
}
