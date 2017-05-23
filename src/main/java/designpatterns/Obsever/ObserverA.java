package designpatterns.Obsever;

/**
 *
 * @author rezaamini
 */
public class ObserverA extends Observer
{
    public ObserverA(Observeable observeable)
    {
        this.observeable = observeable;
        this.observeable.attach(this);
    }
    @Override
    public void update() {
        System.out.println("I am coming from ObserverA class. State: " 
                + this.observeable.getState());
    }
    
}
