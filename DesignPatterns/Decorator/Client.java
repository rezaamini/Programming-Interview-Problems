
package Decorator;

/**
 *
 * @author rezaamini
 */
public class Client {
    public static void main(String[] args)
    {
        Component c1 = new ComponentA(); // Simple component
        Component c2 = new DecoratorA(new ComponentA()); // ComponentA decorated by DecoratorA
        Component c3 = new DecoratorB(new ComponentA()); // ComponentA decorated by DecoratorB
        Component c4 = new DecoratorB(new ComponentB()); // ComponentB decorated by DecoratorB
        
        c1.doSomething();
        System.out.println("---");
        c2.doSomething();
        System.out.println("---");
        c3.doSomething();
        System.out.println("---");
        c4.doSomething();
    }
}
