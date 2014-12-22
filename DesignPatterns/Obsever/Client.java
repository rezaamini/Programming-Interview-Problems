package Obsever;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args)
    {
        Observeable observeable = new ObserveableA();
        
        Observer o1 = new ObserverA(observeable);
        Observer o2 = new ObserverB(observeable);
        
        System.out.println("State is updated to 10 ...");
        observeable.setState(10);
        
        System.out.println("State is updated to 15 ...");
        observeable.setState(15);
        
    }
}
