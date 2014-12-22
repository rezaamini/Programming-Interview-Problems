package Obsever;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rezaamini
 */
public class Observeable {
    private int state;
    private List<Observer> observers = new ArrayList<Observer>();

    public int getState() {
        return state;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }
    
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }
    
    public void notifyAllObservers()
    {
     for(Observer o: observers)
         o.update();
    }
}
