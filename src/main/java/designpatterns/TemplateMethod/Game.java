
package designpatterns.TemplateMethod;

/**
 *
 * @author rezaamini
 */
public abstract class Game {
    public final void play()
    {
        doInitialize();
        doStart();
        doEnd();
    }
    
    public abstract void doInitialize();
    public abstract void doStart();
    public abstract void doEnd();
}
