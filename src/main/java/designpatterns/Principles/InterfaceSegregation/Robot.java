
package designpatterns.Principles.InterfaceSegregation;

/**
 *
 * @author rezaamini
 */
public class Robot implements IWorkable{
    @Override
    public void work()
    {
        System.out.println("I am coming from Robot class.");
    }
}
