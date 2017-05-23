
package designpatterns.Strategy;

/**
 *
 * @author rezaamini
 */
public class Robot {
    private IBehavior behavior;
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public IBehavior getBehavior() {
        return behavior;
    }

    public String getName() {
        return name;
    }

    public void setBehavior(IBehavior behavior) {
        this.behavior = behavior;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void move()
    {
        System.out.println(name + " is moving ...");
        behavior.move();
    }
    
}
