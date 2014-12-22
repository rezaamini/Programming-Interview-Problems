
package DependencyInjection;

/**
 *
 * @author rezaamini
 */
public class Client implements ServiceSetter { // Interface Injection
    private Service service;
    
    // Not using dependency injection
    public Client()
    {
        this.service = new ServiceA(); // dependency is hard coded
    }
    
    // Constructor Injection
    public Client(Service service)
    {
        this.service = service;
    }
    
    // Setter Injection & Interface Injection
    public void setService(Service service)
    {
        this.service = service;
    }
    
    public void greet()
    {
        System.out.println("Hello " + this.service.getName());
    }
}
