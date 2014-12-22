package Obsever;

/**
 *
 * @author rezaamini
 */
public class ObserverB extends Observer
{
    public ObserverB(Observeable observeable)
    {
        this.observeable = observeable;
        this.observeable.attach(this);
    }
    @Override
    public void update() {
        System.out.println("I am coming from ObserverB class. State: " 
                + this.observeable.getState());
    }
    
}
