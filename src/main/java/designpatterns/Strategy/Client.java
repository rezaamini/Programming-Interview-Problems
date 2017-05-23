package designpatterns.Strategy;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args)
    {
        Robot r1 = new Robot("Robot1");
        Robot r2 = new Robot("Robot2");
        Robot r3 = new Robot("Robot3");
        
        r1.setBehavior(new AgressiveBehavior());
        r2.setBehavior(new CalmBehavior());
        r3.setBehavior(new DefensiveBehavior());
        
        r1.move();
        r2.move();
        r3.move();
    }
}
