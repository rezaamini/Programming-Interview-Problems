
package Singleton;

/**
 *
 * @author rezaamini
 */
public class Singleton {
    private static Singleton instance;
    
    // OR
    
    // Early instantiation, it is THREAD-SAFE without synchronized
    //private static Singleton instance = new Singleton();
    
    public Singleton()
    {
        
    }
    
    // synchronized makes the Singleton pattern therad-safe
    public static synchronized Singleton getInstance()
    {
        // Lazy instantiation
        if(instance == null)
            instance = new Singleton();
        
        return instance;
    }
    
    // OR
    
    // double locking
    /*
    public static Singleton getInstance()
    {
        if(instance == null)
        {
            synchronized(Singleton.class)
            {
                if(instance == null)
                    instance = new Singleton();
            }
        }
            
        
        return instance;
    }
    */
    
    public void doSomthing()
    {
        System.out.println("I am coming from Singleton class.");
    }
}
