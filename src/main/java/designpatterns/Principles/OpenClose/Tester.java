
package designpatterns.Principles.OpenClose;

/**
 *
 * @author rezaamini
 */
public class Tester {
    public static void main(String[] args)
    {
        Client c = new Client();
        c.draw(new Rectangle());
        c.draw(new Circle());
    }
}
