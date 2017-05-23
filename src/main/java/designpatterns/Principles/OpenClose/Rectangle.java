
package designpatterns.Principles.OpenClose;

/**
 *
 * @author rezaamini
 */
public class Rectangle extends Shape{
    @Override
    public void draw()
    {
        System.out.println("I am coming from Rectangle class.");
    }
}
