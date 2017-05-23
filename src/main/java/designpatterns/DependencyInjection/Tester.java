
package designpatterns.DependencyInjection;

/**
 *
 * @author rezaamini
 */
public class Tester {
    public static void main(String[] args)
    {
        Service a = new ServiceA();
        Service b = new ServiceB();
        
        // Using Constructor Injection
        Client clientA = new Client(a);
        clientA.greet();
        
        // Using Setter Injection & Interface Injection
        Client clientB = new Client();
        clientB.setService(b);
        clientB.greet();
    }
}
