package TemplateMethod;

/**
 *
 * @author rezaamini
 */
public class Tennis extends Game
{

    @Override
    public void doInitialize() {
        System.out.println("I am coming from Tennis class, doInitialize() method.");
    }

    @Override
    public void doStart() {
        System.out.println("I am coming from Tennis class, doStart() method.");
    }

    @Override
    public void doEnd() {
        System.out.println("I am coming from Tennis class, doEnd() method.");
    }
    
}
