package TemplateMethod;

/**
 *
 * @author rezaamini
 */
public class Football extends Game
{

    @Override
    public void doInitialize() {
        System.out.println("I am coming from Football class, doInitialize() method.");
    }

    @Override
    public void doStart() {
        System.out.println("I am coming from Football class, doStart() method.");
    }

    @Override
    public void doEnd() {
        System.out.println("I am coming from Football class, doEnd() method.");
    }
    
}
