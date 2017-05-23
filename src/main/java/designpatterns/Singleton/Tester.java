
package designpatterns.Singleton;

/**
 *
 * @author rezaamini
 */
public class Tester {
    public static void main(String[] args)
    {
        Singleton instance = Singleton.getInstance();
        instance.doSomthing();
        
        EnumSingleton.INSTANCE.doSomthing();
    }
}
